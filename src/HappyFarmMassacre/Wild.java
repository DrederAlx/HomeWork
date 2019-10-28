package HappyFarmMassacre;

public class Wild extends Animals {
    protected int attackScore;

    public Wild(int weight, int speed, int attackScore) {
        super(weight, speed);
        this.attackScore = attackScore;
    }
}
