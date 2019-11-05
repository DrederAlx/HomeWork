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
        setName("Медведь");
        setWeight((int) (Math.random() * 11) + 20);
        setSpeed((int) (Math.random() * 6) + 5);
        setAttackScore(25);
        setFarmTicket(3);
    }
}
