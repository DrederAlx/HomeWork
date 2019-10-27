package com.javalessons.kingandco.units;

public class Warrior extends BattleUnit {
    public Warrior(String name, int speed, int health, int attackScore) {
        super(name, speed, health, attackScore);
    }
    @Override
    public void attack(Unit enemy) {
        if (enemy.getHealth() > 0) {
            enemy.setHealth(enemy.getHealth() - this.getAttackScore());
            this.setHealth(this.getHealth() - this.getAttackScore() / 3);
            System.out.println("Воин атаковал " + enemy.getName() + " на " + this.getAttackScore() + " очков\n" +
                    "но в ярости нанес себе " + this.getAttackScore() / 3 + " урона.");
        }
        else {
            System.out.println("Враг мертв, его нельзя атаковать");
        }
    }
    @Override
    public void rest() {
        System.out.println("Воин отдыхает");

    }
}
