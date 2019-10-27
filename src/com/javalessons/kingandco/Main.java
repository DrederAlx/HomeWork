package com.javalessons.kingandco;

import com.javalessons.kingandco.units.BattleUnit;
import com.javalessons.kingandco.units.Doctor;
import com.javalessons.kingandco.units.Knight;
import com.javalessons.kingandco.units.Warrior;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Укажите тип персонажа");
        String userChoice;
        // warrior knight doctor
        BattleUnit battleUnit = null;
        while (battleUnit == null) {
            userChoice = in.nextLine();
            if ("warrior".equals(userChoice)) {
                battleUnit = new Warrior("Воин", 3, 20, 15);
            } else if ("knight".equals(userChoice)) {
                battleUnit = new Knight("Рыцарь", 4, 22, 18);
            } else if ("doctor".equals(userChoice)) {
                battleUnit = new Doctor("Доктор", 2, 40, 5);
            } else {
                System.out.println("Вы неверно указали тип персонажа ");
            }
        }

        battleUnit.run();
        System.out.println("Ваш выбор " + battleUnit);
        BattleUnit enemyChoice = new Knight("Рыцарь противника", 4, 23, 17);
        BattleUnit testUnit = new Warrior("Тестовый Воин", 3,20,15);
        System.out.println(testUnit);
        battleUnit.attack(testUnit);
        System.out.println(testUnit);
        System.out.println(battleUnit);

        // ^ это полиморфизм наследования

        // наследование - это extends - расширение функционала родительского класса дочерним
        // инкапсуляция - скрытие деталий реализаций, модификаторами доступа например private
        // полиморфизим - это когда через общий тип данных создаются разные объекты и перегруз метода (когда методы имеют одинаковые названия и тип возвращаемых данных)
        // абстракция - это интерфейсы и абстрактные классы

        /** ДЗ Описать проверки в классах скорость не может быть 0 и тд, реализация атаки и отдыха **/
    }
}
