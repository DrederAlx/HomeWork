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

import ExceptionHomeWork.CalcExcept.FailArgException;
import ExceptionHomeWork.CalcExcept.InputFormatException;
import ExceptionHomeWork.CalcExcept.OperatorsException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    void parseIn(String input) throws InputFormatException, OperatorsException, FailArgException {

        StringBuilder builder = new StringBuilder();
        int n = 0;
        int m;
        char opChar = ' ';
        boolean isFind1, isFind2, isFind3;

        input.replaceAll(" ", "");

        Pattern pattern1 = Pattern.compile("^[0-9.]+"); //n
        Matcher matcher1 = pattern1.matcher(input);
        isFind1 = matcher1.find();
        Pattern pattern2 = Pattern.compile("^[0-9.]+[+\\-*/]"); //operator
        Matcher matcher2 = pattern2.matcher(input);
        isFind2 = matcher2.find();
        Pattern pattern3 = Pattern.compile("^[0-9.]+[+\\-*/][0-9.]+$"); //m
        Matcher matcher3 = pattern3.matcher(input);
        isFind3 = matcher3.find();


        if (input.equals("") || !isFind1 || !isFind3) throw new InputFormatException();
        if (!isFind2) throw new OperatorsException();

        char[] inputChar = input.toCharArray();

        for (char c : inputChar) {

            if (c == '.') throw new FailArgException();

            if (Character.isDigit(c)) builder.append(c);
            else {
                n = Integer.parseInt(builder.toString());
                opChar = c;
                builder = new StringBuilder();
            }
        }
        m = Integer.parseInt(builder.toString());

        if (opChar == '/' && m == 0) throw new FailArgException();


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
