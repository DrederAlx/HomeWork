package HappyFarmMassacre.animals;

public class Cat extends HomeAnimal {
    public Cat(int weight, int speed, String name, int health, int resources, boolean eatable, int maxHealth) {
        super(weight, speed, name, health, resources, eatable, maxHealth);
    }
    public Cat() {
        String[] nameArr = {"Барсик", "Сырок", "Пупок", "Язь", "Пельмешек"};
        int nameId;
        nameId = (int) (Math.random() * nameArr.length);
        this.setName(nameArr[nameId]);
        this.setResources(0);
        this.setWeight((int) (Math.random() * 6) + 4);
        this.setSpeed((int) (Math.random() * 6) + 10);
        this.setMaxHealth(10);
        this.setHealth((int) (Math.random() * 6) + 5);
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
