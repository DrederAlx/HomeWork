package HappyFarmMassacre.animals;

public class Animal {
    protected int weight;
    protected int speed;

    public Animal(int weight, int speed) {
        this.weight = weight;
        this.speed = speed;
    }
    public Animal() {
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
}
