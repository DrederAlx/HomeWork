package com.javalessons.kingandco.units;

public class Knight extends BattleUnit {
    public Knight(String name, int speed, int health, int attackScore) {
        super(name, speed, health, attackScore);
    }
    @Override
    public void attack(Unit enemy) {
        if (enemy.getHealth() > 0) {
            enemy.setHealth(enemy.getHealth() - (this.getAttackScore() + (int) (this.getHealth() * 0.1)));
            System.out.println("Рыцарь атаковал " + enemy.getName() + " на " + (this.getAttackScore()
                    + (int) (this.getHealth() * 0.1)) + " очков");
        }
        else {
            System.out.println("Враг мертв, его нельзя атаковать");
        }
    }

    @Override
    public void rest() {
        System.out.println("Рыцарь отдыхает");
    }
}
