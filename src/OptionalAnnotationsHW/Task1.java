package OptionalAnnotationsHW;

public class Task1 {
    public static void main(String[] args) throws CheckedException {
        Message message = new Message("Title", "Some Text bla bla bla");
        Student student = new Student("Ivan", 23, Gender.MALE, message);
        try {
            Student.excludeField(student);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
