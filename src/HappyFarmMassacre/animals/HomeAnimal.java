package HappyFarmMassacre.animals;

public class HomeAnimal extends Animal {
    protected String name;
    protected int health;
    protected int resources;
    protected boolean eatable;
    protected int maxHealth;

    public HomeAnimal(int weight, int speed, String name, int health, int resources, boolean eatable, int maxHealth) {
        super(weight, speed);
        this.name = name;
        this.health = health;
        this.resources = resources;
        this.eatable = eatable;
        this.maxHealth = maxHealth;
    }
    public HomeAnimal() {
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setResources(int resources) {
        this.resources = resources;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setEatable(boolean eatable) {
        this.eatable = eatable;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }
}
