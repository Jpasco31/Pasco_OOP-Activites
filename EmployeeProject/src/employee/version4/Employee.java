package employee.version4;

public class Employee {
    private int empId;
    private Name empName;
    private Date empDateHired;
    private Date empBirthDate;

    public Employee() {
        this.empId = 0;
        this.empName = new Name();
        this.empDateHired = new Date(1,1,2023);
        this.empBirthDate = new Date(1,1,2023);
    }

    public Employee(int empId, Name empName, Date empDateHired, Date empBirthDate) {
        this.empId = empId;
        this.empName = empName;
        this.empDateHired = empDateHired;
        this.empBirthDate = empBirthDate;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = Math.max(empId, 0);
    }

    public Name getEmpName() {
        return empName;
    }

    public void setEmpName(Name empName) {
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

    public void displayInfo() {
        System.out.println("Employee");
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "ID: " + empId + "\nName: " + empName + "\nDate Hired: " + empDateHired + "\nBirthDate: " +empBirthDate;
    }
}
