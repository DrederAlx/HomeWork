package HappyFarmMassacre.animals;

public class Animal {
    protected int weight;
    protected int speed;
    protected String name;

    public Animal(int weight, int speed, String name) {
        setWeight(weight);
        setSpeed(speed);
        setName(name);
    }
    public Animal() {
    }

    public int getSpeed() {
        return speed;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
