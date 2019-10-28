package HappyFarmMassacre;

public class Farmer {
    protected int resFarmer; // ресурсы фермера

    public Farmer(int resFarmer) {
        this.resFarmer = resFarmer;
    }
    public void spendRes() {
        this.setResFarmer(this.getResFarmer() - (this.getResFarmer() - 10));
    }
    public void collectRes(){
        this.setResFarmer(this.getResFarmer() + 10);
    }

    public void setResFarmer(int resFarmer) {
        this.resFarmer = resFarmer;
    }

    public int getResFarmer() {
        return resFarmer;
    }
}
