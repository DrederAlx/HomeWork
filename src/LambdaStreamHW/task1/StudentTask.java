package LambdaStreamHW.task1;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentTask {
    public static void main(String[] args) {

        //TODO: найти студентов с уникальными предметами. Задачу решать с использованием stream API

        Student student1 = new Student("Ivan", Arrays.asList("Math", "Physics", "Biology", "Philosophy"));
        Student student2 = new Student("Bob", Arrays.asList("Economics", "Physics", "Math"));
        Student student3 = new Student("Mike", Arrays.asList("Physics","Math", "Biology"));
        Student student4 = new Student("John", Arrays.asList("Math", "Physics", "Biology"));
        Student student5 = new Student("Jesus", Arrays.asList("Philosophy", "Sociology"));
        Student student6 = new Student("George", Arrays.asList("Philosophy", "Physics", "Biology", "Math"));
        Student student7 = new Student("Rob", Arrays.asList("Biology", "Physics", "Math"));

        Stream<Student> studentStream = Stream.of(student1, student2, student3, student4, student5, student6, student7);

        // Map<List<String>, String> studentMap =
        /*
        studentStream
                .collect(Collectors.toMap(Student::getSubjects, Student::getLogin, (item1, item2) -> null))
                .entrySet()
                .stream()
                .flatMap(map -> map.getKey().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(e -> e.getKey())
                .forEach(System.out::println);
         */

        /*
        studentStream
                .collect(Collectors.toMap(student -> student.getSubjects().stream().reduce(Objects::toString).get(),
                        Function.identity(), (item1, item2) -> item1))
                .entrySet()
                .stream()
                .forEach(System.out::println);

         */

        studentStream
                .flatMap(student -> student.getSubjects().stream()
                        .map(subjects -> new HashMap.SimpleEntry<>(subjects, student)))
                .collect(Collectors.groupingBy(map -> map.getKey()) )
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

    public void setLogin(String login) {
        this.login = login;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "login='" + login + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
