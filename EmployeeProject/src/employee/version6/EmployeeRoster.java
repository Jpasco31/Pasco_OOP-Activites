package employee.version6;

import java.util.ArrayList;
import java.util.Objects;

public class EmployeeRoster {

    ArrayList<Employee> empList = new ArrayList<Employee>();

    public EmployeeRoster() {
    }

    public ArrayList<Employee>  getEmpList() {
        return empList;
    }

    public void displayAllEmployee(){
        System.out.printf("%-10s | %-40s | %-30s | %-20s\n", "ID", "NAME", "TYPE", "SALARY");
        for (Employee employee : empList) {
            String fullName = employee.getEmpName().getFirstName() + " " +
                    employee.getEmpName().getMiddleInitial() + " " +
                    employee.getEmpName().getLastName();
            String employeeType = employee.getClass().getSimpleName();
            double salary = employee.computeSalary();

            System.out.printf("%-10d | %-40s | %-30s | %-20.2f\n", employee.getEmpId(), fullName, employeeType, salary);
        }

    }

    public int countHE() {
        int numOfHE = 0;
        for (Employee employee : empList) {
            if (employee instanceof HourlyEmployee) {
                numOfHE++;
            }
        }
        return numOfHE;
    }

    public int countPWE(){
        int numOfPWE = 0;
        for(Employee employee : empList){
            if(employee instanceof PieceWorkerEmployee){
                numOfPWE++;
            }
        }
        return numOfPWE;
    }

    public int countCE(){
        int numOfCE = 0;
        for(Employee employee : empList){
            if(employee instanceof CommissionEmployee && !(employee instanceof BasePlusCommissionEmployee)){
                numOfCE++;
            }
        }

        return numOfCE;
    }

    public int countBPEC(){
        int numOfBPEC = 0;
        for(Employee employee : empList){
            if(employee instanceof BasePlusCommissionEmployee){
                numOfBPEC++;
            }
        }
        return numOfBPEC;
    }

    public void displayHE(){
        System.out.println("HOURLY EMPLOYEE LIST");
        for(Employee employee : empList){
            if(employee instanceof HourlyEmployee){
                employee.displayInfo();
            }
        }
    }

    public void displayPWE(){
        for(Employee employee : empList){
            if(employee instanceof PieceWorkerEmployee){
                employee.displayInfo();
            }
        }
    }

    public void displayCE(){
        for(Employee employee : empList){
            if(employee instanceof CommissionEmployee && !(employee instanceof BasePlusCommissionEmployee)){
                employee.displayInfo();
            }
        }
    }

    public void displayBPCE(){
        for(Employee employee : empList){
            if(employee instanceof BasePlusCommissionEmployee){
                employee.displayInfo();
            }
        }
    }

    public boolean addEmployee(Employee e) {
        return empList.add(e); // Return false if the element could not be added and true to indicate that the employee was added successfully
    }

    public boolean deleteEmployee(int id) {
        return empList.removeIf(employee -> employee.getEmpId() == id);
    }

    public EmployeeRoster getEmployee(String word){
        EmployeeRoster list = new EmployeeRoster();
        word = word.toLowerCase();
        for(Employee employee : empList){
            String idPlusName = employee.getEmpId() + employee.getEmpName().getFirstName().toLowerCase() +
                    employee.getEmpName().getMiddleName().toLowerCase() +
                    employee.getEmpName().getLastName().toLowerCase();

            if (idPlusName.contains(word)) {
                list.addEmployee(employee);
            }
        }
        return list;
    }

    //private method update Employee Name
    private boolean updateEmployeeName(int id, String newFirstName, String newLastName,  String newMiddleName) {
        boolean changes = false;
        for (Employee employee : empList) {
            if (id == employee.getEmpId()) {
                if (!Objects.equals(newFirstName,employee.getEmpName().getFirstName()) || Objects.equals(newFirstName, "")) {
                    employee.getEmpName().setFirstName(newFirstName);
                    changes = true;
                }
                if (!Objects.equals(newLastName, employee.getEmpName().getLastName()) || Objects.equals(newLastName, "")) {
                    employee.getEmpName().setLastName(newLastName);
                    changes = true;
                }
                if (!Objects.equals(newMiddleName, employee.getEmpName().getMiddleName()) || Objects.equals(newLastName, "")) {
                    employee.getEmpName().setMiddleName(newMiddleName);
                    changes = true;
                }
                return changes;
            }
        }
        return changes;
    }

    // Update method for CommissionEmployee
    public boolean updateEmployee(int id, String newFirstName, String newLastName, String newMiddleName, double totalSales) {
        boolean changes = false;
        for(Employee employee : empList){
            if (id == employee.getEmpId() && employee instanceof CommissionEmployee) {
                changes = updateEmployeeName(id, newFirstName, newLastName, newMiddleName);
                if(totalSales != ((CommissionEmployee) employee).getTotalSales()){
                    ((CommissionEmployee) employee).setTotalSales(totalSales);
                    changes = true;
                }
                return changes;
            }
        }
        return changes;
    }

    public boolean updateEmployee(int id, String newFirstName, String newLastName, String newMiddleName, double rateOrSales, double additionalInfo) {
        boolean changes = false;
        for(Employee employee : empList){
            if(id == employee.getEmpId()){
                changes = updateEmployeeName(id, newFirstName, newLastName, newMiddleName);

                if (employee instanceof HourlyEmployee) {
                    if(rateOrSales != ((HourlyEmployee)employee).getRatePerHour()){
                        ((HourlyEmployee) employee).setRatePerHour((float)rateOrSales);
                        changes = true;
                    }
                    if(additionalInfo != ((HourlyEmployee) employee).getTotalHoursWorked()){
                        ((HourlyEmployee) employee).setTotalHoursWorked((float)additionalInfo);
                        changes = true;
                    }
                } else if (employee instanceof BasePlusCommissionEmployee) {
                    if(rateOrSales !=  ((BasePlusCommissionEmployee) employee).getTotalSales()){
                        ((BasePlusCommissionEmployee) employee).setTotalSales(rateOrSales);
                        changes = true;
                    }
                    if(additionalInfo != ((BasePlusCommissionEmployee) employee).getBaseSalary()){
                        ((BasePlusCommissionEmployee) employee).setBaseSalary(additionalInfo);
                        changes = true;
                    }
                } else if (employee instanceof PieceWorkerEmployee) {
                    if( rateOrSales != ((PieceWorkerEmployee) employee).getRatePerPiece()){
                        ((PieceWorkerEmployee) employee).setRatePerPiece((float)rateOrSales);
                        changes = true;
                    }
                    if(additionalInfo !=  ((PieceWorkerEmployee) employee).getTotalPiecesFinished()){
                        ((PieceWorkerEmployee) employee).setTotalPiecesFinished((int) additionalInfo);
                        changes = true;
                    }
                }
                return changes;
            }
        }
        return changes;
    }
}
