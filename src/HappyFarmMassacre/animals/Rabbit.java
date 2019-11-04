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
        this.setName(rabbitNames[nameId]);
        this.setResources(0);
        this.setMaxResources(getResources());
        this.setWeight((int) (Math.random() * 4) + 2);
        this.setSpeed((int) (Math.random() * 6) + 15);
        this.setHealth((int) (Math.random() * 8) + 8);
        this.setMaxHealth(getHealth());
        this.setEatable(true);
    }

    @Override
    public String toString() {
        return "Rabbit{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", resources=" + resources +
                ", eatable=" + eatable +
                ", weight=" + weight +
                ", speed=" + speed +
                '}';
    }
}

