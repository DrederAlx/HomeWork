package HappyFarmMassacre.animals;

public class Cow extends HomeAnimal {
    public Cow(int weight, int speed, String name, int health, int resources, boolean eatable, int maxHealth) {
        super(weight, speed, name, health, resources, eatable, maxHealth);
    }

    public Cow() {
        int nameId;
        nameId = (int) (Math.random() * cowNames.length);
        this.setName(cowNames[nameId]);
        this.setResources((int) (Math.random() * 9) + 12);
        this.setWeight((int) (Math.random() * 11) + 20);
        this.setSpeed((int) (Math.random() * 6) + 5);
        this.setMaxHealth(25);
        this.setHealth((int) (Math.random() * 6) + 20);
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
