package com.javalessons.kingandco.units;

public class King implements RestAble{

    private String name;
    private int gold;

    // модификатор с private изменять нельзя!!!
    // другие конструкторы создавать нельзя!!!

    private King(String name, int gold) {
        this.name = name;
        this.gold = gold;
    }

    public static King altConstructor (String name, int gold){
        King king = new King(name, gold);
        return king;
    }

    @Override
    public String toString() {
        return "King{" +
                "name='" + name + '\'' +
                ", gold=" + gold +
                '}';
    }

    @Override
    public void rest() {
        System.out.println("Король отдыхает");
    }
}
