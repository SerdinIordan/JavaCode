package ro.teamnet.zerotohero.proiect;

import java.util.Date;

/**
 * Created by Iordan.Serdin on 7/4/2017.
 */
public final class  GradinaZoo {
    String denumireGradinaZoo; // e imutabil
    Date dataDeschideriiGradinii; //nu e imutabil
    AnimalZooBar animalBar; //nu e imutabil
    IngrijitorZoo angajatulLunii; //nu e imutabil

    public GradinaZoo(String denumireGradinaZoo, Date dataDeschideriiGradinii, AnimalZooBar animalRar, IngrijitorZoo angajatulLunii) {
        this.denumireGradinaZoo = denumireGradinaZoo;
        this.dataDeschideriiGradinii = dataDeschideriiGradinii;
        AnimalZooBar animalZooBar = new AnimalZooBar();
        animalZooBar.setNumele(animalRar.getNumele());
       // animalZooBar.setNumele(animalRar.getNumele());
        this.animalBar = animalZooBar;

        this.angajatulLunii = angajatulLunii;
    }

}
