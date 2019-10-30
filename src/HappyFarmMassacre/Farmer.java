package HappyFarmMassacre;

public class Farmer {
    protected int resFarmer; // ресурсы фермера

    public Farmer(int resFarmer) {
        this.resFarmer = resFarmer;
    }
    public void spendRes() {
        this.setResFarmer(this.getResFarmer() - (this.getResFarmer()/3));
    }
    public void collectRes(Farm farmName){
        boolean canCollect = false;
        int resCount = this.resFarmer;
        for (int i = 0; i < farmName.homeAnimals.length; i++) {
            if (farmName.homeAnimals[i].getResources() != 0)
                canCollect = true;
        }
        for (int i = 0; i < farmName.homeAnimals.length; i++) {
            if (canCollect && farmName.homeAnimals[i] != null && farmName.homeAnimals[i].getResources() != 0){
                setResFarmer(this.getResFarmer() + farmName.homeAnimals[i].getResources());
                farmName.homeAnimals[i].setResources(0);

            }
            else if (!canCollect && farmName.homeAnimals[i] != null && farmName.homeAnimals[i].isEatable()){
                setResFarmer(this.getResFarmer() + farmName.homeAnimals[i].getWeight());
                farmName.homeAnimals[i] = null;
            }
        }
        if (canCollect){
            System.out.println("Фермер собрал " + (this.getResFarmer() - resCount) + " едениц ресурсов");
        }
        else {
            System.out.println("На ферме не осталось ресурсов и фермер скушал всех съедобных животных пополнив запас ресурсов на "
                    + (this.getResFarmer() - resCount) + " едениц");
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
