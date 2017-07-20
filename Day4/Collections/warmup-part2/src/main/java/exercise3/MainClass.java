package exercise3;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Iordan.Serdin on 7/7/2017.
 */
public class MainClass {
    public static void main(String args[]){

        //BigDecimal e reprezentata de varsta
        Map<ExtendStudent,BigDecimal> map1=new HashMap<ExtendStudent, BigDecimal>();
        Map<ExtendStudentB,BigDecimal> map2=new HashMap<ExtendStudentB, BigDecimal>();
        Map<ExtendStudentC,BigDecimal> map3=new HashMap<ExtendStudentC, BigDecimal>();
        Map<ExtendStudentD,BigDecimal> map4=new HashMap<ExtendStudentD, BigDecimal>();
        Student s1=new Student("Popescu","Marcel");
        Student s2=new Student("Mirel","Radoi");
        Student s3=new Student("Popescu","Marcel");
        ExtendStudent s11=new ExtendStudent(s1.getFirstName(),s1.getLastName());
        map1.put(s11,new BigDecimal(9.0));
        ExtendStudent s12=new ExtendStudent(s2.getFirstName(),s2.getLastName());
        map1.put(s12,new BigDecimal(8.0));
        ExtendStudent s13=new ExtendStudent(s3.getFirstName(),s3.getLastName());
        map1.put(s13,new BigDecimal(9.0));
        if (s11.equals(s13)){
            System.out.println("da equals");
        }
        System.out.println("hashcode-ul pentru s11"+s11.hashCode());
        System.out.println("hashcode-ul pentru s12"+s12.hashCode());
        System.out.println("hashcode-ul pentru s13"+s13.hashCode());
        if (s11.hashCode()==s13.hashCode()){
            System.out.println("da hashcode");
        }
        System.out.println(map1);
        //hashCode iti poate muta eleementele astfel incat sa avem o lista mai mare sau mai mica
        //equals face in asa fel incat iti poate suprascrie
        //adaugam primul element s11 la fel cu s13 il va muta pe s11 dupa s12 pentru ca au acelasi hashCode

    }
}
