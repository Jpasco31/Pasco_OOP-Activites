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

    public EmployeeRoster getEmployee(String name){
        EmployeeRoster list = new EmployeeRoster(this.count);
        name = name.toLowerCase();
        for(int i = 0; i < this.count; i++){
            if(Objects.equals(name, empList[i].getEmpName().getFirstName().toLowerCase())
                    || Objects.equals(name, empList[i].getEmpName().getLastName().toLowerCase())
                    || Objects.equals(name, empList[i].getEmpName().getMiddleName().toLowerCase()) ){
                list.addEmployee(empList[i]);
            }
        }
        return list;
    }

    // Update method for CE
    public boolean updateEmployee(int id, Name newName, double totalSales) {
        for (int i = 0; i < this.count; i++) {
            if (id == empList[i].getEmpId() && empList[i] instanceof CommissionEmployee) {
                empList[i].setEmpName(newName);
                ((CommissionEmployee) empList[i]).setTotalSales(totalSales);
                return true;
            }
        }
        return false;
    }

    //Update method for HE, PWE, BPCE
    public boolean updateEmployee(int id, Name newName, double rateOrSales, double additionalInfo) {
        for (int i = 0; i < this.count; i++) {
            if (id == empList[i].getEmpId()) {
                empList[i].setEmpName(newName);

                if (empList[i] instanceof HourlyEmployee) {
                    ((HourlyEmployee) empList[i]).setRatePerHour((float)rateOrSales);
                    ((HourlyEmployee) empList[i]).setTotalHoursWorked((float)additionalInfo);
                } else if (empList[i] instanceof BasePlusCommissionEmployee) {
                    ((BasePlusCommissionEmployee) empList[i]).setTotalSales(rateOrSales);
                    ((BasePlusCommissionEmployee) empList[i]).setBaseSalary(additionalInfo);
                } else if (empList[i] instanceof PieceWorkerEmployee) {
                    ((PieceWorkerEmployee) empList[i]).setRatePerPiece((float)rateOrSales);
                    ((PieceWorkerEmployee) empList[i]).setTotalPiecesFinished((int) additionalInfo);
                }
                return true;
            }
        }
        return false;
    }
}
