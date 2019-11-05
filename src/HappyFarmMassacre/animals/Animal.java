package HappyFarmMassacre.animals;

public class Animal {
    private int weight;
    private int speed;
    private String name;

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
        if (weight > 0) {
            this.weight = weight;
        }
    }

    public void setSpeed(int speed) {
        if (speed > 0) {
            this.speed = speed;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !"".equals(name)) {
            this.name = name;
        }
    }
}
