package employee.version4;

import java.util.Objects;

public class EmployeeRoster {
    Employee[] empList;
    private int count = 0;
    private int max = 0;


    public EmployeeRoster() {
        this.max = 10;
        empList = new Employee[this.max];
    }

    public EmployeeRoster(int max) {
        this.max = max;
        empList = new Employee[this.max];
    }

    public Employee[] getEmpList() {
        return empList;
    }

    public int getCount() {
        return count;
    }

    public int getMax() {
        return max;
    }

    public void displayAllEmployee(){
        System.out.printf("%-10s | %-40s | %-30s | %-20s\n", "ID", "NAME", "TYPE", "SALARY");
        for (int i = 0; i < this.count; i++) {
            Employee employee = empList[i];
            String fullName = employee.getEmpName().getFirstName() + " " + employee.getEmpName().getMiddleInitial() + " " + employee.getEmpName().getLastName();
            String employeeType = employee.getClass().getSimpleName();
            double salary;

            if (employee instanceof HourlyEmployee) {
                salary = ((HourlyEmployee) employee).computeSalary();
            } else if (employee instanceof PieceWorkerEmployee) {
                salary = ((PieceWorkerEmployee) employee).computeSalary();
            } else if (employee instanceof CommissionEmployee) {
                if (employee instanceof BasePlusCommissionEmployee) {
                    salary = ((BasePlusCommissionEmployee) employee).computeSalary();
                } else {
                    salary = ((CommissionEmployee) employee).computeSalary();
                }
            } else {
                salary = 0.0;
            }

            System.out.printf("%-10d | %-40s | %-30s | %-20.2f\n", employee.getEmpId(), fullName, employeeType, salary);
        }
    }

    public int countHE(){
        int numOfHE = 0;
        for(int i = 0; i < this.count; i++){
            if(empList[i] instanceof HourlyEmployee){
                numOfHE++;
            }
        }
        return numOfHE;
    }

    public int countPWE(){
        int numOfPWE = 0;
        for(int i = 0; i < this.count; i++){
            if(empList[i] instanceof PieceWorkerEmployee){
                numOfPWE++;
            }
        }
        return numOfPWE;
    }

    public int countCE(){
        int numOfCE = 0;
        for(int i = 0; i < this.count; i++){
            if(empList[i] instanceof CommissionEmployee && !(empList[i] instanceof BasePlusCommissionEmployee)){
                numOfCE++;
            }
        }

        return numOfCE;
    }

    public int countBPEC(){
        int numOfBPEC = 0;
        for(int i = 0; i < this.count; i++){
            if(empList[i] instanceof BasePlusCommissionEmployee){
                numOfBPEC++;
            }
        }
        return numOfBPEC;
    }

    public void displayHE(){
        System.out.println("HOURLY EMPLOYEE LIST");
        for(int i = 0; i < this.count; i++){
            if(empList[i] instanceof HourlyEmployee){
                empList[i].displayInfo();
            }
        }
    }

    public void displayPWE(){
        for(int i = 0; i < this.count; i++){
            if(empList[i] instanceof PieceWorkerEmployee){
                empList[i].displayInfo();
            }
        }
    }

    public void displayCE(){
        for(int i = 0; i < this.count; i++){
            if(empList[i] instanceof CommissionEmployee && !(empList[i] instanceof BasePlusCommissionEmployee)){
                empList[i].displayInfo();
            }
        }
    }

    public void displayBPCE(){
        for(int i = 0; i < this.count; i++){
            if(empList[i] instanceof BasePlusCommissionEmployee){
                empList[i].displayInfo();
            }
        }
    }

    public boolean addEmployee(Employee e){
        if(count >= max){
            return false;
        }
        empList[count] = e;
        this.count++;
        return true;
    }

    public boolean deleteEmployee(int id){
        for(int i = 0; i <= this.count; i++){
            if(id == empList[i].getEmpId()){
                for(int j = i; j <= this.count - 1; j++){
                    empList[j] = empList[j+1];
                }
                empList[this.count - 1] = null;
                --this.count;
                return true;
            }
        }
        return false;
    }

