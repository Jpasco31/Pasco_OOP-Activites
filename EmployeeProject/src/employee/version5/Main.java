package employee.version5;

public class Main {
    public static void main(String[] args) {

        EmployeeRoster list = new EmployeeRoster();
        boolean isAdded = false;
        boolean isDeleted = false;
        boolean isUpdated = false;

        //HOURLY EMPLOYEE
        isAdded = list.addEmployee(new HourlyEmployee(1,new Name("Jericho", "Pasco", "Clam"), new Date(21,4,2020),
                new Date(31,12,2000), 60, 200));
        System.out.println("Added Employee = " + isAdded);

        isAdded = list.addEmployee( new HourlyEmployee(5, new Name("Nayeon", "Im", "Twice", "Senior"), new Date(24,6,2022),
                new Date(22,9,1995)));
        System.out.println("Added Employee = " + isAdded);
        ((HourlyEmployee)list.empList.get(list.empList.size()- 1)).setTotalHoursWorked(70);
        ((HourlyEmployee)list.empList.get(list.empList.size()- 1)).setRatePerHour(300);

        isAdded = list.addEmployee(new HourlyEmployee());
        System.out.println("Added Employee = " + isAdded);
        (list.empList.get(list.empList.size()- 1)).setEmpId(6);
        (list.empList.get(list.empList.size()- 1)).setEmpName(new Name("Ms", "Sana", "Minatozaki", "Twice", "Junior"));
        (list.empList.get(list.empList.size()- 1)).setEmpDateHired(new Date(26,7,-2019));  //year is negative so set to default 2023
        (list.empList.get(list.empList.size()- 1)).setEmpBirthDate(15,5,1997);
        ((HourlyEmployee)list.empList.get(list.empList.size()- 1)).setTotalHoursWorked(45);
        ((HourlyEmployee)list.empList.get(list.empList.size()- 1)).setRatePerHour(40);   //negative rate per hour so set to default 0

        //PIECE WORKER EMPLOYEE
        isAdded = list.addEmployee( new PieceWorkerEmployee(2, new Name("John", "Pasco", "Clam"), new Date(22,3,2021),
                new Date(8,10,2002), 251, 60));
        System.out.println("Added Employee = " + isAdded);

        isAdded = list.addEmployee( new PieceWorkerEmployee(7, new Name("Momo", "Hirai", "Twice", "Senior"), new Date(26,7,2023),
                new Date(9,11,1996)));
        System.out.println("Added Employee = " + isAdded);
        ((PieceWorkerEmployee)list.empList.get(list.empList.size()- 1)).setRatePerPiece(50);
        ((PieceWorkerEmployee)list.empList.get(list.empList.size()- 1)).setTotalPiecesFinished(312);

        isAdded = list.addEmployee(new PieceWorkerEmployee());
        System.out.println("Added Employee = " + isAdded);
        (list.empList.get(list.empList.size()- 1)).setEmpId(8);
        (list.empList.get(list.empList.size()- 1)).setEmpName(new Name("Mr","Jeongyeon", "Yoo", "Twice", "II"));
        (list.empList.get(list.empList.size()- 1)).setEmpDateHired(new Date(20,10,-2015));  //year is negative so set to default 2023
        (list.empList.get(list.empList.size()- 1)).setEmpBirthDate(1,11,1996);
        ((PieceWorkerEmployee)list.empList.get(list.empList.size()- 1)).setTotalPiecesFinished(105);
        ((PieceWorkerEmployee)list.empList.get(list.empList.size()- 1)).setRatePerPiece(-60);             //negative rate per piece so set to default 0

        //Commission Employee
        isAdded = list.addEmployee(new CommissionEmployee(3, new Name("Joe", "Pasco", "Clam"), new Date(19,5,2019),
                new Date(18,9,1996), 250000));
        System.out.println("Added Employee = " + isAdded);

        isAdded = list.addEmployee(new CommissionEmployee(9, new Name("Mina", "Myoui", "Twice", "III"), new Date(26,7,2023),
                new Date(24,3,1997)));
        System.out.println("Added Employee = " + isAdded);
        ((CommissionEmployee)list.empList.get(list.empList.size()- 1)).setTotalSales(90000);

        isAdded = list.addEmployee(new CommissionEmployee());
        System.out.println("Added Employee = " + isAdded);
        (list.empList.get(list.empList.size()- 1)).setEmpId(10);
        (list.empList.get(list.empList.size()- 1)).setEmpName(new Name("Dr", "Dahyun", "Kim", "Twice", "IV"));
        (list.empList.get(list.empList.size()- 1)).setEmpDateHired(20,20,-2015);          //month > 12 so set to default 1 and year < 0 set to default 2023
        (list.empList.get(list.empList.size()- 1)).setEmpBirthDate(new Date(28,5,1998));
        ((CommissionEmployee)list.empList.get(list.empList.size()- 1)).setTotalSales(900000);


        //Base Plus Commission Employee
        isAdded = list.addEmployee(new BasePlusCommissionEmployee(4, new Name("Jihyo", "Park", "Twice"), new Date(18,8,2023),
                new Date(1,2,1997), 700000, 150000));
        System.out.println("Added Employee = " + isAdded);

        isAdded = list.addEmployee(new BasePlusCommissionEmployee(11, new Name("Chaeyoung","Son", "Twice", "FOURTH"), new Date(20,10,2015),
                new Date(23,4,1999)));
        System.out.println("Added Employee = " + isAdded);
        ((BasePlusCommissionEmployee)list.empList.get(list.empList.size()- 1)).setTotalSales(80000);
        ((BasePlusCommissionEmployee)list.empList.get(list.empList.size()- 1)).setBaseSalary(200000);

        isAdded = list.addEmployee(new BasePlusCommissionEmployee());
        System.out.println("Added Employee = " + isAdded);
        (list.empList.get(list.empList.size()- 1)).setEmpId(12);
        (list.empList.get(list.empList.size()- 1)).setEmpName(new Name("Lady","Tzuyu","Chou", "Twice", "FIFTH"));
        (list.empList.get(list.empList.size()- 1)).setEmpDateHired(32,10,2015);         //day > 31 set to default 1
        (list.empList.get(list.empList.size()- 1)).setEmpBirthDate(24,6,1999);
        ((BasePlusCommissionEmployee)list.empList.get(list.empList.size()- 1)).setTotalSales(800000);
        ((BasePlusCommissionEmployee)list.empList.get(list.empList.size()- 1)).setBaseSalary(-10000);                   //base salary < 0 set to default 0

        System.out.println("DISPLAY ALL EMPLOYEE");
        list.displayAllEmployee();
        System.out.println("Current Count of total employees = " + list.empList.size() + "\n"); //12

        list.displayHE();
        System.out.println("Count Hourly Employee = " + list.countHE() + "\n");
        list.displayPWE();
        System.out.println("Count Piece Worker Employee = " + list.countPWE() + "\n");
        list.displayCE();
        System.out.println("Count Commission Employee = " + list.countCE() + "\n");
        list.displayBPCE();
        System.out.println("Count Base Plus Commission Employee = " + list.countBPEC() + "\n");

        isDeleted = list.deleteEmployee(3); //ID: - Joe C. Pasco delete
        System.out.println("Is deleted = " + isDeleted);
        System.out.println("DISPLAY ALL EMPLOYEE AFTER DELETE Employee ID = 3");
        list.displayAllEmployee();
        System.out.println("Count of total employees after delete Employee = " + list.empList.size()  + "\n"); //11

        isUpdated = list.updateEmployee(1, new Name("Jericho", "Clam", "Baldago"), 10, 20); // ID 1 - New middlename, lastname, rate per hour and total hours worked
        System.out.println("Is Updated = " + isUpdated);
        isUpdated = list.updateEmployee(4, new Name("Jihyo", "Park", "Solo"), 800000, 250000); // ID 3 - New middle name, new totalsales, new base salaray
        System.out.println("Is Updated = " + isUpdated);
        isUpdated = list.updateEmployee(7, new Name("Momo", "Hirai", "Misamo"), 100, 312); // ID 7 - New middle name and new rate per piece
        System.out.println("Is Updated = " + isUpdated);
        isUpdated = list.updateEmployee(10, new Name("Dahyun", "Park", "Twice"), 500000); // ID 10 - New lastname and totalSales
        System.out.println("Is Updated = " + isUpdated);
        System.out.println("DISPLAY ALL EMPLOYEE AFTER Update Employee IDs : 1, 4, 7, 10");
        list.displayAllEmployee();

        EmployeeRoster twiceEmpList = list.getEmployee("Twice");       //Get all employees with "Twice" in their names
        System.out.println("\nAll Employees with Twice in there name");
        twiceEmpList.displayAllEmployee();
        System.out.println("Count of total employees with 'Twice' in there name = " + list.empList.size()  + "\n"); //7
    }
}
