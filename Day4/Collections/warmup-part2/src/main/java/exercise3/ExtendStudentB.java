package exercise3;

/**
 * Created by Iordan.Serdin on 7/7/2017.
 */
public class ExtendStudentB extends Student {


    public boolean equals(Object o) {
        if (this==o) return true;
        if (!(o instanceof Student)) {
            return false;
        }
        if (o == null) {
            return false;
        }

        if (this.getClass() != o.getClass()) {
            return false;
        }

        Student s=(Student) o;


        if (!(this.getFirstName().equals(s.getFirstName()))){
            return false;
        }
        if (!(this.getLastName().equals(s.getLastName()))){
            return false;
        }


        return true;
    }


    public int hashCode() {
        int result=this.getFirstName().hashCode();
        //int result=super.getFirstName().hashCode();
        // result=31*result+super.getLastName().hashCode();

        return result;
    }
}
