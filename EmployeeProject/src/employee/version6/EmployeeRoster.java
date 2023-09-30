package employee.version6;

import java.util.ArrayList;

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

    public EmployeeRoster getEmployee(String name){
        EmployeeRoster list = new EmployeeRoster();
        name = name.toLowerCase();
        for(Employee employee : empList){
            String fullName = employee.getEmpName().getFirstName().toLowerCase() + " " +
                    employee.getEmpName().getMiddleName().toLowerCase() + " " +
                    employee.getEmpName().getLastName().toLowerCase();

            if (fullName.contains(name)) {
                list.addEmployee(employee);
            }
        }
        return list;
    }

    // Update method for CommissionEmployee
    public boolean updateEmployee(int id, Name newName, double totalSales) {
        for(Employee employee : empList){
            if (id == employee.getEmpId() && employee instanceof CommissionEmployee) {
                employee.setEmpName(newName);
                ((CommissionEmployee) employee).setTotalSales(totalSales);
                return true;
            }
        }
        return false;
    }

    public boolean updateEmployee(int id, Name newName, double rateOrSales, double additionalInfo) {
        for(Employee employee : empList){
            if (id == employee.getEmpId()) {
                employee.setEmpName(newName);

                if (employee instanceof HourlyEmployee) {
                    ((HourlyEmployee) employee).setRatePerHour((float)rateOrSales);
                    ((HourlyEmployee) employee).setTotalHoursWorked((float)additionalInfo);
                } else if (employee instanceof BasePlusCommissionEmployee) {
                    ((BasePlusCommissionEmployee) employee).setTotalSales(rateOrSales);
                    ((BasePlusCommissionEmployee)employee).setBaseSalary(additionalInfo);
                } else if (employee instanceof PieceWorkerEmployee) {
                    ((PieceWorkerEmployee) employee).setRatePerPiece((float)rateOrSales);
                    ((PieceWorkerEmployee) employee).setTotalPiecesFinished((int) additionalInfo);
                }
                return true;
            }
        }
        return false;
    }
}
