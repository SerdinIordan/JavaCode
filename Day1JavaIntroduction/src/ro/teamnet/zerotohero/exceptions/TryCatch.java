package ro.teamnet.zerotohero.exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class TryCatch {
    //try catch example
    public void metoda1(){
        try{
            BufferedReader br=new BufferedReader(new FileReader("fisier.txt"));
            String s=br.readLine(); //citeste linia dintr-un fisier
            System.out.println(s);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //try catch with resources
    public String metoda2() {

           try(BufferedReader br=new BufferedReader(new FileReader("fisier.txt"))){
               return br.readLine();
           } catch (FileNotFoundException e) {
               e.printStackTrace();
               return null;
           } catch (IOException e) {
               e.printStackTrace();
               return null;
           }


    }
    //try-catch-finally
    public void metoda3() throws Exception{
        BufferedReader br=null;
        try{
            br=new BufferedReader(new FileReader("fisier.txt"));
            String s=br.readLine(); //citeste linia dintr-un fisier
            System.out.println(s);
        }catch(Exception e){
            e.printStackTrace();
        }
        finally {
            br.close();
        }
    }
    //try-finally
    public void metoda4() throws Exception{
        BufferedReader br=null;
        try{
            br=new BufferedReader(new FileReader("fisier.txt"));
            String s=br.readLine(); //citeste linia dintr-un fisier
            System.out.println(s);
        }
        finally {

            br.close();
        }
    }

    public void metoda5() {
        BufferedReader br;
        try{
            br=new BufferedReader(new FileReader("fisier.txt"));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }






}
