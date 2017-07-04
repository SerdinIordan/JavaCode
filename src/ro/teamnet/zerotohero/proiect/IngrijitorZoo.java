package ro.teamnet.zerotohero.proiect;

/**
 * Created by Iordan.Serdin on 7/4/2017.
 */
public class IngrijitorZoo implements AngajatZoo {
    int nrAnimale=0; //numarul de animale cu care lucreaza angajatul
    public void lucreaza(Animal animal) {
        System.out.println("Ingrijitorul intra in cusca animalului");
    }



    public void lucreaza(Animal animal,Object mancare) throws AnimalPeCaleDeDisparitieException{
        this.lucreaza(animal);
        animal.mananca(mancare);
        animal.seJoaca();
        animal.faceBaie();
        if (animal instanceof AnimalZooBar && mancare==null){
            throw new AnimalPeCaleDeDisparitieException();
        }else {
            nrAnimale++;
        }

    }
    @Override
    public int calculeazaBonusSalarial() {
        return 3*nrAnimale*50;
    }
}
