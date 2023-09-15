package employee.version1;

import employee.version1.*;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        //HOURLY EMPLOYEE
        HourlyEmployee hourlyE1 = new HourlyEmployee(1,"Jericho", new Date(21,4,2020),
                new Date(31,12,2000), 60, 200);
        hourlyE1.displayInfo();

        HourlyEmployee hourlyE2 = new HourlyEmployee(5,"Nayeon", new Date(24,6,2022),
                new Date(22,9,1995));
        hourlyE2.setTotalHoursWorked(70);
        hourlyE2.setRatePerHour(300);
        hourlyE2.displayInfo();

        HourlyEmployee hourlyE3 = new HourlyEmployee();
        hourlyE3.setEmpId(6);
        hourlyE3.setEmpName("Sana");
        hourlyE3.setEmpDateHired(new Date(26,7,-2019));  //year is negative so set to default 2023
        hourlyE3.setEmpBirthDate(15,5,1997);
        hourlyE3.setTotalHoursWorked(45);
        hourlyE3.setRatePerHour(-30);   //negative rate per hour so set to default 0
        hourlyE3.displayInfo();

        //PIECE WORKER EMPLOYEE
        PieceWorkerEmployee pieceWorkerE1 = new PieceWorkerEmployee(2,"John", new Date(22,3,2021),
                new Date(8,10,2002), 251, 60);
        pieceWorkerE1.displayInfo();

        PieceWorkerEmployee pieceWorkerE2 = new PieceWorkerEmployee(7,"Momo", new Date(26,7,2023),
                new Date(9,11,1996));
        pieceWorkerE2.setRatePerPiece(50);
        pieceWorkerE2.setTotalPiecesFinished(312);
        pieceWorkerE2.displayInfo();

        PieceWorkerEmployee pieceWorkerE3 = new PieceWorkerEmployee();
        pieceWorkerE3.setEmpId(8);
        pieceWorkerE3.setEmpName("Jeongyeon");
        pieceWorkerE3.setEmpDateHired(new Date(20,10,-2015));  //year is negative so set to default 2023
        pieceWorkerE3.setEmpBirthDate(1,11,1996);
        pieceWorkerE3.setTotalPiecesFinished(105);
        pieceWorkerE3.setRatePerPiece(-60);             //negative rate per piece so set to default 0
        pieceWorkerE3.displayInfo();

        //Commission Employee
        CommisionEmployee commissionE1 = new CommisionEmployee(3,"Joe", new Date(19,5,2019),
                new Date(18,9,1996), 250000);
        commissionE1.displayInfo();

        CommisionEmployee commissionE2 = new CommisionEmployee(9,"Mina", new Date(26,7,2023),
                new Date(24,3,1997));
        commissionE2.setTotalSales(90000);
        commissionE2.displayInfo();

        CommisionEmployee commissionE3 = new CommisionEmployee();
        commissionE3.setEmpId(10);
        commissionE3.setEmpName("Dahyun");
        commissionE3.setEmpDateHired(20,20,-2015);          //month > 12 so set to default 1 and year < 0 set to default 2023
        commissionE3.setEmpBirthDate(new Date(28,5,1998));
        commissionE3.setTotalSales(900000);
        commissionE3.displayInfo();

        BasePlusCommisionEmployee baseE1 = new BasePlusCommisionEmployee(4,"Jihyo", new Date(18,8,2023),
                new Date(1,2,1997), 700000, 150000);
        baseE1.displayInfo();

        BasePlusCommisionEmployee baseE2 = new BasePlusCommisionEmployee(11,"Chaeyoung", new Date(20,10,2015),
                new Date(23,4,1999));
        baseE2.setTotalSales(80000);
        baseE2.setBaseSalary(200000);
        baseE2.displayInfo();

        BasePlusCommisionEmployee baseE3 = new BasePlusCommisionEmployee(12,"Tzuyu", new Date(20,10,2015),
                new Date(23,4,1999));
        baseE3.setEmpId(12);
        baseE3.setEmpName("Tzuyu");
        baseE3.setEmpDateHired(32,10,2015);         //day > 31 set to default 1
        baseE3.setEmpBirthDate(24,6,1999);
        baseE3.setTotalSales(800000);
        baseE3.setBaseSalary(-10000);                   //base salary < 0 set to default 0
        baseE3.displayInfo();
    }
}