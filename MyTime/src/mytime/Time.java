package mytime;

public class Time {
    private int hour;
    private int minute;
    private int second;
    private boolean meridian; // true: AM, false: PM

    public Time() {
        this(12,0,0,true);
    }

    public Time(int hour) {
        this(hour,0,0,true);
    }

    public Time(int hour, int minute) {
        this(hour,minute,0,true);
    }

    public Time(int hour, int minute, int second) {
        this(hour,minute,second,true);
    }

    public Time(int hour, int minute, int second, boolean meridian) {
        minute %= 60;
        second %= 60;
        this.hour = hour > 12 ? hour %= 12 : hour;
        this.minute = minute;
        this.second = second;
        this.meridian = meridian;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour <= 12 && hour > 0 ? hour : 12;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute <= 60 && minute >= 0 ? minute : 59;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second <= 60 && second >= 0 ? second : 59;
    }

    public boolean isMeridian() {
        return meridian;
    }

    public void setMeridian(boolean meridian) {
        this.meridian = meridian;
    }

    public void advanceTime(int second){
        this.minute += (second / 60);
        second %= 60;
        this.second += second;

        if(this.minute >= 60){
            this.minute -=60;
            this.hour +=1;
            if(this.hour == 12){
                this.meridian = !this.meridian;
            }
        }

        if(this.hour > 12){
            this.hour = 1;
        }
    }

    public void tickByHour(){
        this.hour += 1;
        if(this.hour == 12){
            this.meridian = !this.meridian;
        }

        if(this.hour > 12){
            this.hour = 1;
        }
    }

    public void tickByMinute(){
        this.minute += 1;
        if(this.minute >= 60){
            this.minute = 0;
            tickByHour();
        }
    }

    public void tickBySecond(){
        this.second += 1;
        if(this.second >= 60){
            this.second = 0;
            tickByMinute();
        }
    }

    public void display12HourFormat(){
        System.out.printf("12 Hour Format: %02d : %02d : %02d %s\n", hour, minute, second, meridian ? "AM" : "PM");
    }

    public void display24HourFormat(){
        if(hour != 12){
            this.hour += meridian ? 12 : 0;
        } else {
            this.hour -= meridian ? 12 : 0;
        }
        System.out.printf("24 Hour Format: %02d : %02d : %02d \n", hour, minute, second);
    }

    @Override
    public String toString() {
        String merid = meridian ? "AM" : "PM";
        return "Time{" +
                "hour=" + hour +
                ", minute=" + minute +
                ", second=" + second +
                ", meridian=" + merid +
                '}';
    }

}
