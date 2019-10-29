package HappyFarmMassacre.animals;

public class Wild extends Animal {
    protected int attackScore;

    public Wild(int weight, int speed, int attackScore) {
        super(weight, speed);
        this.attackScore = attackScore;
    }
}
