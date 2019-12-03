package LambdaStreamHW.task3;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PupilTask {
    public static void main(String[] args) {

        ArrayList<Pupil> pupils = new ArrayList<>();

        pupils.add(new Pupil(1123, "James", Pupil.Gender.MALE, LocalDate.of(2006, Month.OCTOBER, 11)));
        pupils.add(new Pupil(4353, "Olga", Pupil.Gender.FEMALE, LocalDate.of(2007, Month.DECEMBER, 4)));
        pupils.add(new Pupil(8623, "Mike", Pupil.Gender.MALE, LocalDate.of(2008, Month.JULY, 24)));
        pupils.add(new Pupil(9345, "Alice", Pupil.Gender.FEMALE, LocalDate.of(2008, Month.FEBRUARY, 27)));
        pupils.add(new Pupil(7342, "Bob", Pupil.Gender.MALE, LocalDate.of(2008, Month.MARCH, 17)));
        pupils.add(new Pupil(2574, "Helen", Pupil.Gender.FEMALE, LocalDate.of(2007, Month.MAY, 3)));
        pupils.add(new Pupil(8871, "Richard", Pupil.Gender.MALE, LocalDate.of(2009, Month.APRIL, 21)));
        pupils.add(new Pupil(9436, "Kurt", Pupil.Gender.MALE, LocalDate.of(2006, Month.JUNE, 28)));

        // Используя Stream API:

        // 1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Pupil.Gender, ArrayList<Pupil>>

        // вариант 1
        Map<Pupil.Gender, ArrayList<Pupil>> genderMap = pupils.stream()
                .collect(Collectors.groupingBy(Pupil::getGender, Collectors.toCollection(ArrayList::new)));

        System.out.println(genderMap);

        // вариант 2
        pupils.stream()
                .collect(Collectors.groupingBy(Pupil::getGender, Collectors.toCollection(ArrayList::new)))
                .entrySet()
                .forEach(System.out::println);


        // 2. Найти средний возраст учеников

        int averageAge = (int) pupils.stream()
                .mapToInt(Pupil::getAge)
                .map(age -> age / 365)
                .average()
                .getAsDouble();

        System.out.println(averageAge);


        // 3. Найти самого младшего ученика

        Pupil minPupil = pupils.stream()
                .min(Comparator.comparing(Pupil::getAge))
                .orElse(new Pupil(1111, "Default", Pupil.Gender.MALE, LocalDate.of(2008, Month.JANUARY, 1)));

        System.out.println(minPupil);

        // 4. Найти самого старшего ученика

        // 5. Собрать учеников в группы по году рождения

        // 6. Убрать учеников с одинаковыми именами, имена и дату рождения оставшихся вывести в консоль

        // 7. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (List)

        // 8. Вывести в косоль всех учеников в возрасте от N до M лет

        // 9. Собрать в список всех учеников с именем=someName

        // 10. Собрать Map<Pupil.Gender, Integer>, где Pupil.Gender - пол, Integer - суммарный возраст учеников данного пола
    }
}
