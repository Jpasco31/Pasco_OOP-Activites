package employee.version1;

public class CommisionEmployee {
    private int empId;
    private String empName;
    private Date empDateHired;
    private Date empBirthDate;
    private double totalSales;

    public CommisionEmployee() {
        this.empId = 0;
        this.empName = "";
        this.empDateHired = new Date(1,1,2023);
        this.empBirthDate = new Date(1,1,2023);
        this.totalSales = 0;
    }

    public CommisionEmployee(int empId, String empName, Date empDateHired, Date empBirthDate) {
        this.empId = empId;
        this.empName = empName;
        this.empDateHired = empDateHired;
        this.empBirthDate = empBirthDate;
        this.totalSales = 0;
    }

    public CommisionEmployee(int empId, String empName, Date empDateHired, Date empBirthDate, double totalSales) {
        this.empId = empId;
        this.empName = empName;
        this.empDateHired = empDateHired;
        this.empBirthDate = empBirthDate;
        this.totalSales = totalSales;
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
        this.empDateHired = new Date(day, month, year);
    }

    public void setEmpBirthDate(Date empBirthDate) {
        this.empBirthDate = empBirthDate;
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
    public void displayInfo() {
        System.out.println("\nCommission Employee");
        System.out.println("ID: " +empId);
        System.out.println("Name: " + empName);
        System.out.println("Date Hired: " + empDateHired);
        System.out.println("Birthday: " + empBirthDate);
        System.out.println("Total sales: " + totalSales);
        System.out.printf("Salary: %.2f\n" ,computeSalary());
    }

    public String toString() {
        return "Commission Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empDateHired=" + empDateHired +
                ", empBirthDate=" + empBirthDate +
                '}';
    }
}
