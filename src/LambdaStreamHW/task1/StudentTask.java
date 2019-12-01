package LambdaStreamHW.task1;
import java.util.Arrays;
import java.util.List;

public class StudentTask {
    public static void main(String[] args) {

        //TODO: найти студентов с уникальными предметами. Задачу решать с использованием stream API

        Student student1 = new Student("Ivan", Arrays.asList("Math", "Physics", "Biology", "Philosophy", "Economics"));
        Student student2 = new Student("Bob", Arrays.asList("Economics", "Physics", "Math"));
        Student student3 = new Student("Mike", Arrays.asList("Math", "Sociology","Physics", "Biology"));
        Student student4 = new Student("John", Arrays.asList("Math", "Physics", "Biology"));
        Student student5 = new Student("Jesus", Arrays.asList("Philosophy", "Economics", "Sociology"));
        Student student6 = new Student("George", Arrays.asList("Math", "Physics", "Biology"));
        Student student7 = new Student("Rob", Arrays.asList("Math", "Physics", "Biology"));
    }
}

class Student {
    // можно добавить дополнительные поля
    private String login;
    private List<String> subjects;

    public Student(String login, List<String> subjects) {
        this.login = login;
        this.subjects = subjects;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }
}
