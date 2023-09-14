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

    public Date(int day) {
        this.day = day;
        this.month = 1;
        this.year = 2023;
    }

    public Date(int day, int month) {
        this.day = day;
        this.month = month;
        this.year = 2023;
    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
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
        return String.format("%02d/%02d/%04d", day, month, year);
    }
}
