import employee.version1.*;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        HourlyEmployee e1 = new HourlyEmployee(1,"Jericho", new Date(4,21,2020),
                new Date(12,31,2000), 60, 200);

        e1.displayInfo();

        PieceWorkerEmployee e2 = new PieceWorkerEmployee(1,"John", new Date(3,22,2021),
                new Date(10,8,2002), 251, 60);
        e2.displayInfo();

        CommisionEmployee e3 = new CommisionEmployee(3,"Joe", new Date(5,19,2019),
                new Date(9,18,1996), 250000);
        e3.displayInfo();

        BasePlusCommisionEmployee e4 = new BasePlusCommisionEmployee(4,"Jihyo", new Date(10,10,2015),
                new Date(2,1,1997), 700000, 150000);
        e4.displayInfo();
    }
}