package com.javalessons.kingandco.units;

abstract public class Unit implements RestAble {
    protected String name;
    protected int health; // protected - можем обратиться к свойству внутри данного класса и внутри его дочерних классов
    protected int speed; // если никакого свойство не указано то это package private (доступны внутри пакета)

    public Unit(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }
    public boolean isAlive(){
        return health > 0;
    }
    public void run(){
        System.out.println("Юнит перемещается со скоростью " + speed);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }
}
