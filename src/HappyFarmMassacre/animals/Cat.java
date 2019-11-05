package HappyFarmMassacre.animals;

public class Cat extends HomeAnimal {
    public Cat(int weight, int speed, String name, int health, int resources, boolean eatable, int maxHealth, int maxResources) {
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
    public Cat() {
        int nameId;
        nameId = (int) (Math.random() * catNames.length);
        setName(catNames[nameId]);
        setResources(0);
        setMaxResources(0);
        setWeight((int) (Math.random() * 6) + 4);
        setSpeed((int) (Math.random() * 6) + 10);
        setHealth((int) (Math.random() * 6) + 5);
        setMaxHealth(getHealth());
        setEatable(false);
    }
}
