package employee.version5;

public class PieceWorkerEmployee extends Employee {
    private int totalPiecesFinished;
    private float ratePerPiece;

    public PieceWorkerEmployee() {
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }

    public PieceWorkerEmployee(int empId, Name empName, Date empDateHired, Date empBirthDate) {
        super(empId, empName, empDateHired, empBirthDate);
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }

    public PieceWorkerEmployee(int empId, Name empName, Date empDateHired, Date empBirthDate, int totalPiecesFinished, float ratePerPiece) {
        super(empId, empName, empDateHired, empBirthDate);
        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
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

    public double computeSalary(){
        int bonus = totalPiecesFinished / 100;
        return (totalPiecesFinished * ratePerPiece) + (bonus * (ratePerPiece * 10));
    }

    @Override
    public void displayInfo() {
        System.out.println("Piece Worker Employee");
        System.out.println(toString());
        System.out.printf("Salary: %.2f\n\n", computeSalary());
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nTotal pieces finished: " + totalPiecesFinished
                + String.format("\nRate per piece: %.2f", ratePerPiece);
    }
}
