import mytime.Time;

public class Main {
    public static void main(String[] args) {

       Time t1 = new Time(11,58,48,true);
       System.out.println("T1: " + t1.toString());
       t1.advanceTime(128);
        System.out.println("Advance Time by 128 seconds");
       t1.display12HourFormat();
       t1.display24HourFormat();
        System.out.println();

       Time t2 = new Time(11,59,59,true);
        System.out.println("T2: " + t2.toString());
       t2.tickBySecond();
        t2.advanceTime(128);
        System.out.println("TICK BY A SECOND and advance time 128 seconds");
       t2.display12HourFormat();
       t2.display24HourFormat();
        System.out.println();

       Time t3 = new Time(11,59,0,false);
       System.out.println("T3: " + t3.toString());
       t3.tickByMinute();
        t3.advanceTime(128);
        System.out.println("TICK BY A MINUTE and advance time 128 seconds");
       t3.display12HourFormat();
        t3.display24HourFormat();
        System.out.println();

        Time t4 = new Time(12,0,0,true);
        System.out.println("T4: " + t4.toString());
        t4.tickByHour();
        t4.advanceTime(128);
        System.out.println("TICK BY AN HOUR and advance time 128 seconds");
        t4.display12HourFormat();
        t4.display24HourFormat();
    }
}