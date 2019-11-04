package HappyFarmMassacre.animals;

public class HomeAnimal extends Animal {
    protected int health;
    protected int resources;
    protected boolean eatable;
    protected int maxHealth;

    protected final static String[] rabbitNames = {"Пончик", "Суслик", "Уголек", "Иннокентий", "Прыг"};
    protected final static String[] cowNames = {"Мадонна", "Ксения", "Березка", "Россия", "Жизель"};
    protected final static String[] catNames = {"Барсик", "Сырок", "Пупок", "Язь", "Пельмешек"};
    protected final static String[] chickenNames = {"Свистушка", "Несушка", "Ряба", "Айгуль", "Пеструшка"};

    public HomeAnimal(int weight, int speed, String name, int health, int resources, boolean eatable, int maxHealth) {
        super(weight, speed, name);
        setName(name);
        setHealth(health);
        setResources(resources);
        setEatable(eatable);
        setMaxHealth(maxHealth);
    }
    public HomeAnimal() {
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

    public boolean isEatable() {
        return eatable;
    }

    public int getResources() {
        return resources;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
}
