package com.javalessons.kingandco.units;

public class King extends Unit {
    public King(String name, int speed, int health) {
        super(name, speed);
        this.health = health;

    }
    @Override
    public void rest() {
        System.out.println("Король отдыхает");
    }
}