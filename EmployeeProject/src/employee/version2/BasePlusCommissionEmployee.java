package employee.version2;

public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;

    public BasePlusCommissionEmployee() {
        this.baseSalary = 0;
    }

    public BasePlusCommissionEmployee(int empId, String empName, Date empDateHired, Date empBirthDate) {
        super(empId, empName, empDateHired, empBirthDate, 0);
    }

    public BasePlusCommissionEmployee(int empId, String empName, Date empDateHired, Date empBirthDate, double totalSales, double baseSalary) {
        super(empId, empName, empDateHired, empBirthDate, totalSales);
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary > 0 ? baseSalary: 0;
    }

    public double computeSalary () {
        double totalSales = getTotalSales();
        if (totalSales < 50000) {
            return totalSales  * 0.05 + this.baseSalary;
        } else if (totalSales  >= 50000 && totalSales  < 100000) {
            return totalSales * 0.2 + this.baseSalary;
        } else if (totalSales  >= 100000 && totalSales < 500000) {
            return totalSales * 0.3 + this.baseSalary;
        } else {
            return totalSales  * 0.5 + this.baseSalary;
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Base Plus Commission Employee");
        System.out.println(toString());
        System.out.printf("Total Salary: %.2f\n\n" ,computeSalary());
    }

    @Override
    public String toString() {
        return super.toString()
                + String.format("\nBase Salary: %.2f", baseSalary);
    }
}
