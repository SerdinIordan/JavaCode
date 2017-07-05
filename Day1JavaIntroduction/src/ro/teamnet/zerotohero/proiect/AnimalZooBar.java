package ro.teamnet.zerotohero.proiect;

/**
 * Created by Iordan.Serdin on 7/4/2017.
 */
public class AnimalZooBar extends Animal{

    private String numele;
    private String numeleTariiDeOrigine;

    public AnimalZooBar(){

    }

    public AnimalZooBar(String numele) {
        this.numele = numele;
    }

    public AnimalZooBar(String numele, String numeleTariiDeOrigine) {
        this.numele = numele;
        this.numeleTariiDeOrigine = numeleTariiDeOrigine;
    }


    public String getNumele() {
        return numele;
    }

    public void setNumele(String numele) {
        this.numele = numele;
    }

    public String getNumeleTariiDeOrigine() {
        return numeleTariiDeOrigine;
    }

    public void setNumeleTariiDeOrigine(String numeleTariiDeOrigine) {
        this.numeleTariiDeOrigine = numeleTariiDeOrigine;
    }

    @Override
    public void mananca(Object o) throws AnimalPeCaleDeDisparitieException {
        if (o instanceof AngajatZoo){
            throw new AnimalManancaOmException("Animal mananca om exception");
        }
        else{
            System.out.println("AnimalZooBar mananca");
        }
    }

    @Override
    public void seJoaca() {
        super.doarme();
        System.out.println("AnimalulZooBar se joaca");
    }

    @Override
    public void faceBaie() {
        System.out.println("AnimalulZooBar face baie");
    }
}
