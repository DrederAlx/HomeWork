package OptionalAnnotationsHW;

import java.lang.reflect.Field;

class Student{

    private String name;
    @Exclude
    private int age;
    private Gender gender;
    @Exclude
    private Message message;

    public Student(String name, int age, Gender gender, Message message) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    static void excludeField(Object object) throws IllegalAccessException {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field: fields) {
            if (field.isAnnotationPresent(Exclude.class)) {
                if (field.getClass().isPrimitive() /* && !field.getClass().isInstance(String.class)*/){
                    System.out.println("true");
                }
                System.out.println(field.get(object));
            }
        }
    }
}
