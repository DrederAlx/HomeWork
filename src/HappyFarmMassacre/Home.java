package HappyFarmMassacre;

public class Home extends Animals {
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
}
