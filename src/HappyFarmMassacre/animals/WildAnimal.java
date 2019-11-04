package HappyFarmMassacre.animals;

public class WildAnimal extends Animal {
    protected int attackScore;
    protected int farmTicket;

    public WildAnimal(int weight, int speed, int attackScore, int farmTicket, String name) {
        super(weight, speed, name);
        setAttackScore(attackScore);
        setFarmTicket(farmTicket);
        setName(name);
    }

    public WildAnimal(){

    }

    public int getFarmTicket() {
        return farmTicket;
    }

    public void setFarmTicket(int farmTicket) {
        this.farmTicket = farmTicket;
    }

    public int getAttackScore() {
        return attackScore;
    }

    public void setAttackScore(int attackScore) {
        this.attackScore = attackScore;
    }
}
