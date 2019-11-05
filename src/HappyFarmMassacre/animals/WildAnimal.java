package HappyFarmMassacre.animals;

public class WildAnimal extends Animal {
    private int attackScore;
    private int farmTicket;

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
        if (farmTicket >= 0) {
            this.farmTicket = farmTicket;
        }
    }

    public int getAttackScore() {
        return attackScore;
    }

    public void setAttackScore(int attackScore) {
        if (attackScore > 0) {
            this.attackScore = attackScore;
        }
    }
}
