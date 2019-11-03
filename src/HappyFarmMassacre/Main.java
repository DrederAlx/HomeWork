package HappyFarmMassacre;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Farm farm1 = new Farm();
        Farmer farmer1 = new Farmer(20);
        farm1.farmer = farmer1;
        farmer1.farm = farm1;
        farm1.addAnimals();



        System.out.println(Arrays.toString(farm1.homeAnimals));
        System.out.println(farmer1);
        farmer1.collectRes();
        System.out.println(farmer1);
        System.out.println(Arrays.toString(farm1.homeAnimals));
        farmer1.collectRes();
        System.out.println(Arrays.toString(farm1.homeAnimals));
        farmer1.collectRes();
        System.out.println(Arrays.toString(farm1.homeAnimals));
        farmer1.collectRes();
        System.out.println(Arrays.toString(farm1.homeAnimals));

    }
}
