package com.javalessons.kingandco.units;

abstract public class BattleUnit extends Unit implements AttackAble{  // extends - наследование. Unit здесь это родительский класс, BattleUnit дочерний
    // в интерфейсах перечисляем методы без реализации, которые обязательно должны быть реализованы в классах, расширяющих данный интерфейс
    protected int attackScore;

    public BattleUnit(String name, int speed, int health, int attackScore) { // только один класс может быть наследован
        super(name, speed); // вызов конструктора родителя
        this.health = health;
        this.attackScore = attackScore; /** дома добавить все проверки **/
    }

    public void setAttackScore(int attackScore) {
        this.attackScore = attackScore;
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
