package com.javalessons.kingandco.units;

public interface RestAble {
    void rest();

    default void escapeBattleField() { // метод с реализацией (это то, что в фигурных скобках)
        System.out.println("Юнит сбежал с поля боя "); // когда класс расширяет несколько интерфейсов с одинаковой сигнатурой то возникает конфликт
    }
}