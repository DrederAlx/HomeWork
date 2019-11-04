package HappyFarmMassacre.animals;

public class Cow extends HomeAnimal {
    public Cow(int weight, int speed, String name, int health, int resources, boolean eatable, int maxHealth, int maxResources) {
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
        this.setName(cowNames[nameId]);
        this.setResources((int) (Math.random() * 9) + 12);
        this.setMaxResources(getResources());
        this.setWeight((int) (Math.random() * 11) + 20);
        this.setSpeed((int) (Math.random() * 6) + 5);
        this.setHealth((int) (Math.random() * 6) + 20);
        this.setMaxHealth(getHealth());
        this.setEatable(true);
    }

    @Override
    public String toString() {
        return "Cow{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", resources=" + resources +
                ", eatable=" + eatable +
                ", weight=" + weight +
                ", speed=" + speed +
                '}';
    }
}
