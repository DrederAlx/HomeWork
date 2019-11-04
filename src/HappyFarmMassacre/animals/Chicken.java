package HappyFarmMassacre.animals;

public class Chicken extends HomeAnimal {
    public Chicken(int weight, int speed, String name, int health, int resources, boolean eatable, int maxHealth) {
        super(weight, speed, name, health, resources, eatable, maxHealth);
        setWeight(weight);
        setSpeed(speed);
        setName(name);
        setHealth(health);
        setResources(resources);
        setEatable(eatable);
        setMaxHealth(maxHealth);
    }

    public Chicken() {
        int nameId;
        nameId = (int) (Math.random() * chickenNames.length);
        this.setName(chickenNames[nameId]);
        this.setResources((int) (Math.random() * 8) + 8);
        this.setWeight((int) (Math.random() * 4) + 2);
        this.setSpeed((int) (Math.random() * 5) + 8);
        this.setMaxHealth(18);
        this.setHealth((int) (Math.random() * 7) + 12);
        this.setEatable(true);
    }

    @Override
    public String toString() {
        return "Chicken{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", resources=" + resources +
                ", eatable=" + eatable +
                ", weight=" + weight +
                ", speed=" + speed +
                '}';
    }
}
