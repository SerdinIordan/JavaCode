package exercise.exercise1;

import java.util.*;

/**
 * Created by Radu.Hoaghe on 4/20/2015.
 * <p>
 * Exercise 1: Compute the sum, the minimum and the maximum element from a given list (givenList) using three
 * different ways to iterate over a List:
 * a) ListIterator (implement it in the iterateUsingListIterator() method)
 * b) for loop (implement it in the iterateUsingForLoop() method)
 * c) foreach loop (implement it in the iterateUsingForEachLoop() method)
 * <p>
 * In order to test your implementations you need to run the Exercise1Test from the test/java package
 * (right-click on Exercise1Test class then click Run 'Exercise1Test' )
 */
public class Exercise1 {

    // The list that contains some Integer values
    private List<Integer> givenList;

    public Exercise1(List<Integer> l) {
        this.givenList = l;
    }

    // TODO Exercise #1 a) Compute sum and get the min and the max from givenList, iterating through it using ListIterator
    public List<Integer> iterateUsingListIterator() {

        ListIterator<Integer> ita = givenList.listIterator();
        System.out.println("Folosind ListIterator");
        int sum=0;
        int min=0;
        int max=0;
        int aux=0;
        if (ita.hasNext()){
            aux=ita.next();
            sum=aux;
            min=aux;
            max=aux;
        }
        while (ita.hasNext()) {
            sum = sum + ita.next();
        }
        //determinam minimul
        //ita.next()=aux;
        while (ita.hasNext()) {
            if (ita.next() < min) {
                min = ita.next();
            }
        }
        //determinam maximul
        max = givenList.get(0);
        while (ita.hasNext()) {
            if (ita.next() > max) {
                max = ita.next();
            }
        }


        // This List is used only for testing so you don't have to modify it
        List<Integer> testValues = new ArrayList<Integer>();


        // TODO Exercise #1 a1) In order to pass the tests, you need to name your variables sum, min and max or if
        // TODO Exercise #1 a1) you want to name them differently you need to modify them when you add them to testValues


        // TODO Exercise #1 a2) Uncomment the following three lines in order to check your computed values using tests
        testValues.add(sum);
        testValues.add(min);
        testValues.add(max);

        return testValues;
    }

    // TODO Exercise #1 b) Compute the sum and get the min and the max from the even (RO: pare) positions in the list,
    // TODO Exercise #1 b) iterating through it using classic for loop
    public List<Integer> iterateUsingForLoop() {

        // This List is used only for testing so you don't need to modify it
        List<Integer> testValues = new ArrayList<Integer>();
        int sum = 0;
        int min;
        int max;
        System.out.println("Folosind for clasic");
        for (int i = 0; i < givenList.size(); i++) {
            if (i%2==0) {
                sum = sum + givenList.get(i);
            }
        }
        min = givenList.get(0);
        for (int i = 0; i < givenList.size(); i++) {
            if (i%2==0) {
                if (givenList.get(i) < min) {
                    min = givenList.get(i);
                }
            }
        }
        max = givenList.get(0);
        for (int i = 0; i < givenList.size(); i++) {
            if (i%2==0) {
                if (givenList.get(i) > max) {
                    max = givenList.get(i);
                }
            }
        }


        // TODO Exercise #1 b1) In order to pass the tests, you need to name your variables sum, min and max or if
        // TODO Exercise #1 b1) you want to name them differently you need to modify them when you add them to testValues


        // TODO Exercise #1 b2) Uncomment the following three lines in order to check your computed values using tests
        testValues.add(sum);
        testValues.add(min);
        testValues.add(max);

        return testValues;
    }

    // TODO Exercise #1 c) Compute the sum and get the min and the max from the odd (RO: impare) elements of the list
    // TODO Exercise #1 c) iterating through it using foreach loop
    public List<Integer> iterateUsingForEachLoop() {

        // This List is used only for testing so you don't need to modify it
        int sum = 0;
        int min=0;
        int max=0;
        List<Integer> testValues = new ArrayList<Integer>();
        System.out.println("Folosind foreach");
        for (Integer elem:givenList){
            if (elem%2==1){
                sum=sum+elem;
            }
        }
        min=givenList.get(0);
        for (Integer elem:givenList){
            if (elem%2==1){
                if (elem<min){
                    min=elem;
                }
            }
        }
        max=givenList.get(0);
        for (Integer elem:givenList){
            if (elem%2==1){
                if (elem<min){
                    min=elem;
                }
            }
        }

        for (Integer elem:givenList){
            if (elem%2==1){
                if (elem>max){
                    max=elem;
                }
            }
        }


        // TODO Exercise #1 c1) In order to pass the tests, you need to name your variables sum, min and max or if
        // TODO Exercise #1 c1) you want to name them differently you need to modify them when you add them to testValues


        // TODO Exercise #1 c2) Uncomment the following three lines in order to check your computed values using tests
        testValues.add(sum);
        testValues.add(min);
        testValues.add(max);

        return testValues;
    }
}
