package com.java_8_training.problems.lambdas;


import com.java_8_training.problems.lambdas.model.Apple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;

//din fara lambda cu lambda, fara refractor
public class LambdasRefactor {
    public static void main(String[] args) {

        System.out.println(sortInventoryByDecreasingWeight());
        //List <Apple> result=sortInventoryByDecreasingWeight();
        System.out.println(filterGreenApples());
    }

    //acesta sorteaza descrescator dupa greutate
    public static List<Apple> sortInventoryByDecreasingWeight() {
        //TODO: refactor to use lambda expression


        List<Apple> inventory = asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));
        inventory.sort(
                (a1,a2)->a2.getWeight().compareTo(a1.getWeight()));   //ce parametrii foloseste metoda a1,a2la compare si returneaza rez
        return inventory;
       /* inventory.sort(new Comparator<Apple>() {   //clasa anonima implementeaza metoda compare
            @Override
            public int compare(Apple apple1, Apple apple2) {
                return apple2.getWeight().compareTo(apple1.getWeight());
            }
        });
        return inventory;*/
    }

    public static List<Apple> filterGreenApples() {

        // TODO: refactor to use lambda expression
        // TODO: refactor to use standard functional interface
        List<Apple> inventory = asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));

        List <Apple> greenApples2=filterApples(inventory,(a)->a.getColor().equals("green"));

        return inventory;
      /*  List<Apple> greenApples = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {

                return "green".equals(apple.getColor());
            }
        });*/

        //return inventory;
    }

    private static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
    @FunctionalInterface
    interface ApplePredicate {
        boolean test(Apple apple);
    }
}
