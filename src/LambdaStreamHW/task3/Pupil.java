package LambdaStreamHW.task3;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Pupil {
    enum Gender {
        MALE, FEMALE
    }
    private int number; // уникальное значение для каждого ученика
    private String name;
    private Gender gender;
    private LocalDate birth;

    public Pupil(int number, String name, Gender gender, LocalDate birth) {
        this.number = number;
        this.name = name;
        this.gender = gender;
        this.birth = birth;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public int getAge() {
        return (int) ChronoUnit.DAYS.between(getBirth(), LocalDate.now());
    }

    public int getBirthYear() {
        return birth.getYear();
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }





    @Override
    public String toString() {
        return "Pupil{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birth=" + birth +
                '}';
    }

    // TODO: добавить все необходимые методы

}
