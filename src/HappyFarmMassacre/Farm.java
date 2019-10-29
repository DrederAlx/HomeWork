package HappyFarmMassacre;

import HappyFarmMassacre.animals.*;

import java.util.Arrays;

public class Farm {
    private Home[] homeAnimals = new Home[10];

    @Override
    public String toString() {
        return "Farm{" +
                "homeAnimals=" + Arrays.toString(homeAnimals) +
                '}';
    }

    public void addAnimals() {
        int animalId;
        Home newAn = null;
        for (int i = 0; i < this.homeAnimals.length; i++) {
            animalId = (int) (Math.random() * 3) + 1;
            switch (animalId) {
                case 1:
                    newAn = new Cat(7, 15, "Кот", 10, 0, false);
                    this.homeAnimals[i] = newAn;
                    break;
                case 2:
                    newAn = new Cow(20, 5, "Корова", 15, 15, true);
                    this.homeAnimals[i] = newAn;
                    break;
                case 3:
                    newAn = new Rabbit(4, 20, "Кролик", 10, 10, true);
                    this.homeAnimals[i] = newAn;
                    break;
                case 4:
                    newAn = new Chicken(2, 10, "Курица", 5, 5, true);
                    this.homeAnimals[i] = newAn;
                    break;
            }
        }


    }
}
