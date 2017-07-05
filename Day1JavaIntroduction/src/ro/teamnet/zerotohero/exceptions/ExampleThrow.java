package ro.teamnet.zerotohero.exceptions;

/**
 * Created by Iordan.Serdin on 7/4/2017.
 */
public class ExampleThrow extends Throwable {
    public ExampleThrow() throws MyException{
        throw new MyException("incercati din nou");
    }


}
