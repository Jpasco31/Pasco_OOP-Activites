package employee.version4;

public class Main {
    public static void main(String[] args) {

        EmployeeRoster list = new EmployeeRoster(20);

        //HOURLY EMPLOYEE
        list.addEmployee(new HourlyEmployee(1,new Name("Jericho", "Pasco", "Clam"), new Date(21,4,2020),
                new Date(31,12,2000), 60, 200));

        list.addEmployee( new HourlyEmployee(5, new Name("Nayeon", "Im", "Twice", "Senior"), new Date(24,6,2022),
                new Date(22,9,1995)));
        ((HourlyEmployee)list.empList[list.getCount() - 1]).setTotalHoursWorked(70);
        ((HourlyEmployee)list.empList[list.getCount() - 1]).setRatePerHour(300);

        list.addEmployee(new HourlyEmployee());
        ((HourlyEmployee)list.empList[list.getCount() - 1]).setEmpId(6);
        ((HourlyEmployee)list.empList[list.getCount() - 1]).setEmpName(new Name("Ms", "Sana", "Minatozaki", "Twice", "Junior"));
        ((HourlyEmployee)list.empList[list.getCount() - 1]).setEmpDateHired(new Date(26,7,-2019));  //year is negative so set to default 2023
        ((HourlyEmployee)list.empList[list.getCount() - 1]).setEmpBirthDate(15,5,1997);
        ((HourlyEmployee)list.empList[list.getCount() - 1]).setTotalHoursWorked(45);
        ((HourlyEmployee)list.empList[list.getCount() - 1]).setRatePerHour(40);   //negative rate per hour so set to default 0

        //PIECE WORKER EMPLOYEE
        list.addEmployee( new PieceWorkerEmployee(2, new Name("John", "Pasco", "Clam"), new Date(22,3,2021),
                new Date(8,10,2002), 251, 60));


        list.addEmployee( new PieceWorkerEmployee(7, new Name("Momo", "Hirai", "Twice", "Senior"), new Date(26,7,2023),
                new Date(9,11,1996)));
        ((PieceWorkerEmployee)list.empList[list.getCount() - 1]).setRatePerPiece(50);
        ((PieceWorkerEmployee)list.empList[list.getCount() - 1]).setTotalPiecesFinished(312);

        list.addEmployee(new PieceWorkerEmployee());
        ((PieceWorkerEmployee)list.empList[list.getCount() - 1]).setEmpId(8);
        ((PieceWorkerEmployee)list.empList[list.getCount() - 1]).setEmpName(new Name("Mr","Jeongyeon", "Yoo", "Twice", "II"));
        ((PieceWorkerEmployee)list.empList[list.getCount() - 1]).setEmpDateHired(new Date(20,10,-2015));  //year is negative so set to default 2023
        ((PieceWorkerEmployee)list.empList[list.getCount() - 1]).setEmpBirthDate(1,11,1996);
        ((PieceWorkerEmployee)list.empList[list.getCount() - 1]).setTotalPiecesFinished(105);
        ((PieceWorkerEmployee)list.empList[list.getCount() - 1]).setRatePerPiece(-60);             //negative rate per piece so set to default 0

        //Commission Employee
        list.addEmployee(new CommissionEmployee(3, new Name("Joe", "Pasco", "Clam"), new Date(19,5,2019),
                new Date(18,9,1996), 250000));

       list.addEmployee(new CommissionEmployee(9, new Name("Mina", "Myoui", "Twice", "III"), new Date(26,7,2023),
                new Date(24,3,1997)));
        ((CommissionEmployee)list.empList[list.getCount() - 1]).setTotalSales(90000);

       list.addEmployee(new CommissionEmployee());
        ((CommissionEmployee)list.empList[list.getCount() - 1]).setEmpId(10);
        ((CommissionEmployee)list.empList[list.getCount() - 1]).setEmpName(new Name("Dr", "Dahyun", "Kim", "Twice", "IV"));
        ((CommissionEmployee)list.empList[list.getCount() - 1]).setEmpDateHired(20,20,-2015);          //month > 12 so set to default 1 and year < 0 set to default 2023
        ((CommissionEmployee)list.empList[list.getCount() - 1]).setEmpBirthDate(new Date(28,5,1998));
        ((CommissionEmployee)list.empList[list.getCount() - 1]).setTotalSales(900000);


        //Base Plus Commission Employee
         list.addEmployee(new BasePlusCommissionEmployee(4, new Name("Jihyo", "Park", "Twice"), new Date(18,8,2023),
                new Date(1,2,1997), 700000, 150000));

        list.addEmployee(new BasePlusCommissionEmployee(11, new Name("Chaeyoung","Son", "Twice", "FOURTH"), new Date(20,10,2015),
                new Date(23,4,1999)));
        ((BasePlusCommissionEmployee)list.empList[list.getCount() - 1]).setTotalSales(80000);
        ((BasePlusCommissionEmployee)list.empList[list.getCount() - 1]).setBaseSalary(200000);

        list.addEmployee(new BasePlusCommissionEmployee());
        ((BasePlusCommissionEmployee)list.empList[list.getCount() - 1]).setEmpId(12);
        ((BasePlusCommissionEmployee)list.empList[list.getCount() - 1]).setEmpName(new Name("Lady","Tzuyu","Chou", "Twice", "FIFTH"));
        ((BasePlusCommissionEmployee)list.empList[list.getCount() - 1]).setEmpDateHired(32,10,2015);         //day > 31 set to default 1
        ((BasePlusCommissionEmployee)list.empList[list.getCount() - 1]).setEmpBirthDate(24,6,1999);
        ((BasePlusCommissionEmployee)list.empList[list.getCount() - 1]).setTotalSales(800000);
        ((BasePlusCommissionEmployee)list.empList[list.getCount() - 1]).setBaseSalary(-10000);                   //base salary < 0 set to default 0

        System.out.println("DISPLAY ALL EMPLOYEE");
        list.displayAllEmployee();
        System.out.println("Max number of employees = " + list.getMax()); //12
        System.out.println("Current Count of total employees = " + list.getCount() + "\n"); //12

        list.displayHE();
        System.out.println("Count Hourly Employee = " + list.countHE() + "\n");
        list.displayPWE();
        System.out.println("Count Piece Worker Employee = " + list.countPWE() + "\n");
        list.displayCE();
        System.out.println("Count Commission Employee = " + list.countCE() + "\n");
        list.displayBPCE();
        System.out.println("Count Base Plus Commission Employee = " + list.countBPEC() + "\n");

        list.deleteEmployee(3); //ID: - Joe C. Pasco delete
        System.out.println("DISPLAY ALL EMPLOYEE AFTER DELETE Employee ID = 3");
        list.displayAllEmployee();
        System.out.println("Count of total employees after delete Employee = " + list.getCount() + "\n"); //11

        list.updateEmployee(1, new Name("Jericho", "Clam", "Baldago"), 10, 20); // ID 1 - New middlename, lastname, rate per hour and total hours worked
        list.updateEmployee(4, new Name("Jihyo", "Park", "Solo"), 800000, 250000); // ID 3 - New middle name, new totalsales, new base salaray
        list.updateEmployee(7, new Name("Momo", "Hirai", "Misamo"), 100, 312); // ID 7 - New middle name and new rate per piece
        list.updateEmployee(10, new Name("Dahyun", "Park", "Twice"), 500000); // ID 10 - New lastname and totalSales

        System.out.println("DISPLAY ALL EMPLOYEE AFTER Update Employee IDs : 1, 4, 7, 10");
        list.displayAllEmployee();
    }
}
