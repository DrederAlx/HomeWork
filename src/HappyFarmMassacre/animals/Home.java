package HappyFarmMassacre.animals;

public class Home extends Animal {
    protected String name;
    protected int health;
    protected int resources;
    protected boolean eatable;

    public Home(int weight, int speed, String name, int health, int resources, boolean eatable) {
        super(weight, speed);
        this.name = name;
        this.health = health;
        this.resources = resources;
        this.eatable = eatable;
    }

    @Override
    public String toString() {
        return "Home{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", resources=" + resources +
                ", eatable=" + eatable +
                ", weight=" + weight +
                ", speed=" + speed +
                '}';
    }
}
