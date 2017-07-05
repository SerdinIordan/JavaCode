package ro.teamnet.zerotohero.proiect;

/**
 * Created by Iordan.Serdin on 7/4/2017.
 */
public class AnimalZooFeroce extends Animal{

    @Override
    public void mananca(Object o) {
        System.out.println("metoda mostenita de la parintele Animal:mananca(Object o)");
        if (o instanceof AngajatZoo){
            throw new AnimalManancaOmException("Animal mananca om exception");
        }else{
            System.out.println("AnimalZooFeroce mananca");
        }

    }

    @Override
    public void seJoaca() {
        System.out.println("metoda mostenita de la parintele Animal:seJoaca()");
    }

    @Override
    public void faceBaie() {
        System.out.println("metoda mostenita de la parintele Animal:faceBaie()");
    }
    public void doarme(){
        System.out.println("metoda suprascrisa de la parintele Animal:doarme()");
        super.doarme();
        System.out.println("Animalul feroce vaneaza");
    }
}
