package HappyFarmMassacre;

import HappyFarmMassacre.animals.*;

import java.util.Arrays;

public class Farm {
    private HomeAnimal[] homeAnimals = new HomeAnimal[10];

    @Override
    public String toString() {
        return "Farm{" +
                "homeAnimals=" + Arrays.toString(homeAnimals) +
                '}';
    }

    public void addAnimals() {
        int animalId;
        HomeAnimal newAn = null;
        for (int i = 0; i < this.homeAnimals.length; i++) {
            animalId = (int) (Math.random() * 3) + 1;
            switch (animalId) {
                case 1:
                    newAn = new Cat();
                    this.homeAnimals[i] = newAn;
                    break;
                case 2:
                    newAn = new Cow();
                    this.homeAnimals[i] = newAn;
                    break;
                case 3:
                    newAn = new Rabbit();
                    this.homeAnimals[i] = newAn;
                    break;
                case 4:
                    newAn = new Chicken();
                    this.homeAnimals[i] = newAn;
                    break;
            }
        }
    }
    public void dayPass(){

    }

    public HomeAnimal[] homeAnimals() {

        return homeAnimals;
    }
}
