package HappyFarmMassacre;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Farm farm1 = new Farm();
        Farmer farmer1 = new Farmer(20);
        farm1.farmer = farmer1;
        farmer1.farm = farm1;
        farm1.addHomeAnimals();
        farm1.addWildAnimals();
        System.out.println(farm1);
        farm1.visitFarm();
        System.out.println(farm1);




        /*
        System.out.println(farmer1);
        System.out.println(Arrays.toString(farm1.homeAnimals));
        farmer1.collectRes();
        System.out.println(farmer1);
        System.out.println(Arrays.toString(farm1.homeAnimals));
        farmer1.collectRes();
        System.out.println(farmer1);
        System.out.println(Arrays.toString(farm1.homeAnimals));
        farmer1.collectRes();
        System.out.println(farmer1);
        System.out.println(Arrays.toString(farm1.homeAnimals));
         */

    }
}
