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
        setName("Волк");
        setWeight((int) (Math.random() * 6) + 17);
        setSpeed((int) (Math.random() * 10) + 8);
        setAttackScore(20);
        setFarmTicket(3);
    }
}
