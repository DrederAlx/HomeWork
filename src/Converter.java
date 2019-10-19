import java.util.Scanner;

public class Converter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите целое число");
        int a = input.nextInt();
        String s = "";
        StringBuilder buffer = new StringBuilder(s);
        int d = a;
        do {
            int b = a % 2; // остаток от деления
            buffer.append(b);
            a = a / 2;
        }
        while (a > 0);
        buffer.reverse();
        s = buffer.toString();
        System.out.println("Перевод в двоичную систему: " + s);

        // перевод в 16 сс

        String s1 = "";
        StringBuilder buffer1 = new StringBuilder(s1);
        do {
            int b = d % 16; // остаток от деления
            if (b < 10) {
                buffer1.append(b);
            }
            else {
                switch (b) {
                    case 10:
                        buffer1.append("A");
                        break;
                    case 11:
                        buffer1.append("B");
                        break;
                    case 12:
                        buffer1.append("C");
                        break;
                    case 13:
                        buffer1.append("D");
                        break;
                    case 14:
                        buffer1.append("E");
                        break;
                    case 15:
                        buffer1.append("F");
                        break;
                }
            }
            d = d / 16;
        }
        while (d > 0);
        buffer1.reverse();
        s1 = buffer1.toString();
        System.out.println("Перевод в шестнадцатиричную систему: " + s1);
    }
}