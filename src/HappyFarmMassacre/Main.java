package HappyFarmMassacre;

public class Main {
    public static void main(String[] args) {
        Farm farm1 = new Farm();
        Farmer farmer1 = new Farmer(50);
        farm1.farmer = farmer1;
        farmer1.farm = farm1;
        farm1.addHomeAnimals();
        farm1.addWildAnimals();

        while (true) {
            if (farmer1.getResFarmer() != 0 && farm1.ticketCheck()) {
                farm1.dayPass();
            }
            else if (farmer1.getResFarmer() != 0 && !farm1.ticketCheck()){
                System.out.println("Все дикие звери сидят в лесу, нервно поглядывая на ферму. Фермер победил.");
                break;
            }
            else if (farmer1.getResFarmer() == 0){
                System.out.println("У фермера закончились ресурсы и на ферме не осталось съедобных животных. Фермер проиграл.");
                break;
            }
        }
    }
}
