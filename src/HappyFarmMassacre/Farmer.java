package HappyFarmMassacre;

public class Farmer {
    protected int resFarmer; // ресурсы фермера
    protected Farm farm;

    public Farmer(int resFarmer) {
        setResFarmer(resFarmer);
    }
    public void spendRes() {

        this.setResFarmer(this.getResFarmer() - (this.getResFarmer()/3));
    }

    public void collectRes() {
        if (farm.canCollectCheck()) {
            System.out.println("Фермер собрал " + farm.collect() + " едениц ресурсов");
        }
        else {
            if (farm.canEatCheck()) {
                farm.eat();
            }
            else {
                System.out.println("На ферме не осталось съедобных животных");
            }
        }
    }




    public void setResFarmer(int resFarmer) {
        this.resFarmer = resFarmer;
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
