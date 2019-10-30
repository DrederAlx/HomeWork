package HappyFarmMassacre.animals;

public class Chicken extends HomeAnimal {
    public Chicken(int weight, int speed, String name, int health, int resources, boolean eatable, int maxHealth) {
        super(weight, speed, name, health, resources, eatable, maxHealth);
    }

    public Chicken() {
        int nameId;
        nameId = (int) (Math.random() * chickenNames.length);
        this.setName(chickenNames[nameId]);
        this.setResources((int) (Math.random() * 8) + 8);
        this.setWeight((int) (Math.random() * 4) + 2);
        this.setSpeed((int) (Math.random() * 5) + 8);
        this.setMaxHealth(10);
        this.setHealth((int) (Math.random() * 6) + 5);
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
