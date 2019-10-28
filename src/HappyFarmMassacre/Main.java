package HappyFarmMassacre;

public class Main {
    public static void main(String[] args) {
        Farm farm1 = new Farm();
        Farmer farmer1 = new Farmer(50);
        farm1.addAnimals();
        System.out.println(farm1.toString());

    }
}
