package ExceptionHomeWork;

/*
Написать калькулятор.
Калькулятор считывает с консоли одно из выражений (n+m / n-m / nХm / n/m, где n и m - целые числа)
или exit для завершения работы. Калькулятор выводит результат вычисления в консоль, после чего ожидает ввода
нового выражения или exit для завершения работы.

В случае если введенное выражение не совпадает с заданным шабломом, выбрасывает исключения: отсутствуют n или m -
выбрасывать один тип исключения, указан не тот оператор - выбрасывать другое исключение, в качестве оператора указан /,
а второй операнд 0, либо n или m не целые числа - выбрасывать третий тип исключения.

Необходимо написать свои классы исключений. Исключения должны быть проверяемыми (checked).
Метод исключений getMessage() необходимо переопределить (реализация на Ваше усмотрение).
*/

import java.util.regex.Pattern;

public class Calculator {

    void parseIn(String input) {
        // Pattern pattern = Pattern.compile("");
        StringBuilder builder = new StringBuilder();
        int n = 0;
        int m;
        char opChar = ' ';

        for (char c : input.replaceAll(" ", "").toCharArray()) {
            if (Character.isDigit(c)) builder.append(c);
            else {
                n = Integer.parseInt(builder.toString());
                opChar = c;
                builder = new StringBuilder();
            }
        }
        m = Integer.parseInt(builder.toString());

        calculate(n, m, opChar);
    }

    void calculate(int n, int m, char opChar){
        if ('*' == opChar) {
            System.out.println("Результат\n" + n + " " + opChar + " " + m + " = " + (n*m));
        }
        else if ('+' == opChar) {
            System.out.println("Результат\n" + n + " " + opChar + " " + m + " = " + (n+m));
        }
        else if ('/' == opChar) {
            if (n%m != 0) {
                double result = (double) n/m;
                System.out.println("Результат\n" + n + " " + opChar + " " + m + " = " + result);
            }
            else System.out.println("Результат\n" + n + " " + opChar + " " + m + " = " + (n/m));
        }
        else if ('-' == opChar) {
            System.out.println("Результат\n" + n + " " + opChar + " " + m + " = " + (n-m));
        }
    }
}
