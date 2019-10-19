import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) {

        // ДЗ посчитать наибольший общий делитель у двух чисел с помощью for
/*
        Scanner input = new Scanner(System.in);
        System.out.println("Введите два целых положительных числа");
        int a = input.nextInt();
        int b = input.nextInt();
        int den = 1;
        for (int i = 1; i <= a; i++) {
            if ((a % i == 0) && (b % i == 0)) {
                den = i;
            }
        }
        System.out.printf("Наибольший общий делитель введенных чисел: %d\n", den);


 */
        // Написать программу перевода числа из 10 системы счисления в 2 систему счисления, в 16 систему счисления
/*
        Scanner input = new Scanner(System.in);
        System.out.println("Введите целое число");
        int a = input.nextInt();
        String s = "";
        int d = a;
        do {
            int b = a % 2; // остаток от деления
            s += Integer.toString(b);
            a = a / 2;
        }
        while (a > 0);

        StringBuffer buffer = new StringBuffer(s);
        System.out.println(buffer.reverse());
        // перевод в 16 сс
        String s1 = "";
        do {
            int b = d % 16; // остаток от деления
            if (b < 10) {
                s1 += Integer.toString(b);
            }
            else {
                switch (b) {
                    case 10:
                        s1 += "A";
                        break;
                    case 11:
                        s1 += "B";
                        break;
                    case 12:
                        s1 += "C";
                        break;
                    case 13:
                        s1 += "D";
                        break;
                    case 14:
                        s1 += "E";
                        break;
                    case 15:
                        s1 += "F";
                        break;
                }
            }
                d = d / 16;
        }
        while (d > 0);

        StringBuffer buffer1 = new StringBuffer(s1);
        System.out.println(buffer1.reverse());
*/



        // Дан массив целых чисел. Массив не отсортирован, числа могут повторяться.
        // Необходимо найти в данном массиве наиболее оптимальным способом (!) такие два числа n и m, чтобы их сумма была равна 7.
        // Например, 2 + 5 = 7, 6 + 1 = 7, -2 + 9 =7

    }
}
