package com.javalessons.kingandco.units;

public class Doctor extends BattleUnit {
    public Doctor(String name, int speed, int health, int attackScore) {
        super(name, speed, health, attackScore);
    }
    @Override
    public void attack(Unit friend) {
        if (friend.getHealth() > 0) {
            friend.setHealth(friend.health + (this.getAttackScore() + this.getSpeed()));
            System.out.println("Доктор вылечил " + friend.getName() + " на " + (this.getAttackScore() + this.getSpeed()) + " очков");
        }
        else {
            System.out.println("Пациент мертв, лечение тут не поможет. Нужен некромант");
        }
    }

    @Override
    public void rest() {
        System.out.println("Доктор отдыхает");
    }
}
