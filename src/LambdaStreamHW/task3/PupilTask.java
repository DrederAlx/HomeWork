package LambdaStreamHW.task3;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PupilTask {
    public static void main(String[] args) {

        ArrayList<Pupil> pupils = new ArrayList<>();

        pupils.add(new Pupil(1123, "James", Pupil.Gender.MALE, LocalDate.of(2006, Month.OCTOBER, 11)));
        pupils.add(new Pupil(4353, "Alice", Pupil.Gender.FEMALE, LocalDate.of(2007, Month.DECEMBER, 4)));
        pupils.add(new Pupil(8623, "Mike", Pupil.Gender.MALE, LocalDate.of(2008, Month.JULY, 24)));
        pupils.add(new Pupil(9345, "Alice", Pupil.Gender.FEMALE, LocalDate.of(2008, Month.FEBRUARY, 27)));
        pupils.add(new Pupil(7342, "Bob", Pupil.Gender.MALE, LocalDate.of(2008, Month.MARCH, 17)));
        pupils.add(new Pupil(2574, "Mike", Pupil.Gender.MALE, LocalDate.of(2007, Month.MAY, 3)));
        pupils.add(new Pupil(8871, "Elisa", Pupil.Gender.FEMALE, LocalDate.of(2009, Month.APRIL, 21)));
        pupils.add(new Pupil(9436, "Olga", Pupil.Gender.FEMALE, LocalDate.of(2006, Month.JUNE, 28)));

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

        Pupil maxPupil = pupils.stream()
                .max(Comparator.comparing(Pupil::getAge))
                .orElse(new Pupil(1111, "Default", Pupil.Gender.MALE, LocalDate.of(2008, Month.JANUARY, 1)));

        System.out.println(maxPupil);

        // 5. Собрать учеников в группы по году рождения

        pupils.stream()
                .collect(Collectors.groupingBy(Pupil::getBirthYear, Collectors.toCollection(ArrayList::new)))
                .entrySet()
                .forEach(System.out::println);

        // 6. Убрать учеников с одинаковыми именами, имена и дату рождения оставшихся вывести в консоль

        pupils.stream()
                .collect(Collectors.toMap(Pupil::getName, Pupil::getBirth,
                (item1, item2) -> null))
                .entrySet()
                .forEach(System.out::println);

        // 7. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (List)

        pupils.stream()
                .sorted(Comparator.comparing(Pupil::getName).thenComparing(Pupil::getBirth).thenComparing(Pupil::getGender))
                .collect(Collectors.toList())
                .forEach(System.out::println);


        // 8. Вывести в косоль всех учеников в возрасте от N до M лет

        pupils.stream()
                .filter(pupil -> (pupil.getAge()/365) >= 10)
                .filter(pupil -> (pupil.getAge()/365) <= 11)
                .forEach(System.out::println);

        // 9. Собрать в список всех учеников с именем=someName

        List <Pupil> nameList = pupils.stream()
                .filter(pupil -> "Mike".equals(pupil.getName()))
                .collect(Collectors.toList());

        System.out.println("\n" + nameList);
        // 10. Собрать Map<Pupil.Gender, Integer>, где Pupil.Gender - пол, Integer - суммарный возраст учеников данного пола

        Map<Pupil.Gender, Integer> genderAgeMap = pupils.stream()
                .collect(Collectors.toMap(Pupil::getGender, pupil -> pupil.getAge()/365, (item1, item2) -> item1));

        System.out.println(genderAgeMap);
    }
}
