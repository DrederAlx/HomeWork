package HappyFarmMassacre;

public class Farmer {
    protected int resFarmer; // ресурсы фермера

    public Farmer(int resFarmer) {
        setResFarmer(resFarmer);
    }
    public void spendRes() {
        this.setResFarmer(this.getResFarmer() - (this.getResFarmer()/3));
    }
    public void collectRes(Farm farmName){
        boolean canCollect = false;
        int resCount = this.resFarmer;
        for (int i = 0; i < farmName.homeAnimals.length; i++) {
            if (farmName.homeAnimals[i] != null && farmName.homeAnimals[i].getResources() != 0)
                canCollect = true;
        }
        for (int i = 0; i < farmName.homeAnimals.length; i++) {
            if (canCollect && farmName.homeAnimals[i] != null && farmName.homeAnimals[i].getResources() != 0){
                setResFarmer(this.getResFarmer() + farmName.homeAnimals[i].getResources());
                farmName.homeAnimals[i].setResources(0);

            }
            else if (!canCollect && farmName.homeAnimals[i] != null && farmName.homeAnimals[i].isEatable()){
                int pos = 0;
                int maxWeight;
                if (farmName.homeAnimals[pos] != null) {
                    maxWeight = farmName.homeAnimals[pos].getWeight();
                }
                else {
                    maxWeight = 0;
                }
                for (int j = 1; j <  farmName.homeAnimals.length; j++) {
                    if (farmName.homeAnimals[j] != null && farmName.homeAnimals[j].getWeight() > maxWeight){
                        pos = j;
                        maxWeight = farmName.homeAnimals[j].getWeight();
                    }
                }
                setResFarmer(this.getResFarmer() + farmName.homeAnimals[pos].getWeight());
                System.out.println("На ферме не осталось ресурсов и фермер скушал животное по имени " + farmName.homeAnimals[pos].getName() + " пополнив запас ресурсов на "
                        + (this.getResFarmer() - resCount) + " едениц");
                farmName.homeAnimals[pos] = null;
                break;
            }
        }
        if (canCollect){
            System.out.println("Фермер собрал " + (this.getResFarmer() - resCount) + " едениц ресурсов");
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
