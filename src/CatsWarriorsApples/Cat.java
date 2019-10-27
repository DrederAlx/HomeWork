package CatsWarriorsApples;

public class Cat {
    private String name;
    private int weight;
    private int age;
    private String color;
    private String ownerAddress;

    public Cat(String name) {
        this.name = name;
    }

    public Cat(String name, int weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Cat(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Cat(int weight, String color, String ownerAddress) {
        this.weight = weight;
        this.color = color;
        this.ownerAddress = ownerAddress;
    }

    public void setName(String name) {
        if (name != null && !"".equals(name)) {
            this.name = name;
        }
    }

    public void setWeight(int weight) {
        if (weight > 0){
        this.weight = weight;
        }
    }

    public void setAge(int age) {
        if (age > 0){
            this.age = age;
        }
    }

    public void setColor(String color) {
        if (color != null && !"".equals(color)) {
            this.color = color;
        }
    }

    public void setOwnerAddress(String ownerAddress) {
        if (ownerAddress != null && !"".equals(ownerAddress)) {
            this.ownerAddress = ownerAddress;
        }
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    private String nameCheck(){
        String nameCheck;
        if (name == null) {
            nameCheck = "Неизвестна";
        }
        else {
            nameCheck = name;
        }
        return nameCheck;
    }
    private String ageCheck(){
        String ageCheck;
        if (age == 0){
            ageCheck = "Неизвестен";
        }
        else {
            ageCheck = "" + age;
        }
        return ageCheck;
    }
    private  String weightCheck(){
        String weightCheck;
        if (weight == 0){
            weightCheck = "Неизвестен";
        }
        else {
            weightCheck = "" + weight;
        }
        return weightCheck;
    }

    private String colorCheck(){
        String colorCheck;
        if (color == null) {
            colorCheck = "Неизвестен";
        }
        else {
            colorCheck = color;
        }
        return colorCheck;
    }
    private String ownerAddressCheck(){
        String ownerAddressCheck;
        if (ownerAddress == null) {
            ownerAddressCheck = "Неизвестен";
        }
        else {
            ownerAddressCheck = ownerAddress;
        }
        return ownerAddressCheck;
    }


    public String catInfo() {
        String info = "Информация о коте:\n" + "Кличка: " + nameCheck() + '\n' + "Вес: " + weightCheck() + '\n'
                    + "Возраст: " + ageCheck() + '\n' + "Окрас: " + colorCheck() + '\n' + "Адрес владельца: " + ownerAddressCheck() + '\n';
        return info;
    }
}
