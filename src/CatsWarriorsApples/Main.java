package CatsWarriorsApples;

public class Main {
    public static void main(String[] args) {
        Cat sirok = new Cat ("Сырок", 8, 17);
        Cat pupok = new Cat ("Пупок", 6);
        Cat yaaaz = new Cat("Йазь");
        Cat kuzma = new Cat (9, "Серый");
        Cat gosha = new Cat (6, "Рыжий", "г. Нигда");
        System.out.println(sirok.catInfo());
        System.out.println(pupok.catInfo());
        System.out.println(yaaaz.catInfo());
        System.out.println(kuzma.catInfo());
        System.out.println(gosha.catInfo());
    }
}// test
