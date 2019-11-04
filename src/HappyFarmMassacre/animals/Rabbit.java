package HappyFarmMassacre.animals;

public class Rabbit extends HomeAnimal {
    public Rabbit(int weight, int speed, String name, int health, int resources, boolean eatable, int maxHealth) {
        super(weight, speed, name, health, resources, eatable, maxHealth);
        setWeight(weight);
        setSpeed(speed);
        setName(name);
        setHealth(health);
        setResources(resources);
        setEatable(eatable);
        setMaxHealth(maxHealth);
    }

    public Rabbit() {
        int nameId;
        nameId = (int) (Math.random() * rabbitNames.length);
        this.setName(rabbitNames[nameId]);
        this.setResources(0);
        this.setWeight((int) (Math.random() * 4) + 2);
        this.setSpeed((int) (Math.random() * 6) + 15);
        this.setMaxHealth(15);
        this.setHealth((int) (Math.random() * 8) + 8);
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

