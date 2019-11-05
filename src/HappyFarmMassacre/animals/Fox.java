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
        setName("Лис");
        setWeight((int) (Math.random() * 6) + 15);
        setSpeed((int) (Math.random() * 6) + 15);
        setAttackScore(15);
        setFarmTicket(3);
    }
}
