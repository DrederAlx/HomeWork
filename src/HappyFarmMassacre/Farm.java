package HappyFarmMassacre;

import HappyFarmMassacre.animals.*;

import java.util.Arrays;

public class Farm {
    protected HomeAnimal[] homeAnimals = new HomeAnimal[10];
    protected Farmer farmer;

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

    public boolean canCollectCheck(){
        boolean canCollect = false;
        for (int i = 0; i < this.homeAnimals.length; i++) {
            if (this.homeAnimals[i] != null && this.homeAnimals[i].getResources() != 0) {
                canCollect = true;
            break;
            }
        }
        return canCollect;
    }

    public int collect() {
        int collectedRes = 0;
        int resCount = farmer.resFarmer;
        for (int i = 0; i < this.homeAnimals.length; i++) {
            if (this.homeAnimals[i] != null && this.homeAnimals[i].getResources() != 0) {
                farmer.setResFarmer(farmer.getResFarmer() + this.homeAnimals[i].getResources());
                collectedRes = collectedRes + this.homeAnimals[i].getResources();
                this.homeAnimals[i].setResources(0);
            }
        }
        return collectedRes;
    }

    public boolean canEatCheck() {
        boolean canEat = false;
        for (int i = 0; i < this.homeAnimals.length; i++) {
            if (this.homeAnimals[i] != null && this.homeAnimals[i].isEatable()) {
                canEat = true;
                break;
            }
        }
        return canEat;
    }

    public void eat(){
        int pos = -1;
        int maxWeight = 0;
        for (int i = 0; i < this.homeAnimals.length; i++) {  // ищем первое съедобное животное, для последующего сравнения веса
            if (this.homeAnimals[i] != null && this.homeAnimals[i].isEatable()) {
                pos = i;
                maxWeight = this.homeAnimals[i].getWeight();
                break;
            }
        }
        for (int j = pos + 1; j < this.homeAnimals.length; j++) { // поиск съедобного животного с максимальным весом
            if (this.homeAnimals[j] != null && this.homeAnimals[j].getWeight() > maxWeight && this.homeAnimals[j].isEatable()) {
                pos = j;
                maxWeight = this.homeAnimals[j].getWeight();
            }
        }
        farmer.setResFarmer(farmer.getResFarmer() + this.homeAnimals[pos].getWeight()); // поедание
        System.out.println("На ферме не осталось ресурсов и фермер скушал животное по имени " + this.homeAnimals[pos].getName() + " пополнив запас ресурсов на "
                + (this.homeAnimals[pos].getWeight()) + " едениц");
        this.homeAnimals[pos] = null;
    }



        public void dayPass(){
        farmer.spendRes();
        farmer.collectRes();
    }

    public HomeAnimal[] getHomeAnimals() {
        return homeAnimals;
    }

    public void setHomeAnimals(HomeAnimal[] homeAnimals) {
        this.homeAnimals = homeAnimals;
    }
}
