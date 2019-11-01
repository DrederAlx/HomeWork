package HappyFarmMassacre.animals;

public class HomeAnimal extends Animal {
    protected String name;
    protected int health;
    protected int resources;
    protected boolean eatable;
    protected int maxHealth;

    protected static String[] rabbitNames = {"Пончик", "Суслик", "Уголек", "Иннокентий", "Прыг"};
    protected static String[] cowNames = {"Мадонна", "Ксения", "Березка", "Россия", "Жизель"};
    protected static String[] catNames = {"Барсик", "Сырок", "Пупок", "Язь", "Пельмешек"};
    protected static String[] chickenNames = {"Свистушка", "Несушка", "Ряба", "Айгуль", "Пеструшка"};

    public HomeAnimal(int weight, int speed, String name, int health, int resources, boolean eatable, int maxHealth) {
        super(weight, speed);
        setName(name);
        setHealth(health);
        setResources(resources);
        setEatable(eatable);
        setMaxHealth(maxHealth);
    }
    public HomeAnimal() {
    }

    public String getName() {
        return name;
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

    public boolean isEatable() {
        return eatable;
    }

    public int getResources() {
        return resources;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

}
