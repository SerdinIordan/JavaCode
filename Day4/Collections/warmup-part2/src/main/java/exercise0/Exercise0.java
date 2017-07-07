package exercise0;

import java.util.HashMap;
import java.util.*;

/**
 * Created by Radu.Hoaghe on 4/20/2015.
 *
 * Exercise 0: Iterate over the keys of a Map using keySet method (this method returns a Set of all the map keys) and
 *          print all its elements.
 */
public class Exercise0 {

    public Exercise0(){

    }

    public void iterateThroughMap(){

        // TODO Exercise #0 a) Create a Map (HashMap) and add elements to it (using put() method)
        Map<Integer,String> map=new HashMap<Integer,String>();
        map.put(1,"Marcel");
        map.put(2,"Ionel");
        map.put(3,"Georgel");
        System.out.println(map);

        // TODO Exercise #0 a) Hint: Don't forget to specify the types of the key and value when creating the Map

        // TODO Exercise #0 b) Iterate over the Map using keySet() method and print all its elements
        System.out.println(map.keySet());
        for (int e:map.keySet()){
            System.out.println(""+e+"," +map.get(e)+"");
        }
        // TODO Exercise #0 b) The elements could be printed like this: [key1=value1, key2=value2, ...]
        //hashcode-> face referire la map-uri ,clasa Object, intoarce un int, pentru intreg intoarce valoarea lui,
        //iar pentru altceva un int diferit, pentru a compara 2 obiecte retinem hascode-ul lor si vedem daca sunt egale
    }

    public static void main(String[] args) {
        Exercise0 exercise0 = new Exercise0();
        exercise0.iterateThroughMap();
    }
}
