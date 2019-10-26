package com.javalessons.kingandco.units;

public interface AttackAble { // на основе интерфейса нельзя создавать новые объекты (все методы без реализации в
    // интерфейсах по умолчанию public, но начиная с 9 версии доступен модификатор private)

    void attack(Unit enemy);

     // default void  escapeBattleField(){ // метод с реализацией (это то, что в фигурных скобках)
     // System.out.println("Юнит сбежал с поля боя ");
}