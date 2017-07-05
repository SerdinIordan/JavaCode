package ro.teamnet.zerotohero.exceptions;

/**
 * Created by Iordan.Serdin on 7/4/2017.
 */
public class ExceptionPropagation {
    //exception propagation
    public void metoda(){
        int data=20/0;
    }
    public void metodaTratare(){
        try{
            metoda();
        }catch(Exception e){
            System.out.println("exceptia s-a apelat si a fost tratata");
        }
    }

}
