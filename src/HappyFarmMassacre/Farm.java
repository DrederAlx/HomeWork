package HappyFarmMassacre;

import HappyFarmMassacre.animals.*;

public class Farm {
    private HomeAnimal[] homeAnimals = new HomeAnimal[10];
    private WildAnimal[] wildAnimals = new WildAnimal[3];
    protected Farmer farmer;

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

    public void addWildAnimals() {
        WildAnimal newAn = null;
        for (int i = 0; i < wildAnimals.length; i++) {
            switch (i) {
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

    public boolean canCollectCheck() {
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
                homeAnimals[i].setResources(0);
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

    public void eat() {
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
                + (homeAnimals[pos].getWeight()) + " едениц.");
        homeAnimals[pos] = null;
    }

    public boolean ticketCheck() {
        boolean ticketCheck = false;
        for (int i = 0; i < wildAnimals.length; i++) {
            if (wildAnimals[i].getFarmTicket() > 0) {
                ticketCheck = true;
            }
        }
        return ticketCheck;
    }

    public WildAnimal visitorChooser () {
        WildAnimal wildAnimal = null;
        int wildID;
        if (ticketCheck()) {
            wildID = (int) (Math.random() * wildAnimals.length);
            while (wildAnimals[wildID].getFarmTicket() == 0) {
                wildID = (int) (Math.random() * wildAnimals.length);
            }
            wildAnimal = wildAnimals[wildID];
        }
        return wildAnimal;
    }

    public boolean anybodyOnFarm(){
        boolean anybodyThere = false;
        for (int i = 0; i < homeAnimals.length; i++) {
            if (homeAnimals[i] != null) {
                anybodyThere = true;
                break;
            }
        }
        return anybodyThere;
    }

    public void visitFarm() {
        WildAnimal visitor = visitorChooser();
        if (visitor == null) {
            System.out.println("Все дикие звери прячутся в лесу. Настоящий дикий зверь - это фермер.");
        }
        else {
            System.out.println("На ферму пришел " + visitor.getName() + ".");
            if (farmer.kickOut()) {
                System.out.println(visitor.getName() + " убежал, так как его прогнал фермер.");
                visitor.setFarmTicket(visitor.getFarmTicket() - 1);
            }
            else {
                System.out.println("Фермер не смог его прогнать.");
                if (anybodyOnFarm()) {
                    int homeID = (int) (Math.random() * homeAnimals.length);
                    while (homeAnimals[homeID] == null) {
                        homeID = (int) (Math.random() * homeAnimals.length);
                    }
                    System.out.println(visitor.getName() + " погнался за домашним животным по имени " + homeAnimals[homeID].getName() + ".");
                    if (visitor.getSpeed() >= homeAnimals[homeID].getSpeed()) {
                        if (visitor.getAttackScore() >= homeAnimals[homeID].getHealth()) {
                            System.out.println(visitor.getName() + " скушал домашнее животное по имени " + homeAnimals[homeID].getName() + " насмерть.");
                            homeAnimals[homeID] = null;
                        }
                        else {
                            System.out.println(visitor.getName() + " слегка отведал домашнее животное по имени " +
                                    homeAnimals[homeID].getName() + " снизив его здоровье до " +
                                    (homeAnimals[homeID].getHealth() - visitor.getAttackScore()) + " едениц.");
                            homeAnimals[homeID].setHealth(homeAnimals[homeID].getHealth() - visitor.getAttackScore());
                        }
                    }
                    else {
                        System.out.println(visitor.getName() + " не смог догнать домашнее животное по имени " +
                                homeAnimals[homeID].getName() + " и вернулся в лес.");
                    }
                }
                else {
                    System.out.println(visitor.getName() + " не смог никого скушать, все уже скушано до нас.");
                }
            }
        }
    }

    public void restore(){
        for (int i = 0; i < homeAnimals.length; i++) {
            if (homeAnimals[i] != null) {
                homeAnimals[i].setResources(homeAnimals[i].getMaxResources());
                homeAnimals[i].setHealth(homeAnimals[i].getHealth() + 1);
            }
        }
    }

    public void dayPass(){
        System.out.println("На ферме начался новый день.");
        System.out.println("На начало дня у фермера " + farmer.getResFarmer() + " едениц ресурсов.");
        farmer.spendRes();
        visitFarm();
        farmer.feed();
        farmer.collectRes();
        System.out.println("Еще один прекрасный день на ферме подошел к концу. У фермера осталось " +
                farmer.getResFarmer() + " едениц ресурсов.\n");
    }
}
