package HappyFarmMassacre.animals;

public class Rabbit extends HomeAnimal {
    public Rabbit(int weight, int speed, String name, int health, int resources, boolean eatable, int maxHealth) {
        super(weight, speed, name, health, resources, eatable, maxHealth);
    }

    public Rabbit() {
        String[] nameArr = {"Пончик", "Суслик", "Уголек", "Иннокентий", "Прыг"};
        int nameId;
        nameId = (int) (Math.random() * nameArr.length);
        this.setName(nameArr[nameId]);
        this.setResources(0);
        this.setWeight((int) (Math.random() * 4) + 2);
        this.setSpeed((int) (Math.random() * 8) + 15);
        this.setMaxHealth(10);
        this.setHealth((int) (Math.random() * 6) + 5);
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

