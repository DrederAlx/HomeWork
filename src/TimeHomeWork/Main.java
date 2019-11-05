package TimeHomeWork;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
/*
        Есть три рабочие смены:

        с 7:00 до 15:00
        с 15:00 до 23:00
        с 23:00 до 7:00
        Определить какая сейчас смена (относительно текущего времени)

        Наши занятия закончатся 20 января 2020 года. Сколько занятий осталось,
        если они проходят 3 раза в неделю (пн, ср, пт). Праздничные дни не учитывать.

 */

        LocalTime currentTime = LocalTime.now();
        LocalTime shiftOneBegin = LocalTime.of(7,0);
        LocalTime shiftOneEnd = LocalTime.of(15,0);
        LocalTime shiftTwoBegin = LocalTime.of(15,0);
        LocalTime shiftTwoEnd = LocalTime.of(23,0);

        if (currentTime.isAfter(shiftOneBegin) && currentTime.isBefore(shiftOneEnd) ||
                currentTime.equals(shiftOneBegin)){
            System.out.println("Сейчас первая смена");
        }
        else if (currentTime.isAfter(shiftTwoBegin) && currentTime.isBefore(shiftTwoEnd) ||
                currentTime.equals(shiftTwoBegin)){
            System.out.println("Сейчас вторая смена");
        }
        else {
            System.out.println("Сейчас третья смена");
        }

        LocalDate currentDate = LocalDate.now();
        LocalDate javaEnds = LocalDate.of(2020, Month.JANUARY, 20);
        long lessonsLeft = ChronoUnit.WEEKS.between(currentDate, javaEnds);
        lessonsLeft *= 3;
        System.out.println(lessonsLeft);

    }
}
