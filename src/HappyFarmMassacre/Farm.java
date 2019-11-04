package HappyFarmMassacre;

import HappyFarmMassacre.animals.*;

import javax.swing.*;
import java.util.Arrays;

public class Farm {
    protected HomeAnimal[] homeAnimals = new HomeAnimal[10];
    protected WildAnimal[] wildAnimals = new WildAnimal[3];
    protected Farmer farmer;

    @Override
    public String toString() {
        return  "homeAnimals=" + Arrays.toString(homeAnimals) + "\n" +
                "wildAnimals=" + Arrays.toString(wildAnimals) +
                '}';
    }

    public void addHomeAnimals() {
        int animalId;
        HomeAnimal newAn = null;
        for (int i = 0; i < homeAnimals.length; i++) {
            animalId = (int) (Math.random() * 3) + 1;
            switch (animalId) {
                case 1:
                    newAn = new Cat();
                    homeAnimals[i] = newAn;
                    break;
                case 2:
                    newAn = new Cow();
                    homeAnimals[i] = newAn;
                    break;
                case 3:
                    newAn = new Rabbit();
                    homeAnimals[i] = newAn;
                    break;
                case 4:
                    newAn = new Chicken();
                    homeAnimals[i] = newAn;
                    break;
            }
        }
    }

    public void addWildAnimals(){
        WildAnimal newAn = null;
        for (int i = 0; i < wildAnimals.length; i++) {
            switch (i){
                case 0:
                    newAn = new Fox();
                    wildAnimals[i] = newAn;
                    break;
                case 1:
                    newAn = new Wolf();
                    wildAnimals[i] = newAn;
                    break;
                case 2:
                    newAn = new Bear();
                    wildAnimals[i] = newAn;
                    break;
            }
        }
    }

    public boolean canCollectCheck(){
        boolean canCollect = false;
        for (int i = 0; i < homeAnimals.length; i++) {
            if (homeAnimals[i] != null && homeAnimals[i].getResources() != 0) {
                canCollect = true;
            break;
            }
        }
        return canCollect;
    }

    public int collect() {
        int collectedRes = 0;
        for (int i = 0; i < homeAnimals.length; i++) {
            if (homeAnimals[i] != null && homeAnimals[i].getResources() != 0) {
                farmer.setResFarmer(farmer.getResFarmer() + homeAnimals[i].getResources());
                collectedRes = collectedRes + homeAnimals[i].getResources();
              //  this.homeAnimals[i].setResources(0);
            }
        }
        return collectedRes;
    }

    public boolean canEatCheck() {
        boolean canEat = false;
        for (int i = 0; i < homeAnimals.length; i++) {
            if (homeAnimals[i] != null && homeAnimals[i].isEatable()) {
                canEat = true;
                break;
            }
        }
        return canEat;
    }

    public void eat(){
        int pos = -1;
        int maxWeight = 0;
        for (int i = 0; i < homeAnimals.length; i++) {  // ищем первое съедобное животное, для последующего сравнения веса
            if (homeAnimals[i] != null && homeAnimals[i].isEatable()) {
                pos = i;
                maxWeight = homeAnimals[i].getWeight();
                break;
            }
        }
        for (int j = pos + 1; j < homeAnimals.length; j++) { // поиск съедобного животного с максимальным весом
            if (homeAnimals[j] != null && homeAnimals[j].getWeight() > maxWeight && homeAnimals[j].isEatable()) {
                pos = j;
                maxWeight = homeAnimals[j].getWeight();
            }
        }
        farmer.setResFarmer(farmer.getResFarmer() + homeAnimals[pos].getWeight()); // поедание
        System.out.println("На ферме не осталось ресурсов и фермер скушал животное по имени " + homeAnimals[pos].getName() + " пополнив запас ресурсов на "
                + (homeAnimals[pos].getWeight()) + " едениц");
        homeAnimals[pos] = null;
    }
    public void visitFarm() { //TODO В этот метод нужно дописать вызов метода фермера "прогнать животное"
        int wildID = (int) (Math.random() * wildAnimals.length);
        System.out.println("На ферму пришел " + wildAnimals[wildID].getName() + ".");
        boolean anybodyThere = false;
        for (int i = 0; i < homeAnimals.length; i++) {
            if (homeAnimals[i] != null) {
                anybodyThere = true;
                break;
            }
        }
        if (anybodyThere) {
            int homeID = (int) (Math.random() * homeAnimals.length);
            while (homeAnimals[homeID] == null) {
                homeID = (int) (Math.random() * homeAnimals.length);
            }
            System.out.println(wildAnimals[wildID].getName() + " погнался за домашним животным по имени " + homeAnimals[homeID].getName() + ".");
            if (wildAnimals[wildID].getSpeed() >= homeAnimals[homeID].getSpeed()) {
                if (wildAnimals[wildID].getAttackScore() >= homeAnimals[homeID].getHealth()) {
                    System.out.println(wildAnimals[wildID].getName() + " скушал домашнее животное по имени " + homeAnimals[homeID].getName() + " насмерть.");
                    homeAnimals[homeID] = null;
                } else {
                    System.out.println(wildAnimals[wildID].getName() + " слегка отведал домашнее животное по имени " +
                            homeAnimals[homeID].getName() + " снизив его здоровье до " +
                            (homeAnimals[homeID].getHealth() - wildAnimals[wildID].getAttackScore()) + " едениц.");
                    homeAnimals[homeID].setHealth(homeAnimals[homeID].getHealth() - wildAnimals[wildID].getAttackScore());
                }
            } else {
                System.out.println(wildAnimals[wildID].getName() + " не смог догнать домашнее животное по имени " +
                        homeAnimals[homeID].getName() + " и вернулся в лес.");
            }
        }
        else {
            System.out.println(wildAnimals[wildID].getName() + " не смог никого скушать, все уже скушано до нас.");
        }
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
