package ro.teamnet.zerotohero.exceptions;

/**
 * Created by Iordan.Serdin on 7/4/2017.
 */
public class RunApp {

    public static void main(String args[]) throws MyException{
        ExceptionPropagation e=new ExceptionPropagation();
        e.metodaTratare();

        TryCatch tc=new TryCatch();
        tc.metoda1();
        //nested
        NestedException ne=new NestedException();
        ne.metoda();


    }
}
