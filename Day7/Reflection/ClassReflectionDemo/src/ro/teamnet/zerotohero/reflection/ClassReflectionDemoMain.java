package ro.teamnet.zerotohero.reflection;

import ro.teamnet.zerotohero.reflection.demoobjects.EnumClass;
import ro.teamnet.zerotohero.reflection.demoobjects.FirstClass;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

/**
 * TODO
 * in order to resolve the exercises below, you will have to create
 * all the needed clasees, with their members and methods
 * (in ro.teamnet.zerotohero.reflection.demoobjects package)
 */
public class ClassReflectionDemoMain {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        //TODO get the class for a String object, and print it
      /*  try {
            FirstClass f = new FirstClass("abc");
            Field privateStringField = f.getClass().getDeclaredField("nume");   //ne folosim de numele field(camp)
            privateStringField.setAccessible(true);
            String valoare = (String) privateStringField.get(f);

            System.out.println(valoare.getClass());
        }catch(NoSuchFieldException e){
            e.printStackTrace();
        }
        //TODO get the class of an Enum, and print it
        try {
            FirstClass e = new FirstClass();

            System.out.println(e.getClass().getDeclaredField("Day").getType());

        }catch(NoSuchFieldException e){
            e.printStackTrace();
        }
        

        //TODO get the class of a collection, and print it
        try {

            FirstClass e = new FirstClass();

            System.out.println(e.getClass().getDeclaredField("c").getType());   //ne folosim de numele field(camp)



        }catch(NoSuchFieldException e){
            e.printStackTrace();
        }
        

        //TODO get the class of a primitive type, and print it
            System.out.println(int.class);

        

        //TODO get and print the class for a field of primitive type
        try{
            FirstClass e = new FirstClass();
         //   System.out.println(int.class);
            System.out.println(e.getClass().getDeclaredField("i").getType());
            //System.out.println(e.getClass().getDeclaredFields()[1].getType());

        }catch(Exception e){
            e.printStackTrace();
        }
        

        //TODO get and print the class for a primitive type, using the wrapper class
        System.out.println(Integer.TYPE);
        try{
            Class c = Boolean.TYPE;
            FirstClass e = new FirstClass();
            //System.out.println(int.class);
            //System.out.println(e.getClass().getDeclaredField("y").);
            //System.out.println(e.getClass().getDeclaredFields()[1].getType());

        }catch(Exception e){
            e.printStackTrace();
        }
        

        //TODO get the class for a specified class name
        try{
           // String s=new String("Ion");
            Class c=Class.forName("java.lang.Integer");
            System.out.println(c.getName());

        }catch(Exception e){
            e.printStackTrace();
        }
        

        //TODO get the superclass of a class, and print it

        Class c=Class.forName("java.lang.Integer");
        System.out.println(c.getSuperclass());

        //TODO get the superclass of the superclass above, and print it
        

        //TODO get and print the declared classes within some other class
        

        //TODO print the number of constructors of a class
        Class d=Class.forName("java.lang.Integer");
        System.out.println(d.getDeclaredConstructors().length);
        

        //TODO get and invoke a public constructor of a class*/
        try {
            Method testMethod = FirstClass.class.getMethod("test", int.class);
            int result = (Integer) testMethod.invoke(new FirstClass(), 100);
            System.out.println(result); // 101

            Method m2=FirstClass.class.getMethod("FirstClass",String.class);
            String result2 = (String) m2.invoke(new FirstClass(),"marcel");
            System.out.println(result2);




        }catch(Exception e){
            e.printStackTrace();
        }

        //FirstClass e = new FirstClass();
       /* try {
            Method testMethod = FirstClass.class.getMethod("FirstClass");
           // int result = (Integer) testMethod.invoke(new FirstClass(), 100);
            testMethod.invoke(new FirstClass());
           // testMethod.invoke(new FirstClass(), 100);
           // System.out.println(result); // 101
        }catch(Exception e){
            e.printStackTrace();
        }*/



       // Method m=e.getDeclaredMethod("afiseaza",)
       // e.getDeclaredConstructors()

        //TODO get and print the class of one private field 
        
		
		//TODO set and print the value of one private field for an object
        

        //TODO get and print only the public fields class
        

        //TODO get and invoke one public method of a class
        

        //TODO get and invoke one inherited method of a class
       
		
		//TODO invoke a method of a class the classic way for ten times, and print the timestamp (System.currentTimeMillis())
		//TODO invoke a method of a class by Reflection for 100 times, and print the timestamp
		//what do you observe?
		
    }
}
