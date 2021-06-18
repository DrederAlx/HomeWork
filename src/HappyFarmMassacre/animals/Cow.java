package HappyFarmMassacre.animals;

public class Cow extends HomeAnimal {
    public Cow(int weight, int speed, String name, int health, int resources, boolean eatable,
               int maxHealth, int maxResources) {
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

    public Cow() {
        int nameId;
        nameId = (int) (Math.random() * cowNames.length);
        setName(cowNames[nameId]);
        setResources((int) (Math.random() * 9) + 12);
        setMaxResources(getResources());
        setWeight((int) (Math.random() * 11) + 20);
        setSpeed((int) (Math.random() * 6) + 5);
        setHealth((int) (Math.random() * 6) + 20);
        setMaxHealth(getHealth());
        setEatable(true);
    }
}
