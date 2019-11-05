package com.javalessons.kingandco.units;

abstract public class BattleUnit extends Unit implements AttackAble{  // extends - наследование. Unit здесь это родительский класс, BattleUnit дочерний
    // в интерфейсах перечисляем методы без реализации, которые обязательно должны быть реализованы в классах, расширяющих данный интерфейс
    protected int attackScore;

    public BattleUnit(String name, int speed, int health, int attackScore) { // только один класс может быть наследован
        super(name, speed); // вызов конструктора родителя
        setHealth(health);
        setAttackScore(attackScore);
    }

    public static BattleUnit randomise (String type) {
        BattleUnit battleUnit = null;
            if ("warrior".equals(type)) {
                battleUnit = new Warrior(type + (int) (Math.random() * 100), (int) (Math.random() * 3) + 3,
                        (int) (Math.random() * 6) + 15, (int) (Math.random() * 6) + 10);
            }
            else if ("knight".equals(type)) {
                battleUnit = new Knight(type + (int) (Math.random() * 100), (int) (Math.random() * 4) + 4,
                        (int) (Math.random() * 8) + 18, (int) (Math.random() * 6) + 15);
            }
            else if ("doctor".equals(type)) {
                battleUnit = new Doctor(type + (int) (Math.random() * 100), (int) (Math.random() * 5) + 1,
                        (int) (Math.random() * 11) + 35, (int) (Math.random() * 5) + 3);
            }
            else {
                System.out.println("Вы неверно указали тип персонажа ");
            }
        return battleUnit;
    }

    public void setAttackScore(int attackScore) {
        if (attackScore > 0) {
            this.attackScore = attackScore;
        }
    }

    public int getAttackScore() {
        return attackScore;
    }
    @Override
    public String toString() {
        return "BattleUnit{" +
                "attackScore=" + attackScore +
                ", name='" + name + '\'' +
                ", health=" + health +
                ", speed=" + speed +
                '}';
    }

    @Override
    public void escapeBattleField() {
        System.out.println("Юнит " + this.name + " сбежал с поля боя");
    }
}
