package com.javalessons.kingandco.units;

public class Warrior extends BattleUnit {
    public Warrior(String name, int speed, int health, int attackScore) {
        super(name, speed, health, attackScore);
    }
    @Override
    public void attack(Unit enemy) {
        System.out.println("Воин атаковал " + enemy.getName());
    }
    @Override
    public void rest() {
        System.out.println("Воин отдыхает");

    }
}
