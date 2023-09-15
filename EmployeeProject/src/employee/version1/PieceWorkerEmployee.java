package employee.version1;

public class PieceWorkerEmployee {
    private int empId;
    private String empName;
    private Date empDateHired;
    private Date empBirthDate;
    private int totalPiecesFinished;
    private float ratePerPiece;

    public PieceWorkerEmployee() {
        this.empId = 0;
        this.empName = "";
        this.empDateHired = new Date(1,1,2023);
        this.empBirthDate = new Date(1,1,2023);
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }
    public PieceWorkerEmployee(int empId, String empName, Date empDateHired, Date empBirthDate) {
        this.empId = empId;
        this.empName = empName;
        this.empDateHired = empDateHired;
        this.empBirthDate = empBirthDate;
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }
    public PieceWorkerEmployee(int empId, String empName, Date empDateHired, Date empBirthDate, int totalPiecesFinished, float ratePerPiece) {
        this.empId = empId;
        this.empName = empName;
        this.empDateHired = empDateHired;
        this.empBirthDate = empBirthDate;
        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
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

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        this.totalPiecesFinished = Math.max(totalPiecesFinished, 0);
    }

    public float getRatePerPiece() {
        return ratePerPiece;
    }

    public void setRatePerPiece(float ratePerPiece) {
        this.ratePerPiece = ratePerPiece > 0 ? ratePerPiece : 0;
    }

    public float computeSalary(){
        int bonus = totalPiecesFinished / 100;
        return (totalPiecesFinished * ratePerPiece) + (bonus * (ratePerPiece * 10));
    }


    public void displayInfo() {
        System.out.println("\nPiece Worker Employee");
        System.out.println(toString());
        System.out.printf("Salary: %.2f\n", computeSalary());
    }

    @Override
    public String toString() {
        return "ID: " + empId
                + "\nName: " + empName
                + "\nDate Hired: " + empDateHired
                + "\nBirthday: " + empBirthDate
                + "\nTotal pieces finished: " + totalPiecesFinished
                + String.format("\nRate per piece: %.2f", ratePerPiece);
    }
}
