package HappyFarmMassacre.animals;

public class Bear extends WildAnimal {
    public Bear(int weight, int speed, int attackScore, int farmTicket, String name) {
        super(weight, speed, attackScore, farmTicket, name);
        setWeight(weight);
        setSpeed(speed);
        setAttackScore(attackScore);
        setFarmTicket(farmTicket);
        setName(name);
    }
    public Bear () {
        this.setName("Медведь");
        this.setWeight((int) (Math.random() * 11) + 20);
        this.setSpeed((int) (Math.random() * 6) + 5);
        this.setAttackScore(25);
        setFarmTicket(3);
    }

    @Override
    public String toString() {
        return "Bear{" +
                "attackScore=" + attackScore +
                ", farmTicket=" + farmTicket +
                ", weight=" + weight +
                ", speed=" + speed +
                '}';
    }
}
