package HappyFarmMassacre.animals;

public class Fox extends WildAnimal {
    public Fox(int weight, int speed, int attackScore, int farmTicket, String name) {
        super(weight, speed, attackScore, farmTicket, name);
        setWeight(weight);
        setSpeed(speed);
        setAttackScore(attackScore);
        setFarmTicket(farmTicket);
        setName(name);
    }
    public Fox () {
        this.setName("Лис");
        this.setWeight((int) (Math.random() * 6) + 15);
        this.setSpeed((int) (Math.random() * 6) + 15);
        this.setAttackScore(15);
        setFarmTicket(3);
    }

    @Override
    public String toString() {
        return "Fox{" +
                "attackScore=" + attackScore +
                ", farmTicket=" + farmTicket +
                ", weight=" + weight +
                ", speed=" + speed +
                '}';
    }
}
