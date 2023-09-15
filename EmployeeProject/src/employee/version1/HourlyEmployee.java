package employee.version1;

import java.sql.SQLOutput;

public class HourlyEmployee {
    private int empId;
    private String empName;
    private Date empDateHired;
    private Date empBirthDate;
    private float totalHoursWorked;
    private float ratePerHour;

    public HourlyEmployee() {
        this.empId = 0;
        this.empName = "";
        this.empDateHired = new Date(1,1,2023);
        this.empBirthDate = new Date(1,1,2023);
        this.totalHoursWorked = 0;
        this.ratePerHour = 0;
    }
    public HourlyEmployee(int empId, String empName, Date empDateHired, Date empBirthDate) {
        this.empId = empId;
        this.empName = empName;
        this.empDateHired = empDateHired;
        this.empBirthDate = empBirthDate;
        this.totalHoursWorked = 0;
        this.ratePerHour = 0;
    }
    public HourlyEmployee(int empId, String empName, Date empDateHired, Date empBirthDate, float totalHoursWorked, float ratePerHour) {
        this.empId = empId;
        this.empName = empName;
        this.empDateHired = empDateHired;
        this.empBirthDate = empBirthDate;
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = Math.max(empId, 0);
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Date getEmpDateHired() {
        return empDateHired;
    }

    public void setEmpDateHired(int day, int month, int year) {
        this.empDateHired = new Date(day, month, year);
    }

    public void setEmpDateHired(Date empDateHired) {
        this.empDateHired = empDateHired;
    }

    public Date getEmpBirthDate() {
        return empBirthDate;
    }

    public void setEmpBirthDate(int day, int month, int year) {
        this.empBirthDate = new Date(day, month, year);
    }

    public void setEmpBirthDate(Date empBirthDate) {
        this.empBirthDate = empBirthDate;
    }

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        this.totalHoursWorked = totalHoursWorked > 0 || totalHoursWorked <= 168? totalHoursWorked: 0;
    }

    public float getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(float ratePerHour) {
        this.ratePerHour = ratePerHour > 0 ? ratePerHour: 0;
    }

    public double computeSalary(){
        if(this.totalHoursWorked > 40){
            float regHours = 40;
            float overTime = this.totalHoursWorked - 40;
            return ((regHours * this.ratePerHour) + (overTime * (this.ratePerHour * 1.5)));
        }
        return this.totalHoursWorked * this.ratePerHour;
    }

    public void displayInfo() {
        System.out.println("\nHourly Employee");
        System.out.println(toString());
        System.out.printf("Salary: %.2f\n", computeSalary());
    }

    @Override
    public String toString() {
        return "ID: " + empId
                + "\nName: " + empName
                + "\nDate Hired: " + empDateHired
                + "\nBirthday: " + empBirthDate
                + String.format("\nTotal hours worked: %.2f", totalHoursWorked)
                + String.format("\nRate per Hour: %.2f", ratePerHour);
    }
}
