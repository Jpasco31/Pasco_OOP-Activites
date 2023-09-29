package employee.version4;

import java.util.ArrayList;

public class EmployeeRoster {
    private ArrayList<Employee> empList = new ArrayList<Employee>();
    private int count = 0;
    private int max;

    public EmployeeRoster() {
        this.max = 10;
    }

    public EmployeeRoster(int max) {
        this.max = max;
    }

    public ArrayList<Employee> getEmpList() {
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
            Employee employee = empList.get(i);
            String fullName = employee.getEmpName().getFirstName() + employee.getEmpName().getLastName() + employee.getEmpName().getMiddleInitial();
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
            if(empList.get(i) instanceof HourlyEmployee){
                numOfHE++;
            }
        }
        return numOfHE;
    }

    public int countPWE(){
        int numOfPWE = 0;
        for(int i = 0; i < this.count; i++){
            if(empList.get(i) instanceof PieceWorkerEmployee){
                numOfPWE++;
            }
        }
        return numOfPWE;
    }

    public int countCE(){
        int numOfCE = 0;
        for(int i = 0; i < this.count; i++){
            if(empList.get(i) instanceof CommissionEmployee){
                numOfCE++;
            }
        }

        return numOfCE;
    }

    public int countBPEC(){
        int numOfBPEC = 0;
        for(int i = 0; i < this.count; i++){
            if(empList.get(i) instanceof BasePlusCommissionEmployee){
                numOfBPEC++;
            }
        }
        return numOfBPEC;
    }
}
