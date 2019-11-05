package HappyFarmMassacre.animals;

public class HomeAnimal extends Animal {
    private int health;
    private int resources;
    private boolean eatable;
    private int maxHealth;
    private int maxResources;

    protected final static String[] rabbitNames = {"Пончик", "Суслик", "Уголек", "Иннокентий", "Прыг"};
    protected final static String[] cowNames = {"Мадонна", "Ксения", "Березка", "Россия", "Жизель"};
    protected final static String[] catNames = {"Барсик", "Сырок", "Пупок", "Язь", "Пельмешек"};
    protected final static String[] chickenNames = {"Свистушка", "Несушка", "Ряба", "Айгуль", "Пеструшка"};

    public HomeAnimal(int weight, int speed, String name, int health, int resources, boolean eatable, int maxHealth, int maxResources) {
        super(weight, speed, name);
        setName(name);
        setHealth(health);
        setResources(resources);
        setEatable(eatable);
        setMaxHealth(maxHealth);
        setMaxResources(maxResources);
    }

    public HomeAnimal() {
    }

    public void setResources(int resources) {
        if (resources < 0) {
            this.resources = 0;
        }
        else if (resources > getMaxResources() && getMaxResources() != 0) {
           this.resources = getMaxResources();
        }
        else {
            this.resources = resources;
        }
    }

    public void setHealth(int health) {
        if (health < 0) {
            this.health = 0;
        }
        else if (health > getMaxHealth() && getMaxHealth() != 0){
            this.health = getMaxHealth();
        }
        else {
            this.health = health;
        }
    }

    public void setEatable(boolean eatable) {
        this.eatable = eatable;
    }

    public boolean isEatable() {
        return eatable;
    }

    public int getResources() {
        return resources;
    }

    public void setMaxHealth(int maxHealth) {
        if (maxHealth > 0) {
            this.maxHealth = maxHealth;
        }
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getMaxResources() {
        return maxResources;
    }

    public void setMaxResources(int maxResources) {
        if (maxResources >= 0) {
            this.maxResources = maxResources;
        }
    }
}