    public EmployeeRoster getEmployee(String word){
        EmployeeRoster list = new EmployeeRoster(this.count);
        word = word.toLowerCase();
        for(int i = 0; i < this.count; i++){
            String idPlusName = empList[i].getEmpId() + empList[i].getEmpName().getFirstName().toLowerCase()
                    + empList[i].getEmpName().getLastName().toLowerCase()
                    +  empList[i].getEmpName().getMiddleName().toLowerCase();
            if(idPlusName.contains(word)){
                list.addEmployee(empList[i]);
            }
        }
        return list;
    }

    //private method update Employee Name
    private boolean updateEmployeeName(int id, String newFirstName, String newLastName,  String newMiddleName) {
        boolean changes = false;
        for (int i = 0; i < this.count; i++) {
            if (id == empList[i].getEmpId()) {
                if (!Objects.equals(newFirstName, empList[i].getEmpName().getFirstName()) || Objects.equals(newFirstName, "")) {
                    empList[i].getEmpName().setFirstName(newFirstName);
                    changes = true;
                }
                if (!Objects.equals(newLastName, empList[i].getEmpName().getLastName()) || Objects.equals(newLastName, "")) {
                    empList[i].getEmpName().setLastName(newLastName);
                    changes = true;
                }
                if (!Objects.equals(newMiddleName, empList[i].getEmpName().getMiddleName()) || Objects.equals(newLastName, "")) {
                    empList[i].getEmpName().setMiddleName(newMiddleName);
                    changes = true;
                }
                return changes;
            }
        }
        return changes;
    }

    // Update method for CE
    public boolean updateEmployee(int id, String newFirstName, String newLastName, String newMiddleName, double totalSales) {
        boolean changes = false;
        for (int i = 0; i < this.count; i++) {
            if (id == empList[i].getEmpId() && empList[i] instanceof CommissionEmployee) {
                changes = updateEmployeeName(id, newFirstName, newLastName, newMiddleName);
                if(totalSales != ((CommissionEmployee) empList[i]).getTotalSales()){
                    ((CommissionEmployee) empList[i]).setTotalSales(totalSales);
                    changes = true;
                }
                return changes;
            }
        }
        return changes;
    }

    //Update method for HE, PWE, BPCE
    public boolean updateEmployee(int id, String newFirstName, String newLastName, String newMiddleName, double rateOrSales, double additionalInfo) {
        boolean changes = false;
        for (int i = 0; i < this.count; i++) {
            if(id == empList[i].getEmpId()){
                changes = updateEmployeeName(id, newFirstName, newLastName, newMiddleName);

                if (empList[i] instanceof HourlyEmployee) {
                    if(rateOrSales != ((HourlyEmployee) empList[i]).getRatePerHour()){
                        ((HourlyEmployee) empList[i]).setRatePerHour((float)rateOrSales);
                        changes = true;
                    }
                    if(additionalInfo != ((HourlyEmployee) empList[i]).getTotalHoursWorked()){
                        ((HourlyEmployee) empList[i]).setTotalHoursWorked((float)additionalInfo);
                        changes = true;
                    }
                } else if (empList[i] instanceof BasePlusCommissionEmployee) {
                    if(rateOrSales !=  ((BasePlusCommissionEmployee) empList[i]).getTotalSales()){
                        ((BasePlusCommissionEmployee) empList[i]).setTotalSales(rateOrSales);
                        changes = true;
                    }
                    if(additionalInfo != ((BasePlusCommissionEmployee) empList[i]).getBaseSalary()){
                        ((BasePlusCommissionEmployee) empList[i]).setBaseSalary(additionalInfo);
                        changes = true;
                    }
                } else if (empList[i] instanceof PieceWorkerEmployee) {
                    if( rateOrSales != ((PieceWorkerEmployee) empList[i]).getRatePerPiece()){
                        ((PieceWorkerEmployee) empList[i]).setRatePerPiece((float)rateOrSales);
                        changes = true;
                    }
                    if(additionalInfo !=  ((PieceWorkerEmployee) empList[i]).getTotalPiecesFinished()){
                        ((PieceWorkerEmployee) empList[i]).setTotalPiecesFinished((int) additionalInfo);
                        changes = true;
                    }
                }
                return changes;
            }
        }
        return changes;
    }
}
