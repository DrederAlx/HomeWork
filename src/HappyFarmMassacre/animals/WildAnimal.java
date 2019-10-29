package HappyFarmMassacre.animals;

public class WildAnimal extends Animal {
    protected int attackScore;

    public WildAnimal(int weight, int speed, int attackScore) {
        super(weight, speed);
        this.attackScore = attackScore;
    }
}
