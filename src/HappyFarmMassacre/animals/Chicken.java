package HappyFarmMassacre.animals;

public class Chicken extends HomeAnimal {
    public Chicken(int weight, int speed, String name, int health, int resources, boolean eatable, int maxHealth, int maxResources) {
        super(weight, speed, name, health, resources, eatable, maxHealth, maxResources);
        setWeight(weight);
        setSpeed(speed);
        setName(name);
        setHealth(health);
        setResources(resources);
        setEatable(eatable);
        setMaxHealth(maxHealth);
        setMaxResources(maxResources);
    }

    public Chicken() {
        int nameId;
        nameId = (int) (Math.random() * chickenNames.length);
        setName(chickenNames[nameId]);
        setResources((int) (Math.random() * 8) + 8);
        setMaxResources(getResources());
        setWeight((int) (Math.random() * 4) + 2);
        setSpeed((int) (Math.random() * 5) + 8);
        setHealth((int) (Math.random() * 7) + 12);
        setMaxHealth(getHealth());
        setEatable(true);
    }
}
