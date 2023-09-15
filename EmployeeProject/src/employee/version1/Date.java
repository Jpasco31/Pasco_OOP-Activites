package employee.version1;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(){
        this.day = 1;
        this.month = 1;
        this.year = 2023;
    }

    public Date(int day, int month, int year) {
        this.day = day > 0 && day <= 31 ? day: 1;
        this.month = month > 0 && month <= 12 ? month : 1;
        this.year = year > 0 ? year: 2023;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day > 31 || month < 0? 1 : day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month > 12 || month < 0? 1 : month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year < 0 ? 2023 : year;
    }

    @Override
    public String toString() {
        String[] monthString = {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};

        return String.format("%02d %s %04d", day, monthString[month-1], year);
    }
}