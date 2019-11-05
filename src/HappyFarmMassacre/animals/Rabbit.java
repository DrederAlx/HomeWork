package HappyFarmMassacre.animals;

public class Rabbit extends HomeAnimal {
    public Rabbit(int weight, int speed, String name, int health, int resources, boolean eatable, int maxHealth, int maxResources) {
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

    public Rabbit() {
        int nameId;
        nameId = (int) (Math.random() * rabbitNames.length);
        setName(rabbitNames[nameId]);
        setResources(0);
        setMaxResources(getResources());
        setWeight((int) (Math.random() * 4) + 2);
        setSpeed((int) (Math.random() * 6) + 15);
        setHealth((int) (Math.random() * 8) + 8);
        setMaxHealth(getHealth());
        setEatable(true);
    }
}

