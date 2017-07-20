package exercise3;

/**
 * Created by Iordan.Serdin on 7/7/2017.
 */
public class Student {
    private String firstName;
    private String lastName;

    public Student() {

    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
    public String toString(){
        return "FirstName"+getFirstName()+"LastName"+getLastName();
    }
}
