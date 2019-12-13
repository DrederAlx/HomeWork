package LambdaStreamHW.task1;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentTask {
    public static void main(String[] args) {

        Student student1 = new Student("Ivan", Arrays.asList("Math", "Physics", "Biology", "Philosophy"));
        Student student2 = new Student("Bob", Arrays.asList("Economics", "Physics", "Math"));
        Student student3 = new Student("Mike", Arrays.asList("Physics","Math", "Biology"));
        Student student4 = new Student("John", Arrays.asList("Math", "Physics", "Biology"));
        Student student5 = new Student("Jesus", Arrays.asList("Philosophy", "Sociology"));
        Student student6 = new Student("George", Arrays.asList("Philosophy", "Physics", "Biology", "Math"));
        Student student7 = new Student("Rob", Arrays.asList("Biology", "Physics", "Math"));

        Stream<Student> studentStream = Stream.of(student1, student2, student3, student4, student5, student6, student7);

        studentStream
                .flatMap(student -> student.getSubjects().stream()
                        .map(subjects -> new HashMap.SimpleEntry<>(subjects, student)))
                .collect(Collectors.groupingBy(map -> map.getKey()))
                .entrySet().stream()
                .filter(e -> e.getValue().size() == 1)
                .map(e -> e.getValue().get(0).getValue().getLogin())
                .forEach(System.out::println);
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

    public List<String> getSubjects() {
        return subjects;
    }
}
