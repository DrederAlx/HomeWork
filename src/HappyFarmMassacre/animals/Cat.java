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
        this.setName(catNames[nameId]);
        this.setResources(0);
        this.setMaxResources(0);
        this.setWeight((int) (Math.random() * 6) + 4);
        this.setSpeed((int) (Math.random() * 6) + 10);
        this.setHealth((int) (Math.random() * 6) + 5);
        this.setMaxHealth(getHealth());
        this.setEatable(false);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", resources=" + resources +
                ", eatable=" + eatable +
                ", weight=" + weight +
                ", speed=" + speed +
                '}';
    }
}
