package HappyFarmMassacre;

public class Farmer {
    protected int resFarmer;
    protected Farm farm;

    public Farmer(int resFarmer) {

        setResFarmer(resFarmer);
    }

    public void spendRes() {
        int amount = (int) (Math.random() * 11) + 20;
        if (getResFarmer() < amount){
            amount = getResFarmer();
        }
        setResFarmer(getResFarmer() - amount);
        System.out.println("Фермер израсходовал " + amount + " едениц ресурсов на свои фермерские нужды.");
    }

    public void collectRes() {
        if (farm.canCollectCheck()) {
            System.out.println("Фермер собрал " + farm.collect() + " едениц ресурсов.");
        }
        else {
            if (farm.canEatCheck()) {
                farm.eat();
            }
            else {
                System.out.println("На ферме не осталось съедобных животных.");
            }
        }
    }

    public boolean kickOut() {
        return Math.random() < 0.3;
    }

    public void feed() {
        if (farm.anybodyOnFarm()){
            farm.restore();
            System.out.println("Фермер накормил животных, восстановив им запас ресурсов и увеличив здоровье.");
        }
        else {
            System.out.println("Кормить некого, все животные сами стали кормом.");
        }
    }

    public void setResFarmer(int resFarmer) {
        if (resFarmer < 0) {
            this.resFarmer = 0;
        }
        else {
            this.resFarmer = resFarmer;
        }
    }

    public int getResFarmer() {
        return resFarmer;
    }

    @Override
    public String toString() {
        return "Farmer{" +
                "Количество ресурсов = " + resFarmer +
                '}';
    }
}
