package ro.teamnet.zerotohero.reflection.demoobjects;

import java.util.Collection;

/**
 * Created by Iordan.Serdin on 7/12/2017.
 */
class enumeratie{
    enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
        THURSDAY, FRIDAY, SATURDAY
    };
}
public class FirstClass {
    String nume="abc";
    int i=0;
    Integer y=new Integer(i);
    enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
        THURSDAY, FRIDAY, SATURDAY
    };
    Collection<String> c;


    public FirstClass() {
        System.out.println("s-a apelat constructorul fara param");
    }

    public FirstClass(String nume) {
        this.nume = nume;
    }

    public FirstClass(Collection<String> c) {
        this.c = c;
    }
    public int test(int i){
        return i+1;
    }

}
