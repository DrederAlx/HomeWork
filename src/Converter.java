import java.util.Scanner;

public class Converter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите целое число");
        int a = input.nextInt();
        String s = "";
        StringBuilder builder = new StringBuilder(s);
        int d = a;
        do {
            int b = a % 2; // остаток от деления
            builder.insert(0, b);
            a = a / 2;
        }
        while (a > 0);
        s = builder.toString();
        System.out.println("Перевод в двоичную систему: " + s);

        // перевод в 16 сс

        String s1 = "";
        StringBuilder builder1 = new StringBuilder(s1);
        do {
            int b = d % 16; // остаток от деления
            if (b < 10) {
                builder1.insert(0, b);
            }
            else {
                switch (b) {
                    case 10:
                        builder1.insert(0,'A');
                        break;
                    case 11:
                        builder1.insert(0,'B');
                        break;
                    case 12:
                        builder1.insert(0,'C');
                        break;
                    case 13:
                        builder1.insert(0,'D');
                        break;
                    case 14:
                        builder1.insert(0,'E');
                        break;
                    case 15:
                        builder1.insert(0,'F');
                        break;
                }
            }
            d = d / 16;
        }
        while (d > 0);
        s1 = builder1.toString();
        System.out.println("Перевод в шестнадцатиричную систему: " + s1);
    }
}
// test