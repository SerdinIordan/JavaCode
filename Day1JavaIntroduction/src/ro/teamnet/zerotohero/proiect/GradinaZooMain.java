package ro.teamnet.zerotohero.proiect;

/**
 * Created by Iordan.Serdin on 7/4/2017.
 */
public class GradinaZooMain {
    public static void main(String args[]) {
        AnimalZooBar animal1=new AnimalZooBar("Pinguin");
        AnimalZooBar animal2=new AnimalZooBar("Elefant","Africa");
        AnimalZooBar animal3=new AnimalZooBar();

        AnimalZooFeroce animalFeroce=new AnimalZooFeroce();

        AngajatZoo angajat1=new IngrijitorZoo();
        IngrijitorZoo angajat2=new IngrijitorZoo();

        AngajatZoo angajat3=new VeterinarZoo();
        VeterinarZoo angajat4=new VeterinarZoo();
        System.out.println(animal1.getNumele());
        System.out.println(animal1.getNumeleTariiDeOrigine());
        System.out.println(animal2.getNumele());
        System.out.println(animal2.getNumeleTariiDeOrigine());
        System.out.println(animal3.getNumele());
        System.out.println(animal3.getNumeleTariiDeOrigine());

        //apelul metodelor
        angajat3.lucreaza(animal1);
        angajat3.lucreaza(animal2);
        angajat3.lucreaza(animal3);
        angajat4.lucreaza(animal1);
        angajat4.lucreaza(animal2);
        angajat4.lucreaza(animal3);

        angajat1.lucreaza(animal1);
        angajat1.lucreaza(animal2);
        angajat1.lucreaza(animal3);

        angajat2.lucreaza(animal1);
        angajat2.lucreaza(animal2);
        angajat2.lucreaza(animal3);
        try {
            angajat2.lucreaza(animal1, null);
        }catch(AnimalPeCaleDeDisparitieException e){
            e.printStackTrace();
        }
        try {
            angajat2.lucreaza(animal1, angajat1);
        }catch (Exception  e){
            e.printStackTrace();
        }
        try {
            angajat2.lucreaza(animal1, new String("Mancare"));
        }catch (Exception e){
            e.printStackTrace();
        }
            angajat2.lucreaza(animalFeroce);
        try {
            angajat2.lucreaza(animalFeroce, null);
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            angajat2.lucreaza(animalFeroce, new String("Mancare"));
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Finish!!");







    }
}
