package ro.teamnet.zerotohero.exceptions;


public class NestedException {
    public void metoda() throws MyException {
        try{
            int a[]=new int[5];
            a[5]=2;

        }catch (ArrayIndexOutOfBoundsException e){
            throw new MyException("depasim numarul de elemente");
        }
    }



}
