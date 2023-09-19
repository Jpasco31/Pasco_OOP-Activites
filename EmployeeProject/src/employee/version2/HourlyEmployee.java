package employee.version2;

public class HourlyEmployee extends  Employee {
    private float totalHoursWorked;
    private float ratePerHour;

    public HourlyEmployee() {
        this.totalHoursWorked = 0;
        this.ratePerHour = 0;
    }
    public HourlyEmployee(int empId, String empName, Date empDateHired, Date empBirthDate) {
        super(empId, empName, empDateHired, empBirthDate);
        this.totalHoursWorked = 0;
        this.ratePerHour = 0;
    }

    public HourlyEmployee(int empId, String empName, Date empDateHired, Date empBirthDate, float totalHoursWorked, float ratePerHour) {
        super(empId, empName, empDateHired, empBirthDate);
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
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

    @Override
    public void displayInfo() {
        System.out.println("Hourly Employee");
        System.out.println(toString());
        System.out.printf("Salary: %.2f\n\n", computeSalary());
    }

    @Override
    public String toString() {
        return super.toString()
                + String.format("\nTotal hours worked: %.2f", totalHoursWorked)
                + String.format("\nRate per Hour: %.2f", ratePerHour);
    }
}
