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
        this.setName(chickenNames[nameId]);
        this.setResources((int) (Math.random() * 8) + 8);
        this.setMaxResources(getResources());
        this.setWeight((int) (Math.random() * 4) + 2);
        this.setSpeed((int) (Math.random() * 5) + 8);
        this.setHealth((int) (Math.random() * 7) + 12);
        this.setMaxHealth(getHealth());
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
