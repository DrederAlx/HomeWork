package HappyFarmMassacre;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Farm farm1 = new Farm();
        farm1.farmer = new Farmer(20);
        farm1.addAnimals();
        System.out.println(Arrays.toString(farm1.homeAnimals));
        System.out.println(farm1);
        System.out.println(Arrays.toString(farm1.homeAnimals));

    }
}
