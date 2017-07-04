package ro.teamnet.zerotohero.proiect;

/**
 * Created by Iordan.Serdin on 7/4/2017.
 */
public class VeterinarZoo implements AngajatZoo {
    int nrAnimale;
    @Override
    public void lucreaza(Animal animal) {
        System.out.println("veterinarul are grija de animal");
        if (animal instanceof AnimalZooFeroce){
            animal.faceBaie();
        }else{
            nrAnimale++;
        }
    }

    @Override
    public int calculeazaBonusSalarial() {
        return 2*50*nrAnimale;
    }
}
