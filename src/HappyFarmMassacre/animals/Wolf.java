package HappyFarmMassacre.animals;

public class Wolf extends WildAnimal {
    public Wolf(int weight, int speed, int attackScore, int farmTicket, String name) {
        super(weight, speed, attackScore, farmTicket, name);
        setWeight(weight);
        setSpeed(speed);
        setAttackScore(attackScore);
        setFarmTicket(farmTicket);
        setName(name);
    }
    public Wolf () {
        this.setName("Волк");
        this.setWeight((int) (Math.random() * 6) + 17);
        this.setSpeed((int) (Math.random() * 10) + 8);
        this.setAttackScore(20);
        setFarmTicket(3);
    }

    @Override
    public String toString() {
        return "Wolf{" +
                "attackScore=" + attackScore +
                ", farmTicket=" + farmTicket +
                ", weight=" + weight +
                ", speed=" + speed +
                '}';
    }
}
