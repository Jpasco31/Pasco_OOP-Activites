package employee.version4;

public class CommissionEmployee extends Employee {
    private double totalSales;

    public CommissionEmployee() {
        this.totalSales = 0;
    }

    public CommissionEmployee(int empId, Name empName, Date empDateHired, Date empBirthDate) {
        super(empId, empName, empDateHired, empBirthDate);
        this.totalSales = 0;
    }

    public CommissionEmployee(int empId, Name empName, Date empDateHired, Date empBirthDate, double totalSales) {
        super(empId, empName, empDateHired, empBirthDate);
        this.totalSales = totalSales;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales > 0 ? totalSales : 0;
    }

    public double computeSalary (){
        if(this.totalSales < 50000){
            return this.totalSales * 0.05;
        } else if (this.totalSales >= 50000 && this.totalSales < 100000){
            return this.totalSales * 0.2;
        } else if (this.totalSales >= 100000 && this.totalSales < 500000){
            return this.totalSales * 0.3;
        } else {
            return this.totalSales * 0.5;
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Commission Employee");
        System.out.println(toString());
        System.out.printf("Salary: %.2f\n\n" ,computeSalary());
    }

    @Override
    public String toString() {
        return super.toString()
                + String.format("\nTotal sales: %.2f", totalSales);
    }
}
