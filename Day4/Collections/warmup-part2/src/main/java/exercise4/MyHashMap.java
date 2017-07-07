package exercise4;

import java.util.*;
//perechea key-value o putem face cu MyHashMap.MyEntry interfata definita de noi
/**
 * Exercise 3. Implement a HashMap from scratch. In order to pass all the tests
 * you need to implement all the methods defined below. The key-value pair will
 * be encapsulated in the MyHashMap.MyEntry object defined below.
 *
 * //MyEntry reprezinta intrarea ,elementele de acest tip sunt stocate in "buckets" (obiecte)
 * The buckets list in which each MyEntry object will be stored is stored in "buckets" object.
 * The hash function that you will use in order to store a pair in a specific bucket will be
 * the one presented earlier: (hashcode value) modulo (bucket array size)
 */
public class MyHashMap {

    private ArrayList<LinkedList<MyEntry>> buckets;

    private final int BUCKET_ARRAY_SIZE = 16;

    public MyHashMap() {

        // TODO Initialize buckets list
        buckets=new ArrayList<LinkedList<MyEntry>>(BUCKET_ARRAY_SIZE);

        for (int i=0;i<BUCKET_ARRAY_SIZE;i++){
//            buckets.get(i)=new LinkedList<MyEntry>() ;
            buckets.add(new LinkedList<MyEntry>());
            System.out.println(buckets.get(i));
        }
    }

    public String get(String key) {
        for (MyEntry aux:buckets.get(Math.abs(key.hashCode()%BUCKET_ARRAY_SIZE))){
            if (aux.getKey().equals(key)){
                return aux.getValue();
            }
        }
        // TODO
        return null;
    }

    public void put(String key, String value) {
        // TODO
        MyEntry b=new MyEntry(key,value);
      /* if (buckets.get(Math.abs(key.hashCode()%BUCKET_ARRAY_SIZE)).contains(key)){
           buckets.get(Math.abs(key.hashCode()%BUCKET_ARRAY_SIZE)).contains(key).
       }*/
        if (key==null){
            buckets.get(0).add(b);
        }
        buckets.get(Math.abs(key.hashCode()%BUCKET_ARRAY_SIZE)).add(b);
    }

    public Set<String> keySet() {
        Set<String> rez=new TreeSet<String>();
        for (int i=0;i<buckets.size();i++){
            for (int j=0;j<buckets.get(i).size();j++){
                rez.add(buckets.get(i).get(j).getKey());
            }
        }
        // TODO
        if (rez==null) {
            return null;
        }else{
            return rez;
        }
    }

    public Collection<String> values() {
        ArrayList<String> rez=new ArrayList<String>();
        for (int i=0;i<buckets.size();i++){
            for (int j=0;j<buckets.get(i).size();j++){
                rez.add(buckets.get(i).get(j).getValue());
            }
        }
        // TODO
        if (rez==null) {
            return null;
        }else{
            return rez;
        }

    }

    public String remove(String key) {
        // TODO Returns the value associated with the key removed from the map or null if the key wasn't found
        String aux=null;
//
        for(MyEntry a : buckets.get(Math.abs(key.hashCode()%BUCKET_ARRAY_SIZE))){
            if(a.getKey().equals(key)){
                aux = a.getValue();
                 buckets.get(Math.abs(key.hashCode()%BUCKET_ARRAY_SIZE)).remove(a);
            }
        }

        if (aux==null)
        return null; else{
            return aux;
        }
    }

    public boolean containsKey(String key) {
        // TODO
        return false;
    }

    public boolean containsValue(String value) {
        // TODO
        return false;
    }

    public int size() {

        // TODO Return the number of the Entry objects stored in all the buckets
        int s=0; //size
        for (int i=0;i<buckets.size();i++){
            s=s+buckets.get(i).size();
        }
        return s;
    }

    public void clear() {
        // TODO Remove all the Entry objects from the bucket list
    }

    public Set<MyEntry> entrySet() {
        // TODO Return a Set containing all the Entry objects
        return null;
    }

    public boolean isEmpty() {
        // TODO
        return false;
    }
    public String toString(){
        String rez="";
        for (int i=0;i<buckets.size();i++){
            System.out.println(i);
            rez=rez+buckets.get(i);
        }
        return rez;
    }

    public static class MyEntry {
        private String key;
        private String value;

        public MyEntry(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
        public String toString(){
            return "["+key+","+value+"]";
        }
    }
}
