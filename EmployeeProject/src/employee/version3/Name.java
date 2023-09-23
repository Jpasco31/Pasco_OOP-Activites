package employee.version3;

import java.util.Objects;

public class Name {
    private String title;
    private String firstName;
    private String lastName;
    private String middleName;
    private String suffix;

    public Name() {
        setTitle("");
        this.firstName = "";
        this.lastName = "";
        this.middleName = "";
        setSuffix("");
    }

    public Name(String firstName, String lastName, String middleName) {
        setTitle("");
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        setSuffix("");
    }

    public Name(String firstName, String lastName, String middleName, String suffix) {
        setTitle("");
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        setSuffix(suffix);
    }

    public Name(String title, String firstName, String lastName, String middleName, String suffix) {
        setTitle(title);
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        setSuffix(suffix);
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        title = title.toUpperCase();

        switch (title) {
            case "MR.", "MR", "MISTER" -> this.title = "Mr.";
            case "MS.", "MS", "MISS" -> this.title = "Ms.";
            case "MRS.", "MRS", "MISSIS" -> this.title = "Mrs.";
            case "DR.", "DR", "DOCTOR" -> this.title = "Dr.";
            case "ENG.", "ENG", "ENGINEER" -> this.title = "Eng.";
            case "FATHER", "FR.", "FR" -> this.title = "Father";
            case "" -> this.title = "";
            default -> this.title = title + ".";
        }
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getMiddleInitial() {
            return middleName.charAt(0) + ".";
    }


    public void setSuffix(String suffix) {
        suffix = suffix.toUpperCase();
        switch (suffix) {
            case "JR.", "JR", "JUNIOR" -> this.suffix = "Jr.";
            case "SR.", "SR", "SENIOR" -> this.suffix = "Sr.";
            case "II", "SECOND" -> this.suffix = "II.";
            case "III", "THIRD" -> this.suffix = "III.";
            case "IV", "FOURTH" -> this.suffix = "IV.";
            case "V", "FIFTH" -> this.suffix = "V.";
            case "" -> this.suffix = "";
            default -> this.suffix = suffix+ ".";
            }
    }

    @Override
    public String toString() {
        if(title.isEmpty() && suffix.isEmpty()){
            return firstName + " " + getMiddleInitial() + " " + lastName;
        } else if (title.isEmpty()){
           return firstName + " " + getMiddleInitial() + " " + lastName + ", " + suffix;
        } else if (suffix.isEmpty()){
            return title + " " + firstName + " " + getMiddleInitial() + " " + lastName;
        }

        return title + " " + firstName + " " + getMiddleInitial() + " " + lastName + ", " + suffix;
    }
}
