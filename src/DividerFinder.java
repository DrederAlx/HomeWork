import java.util.Scanner;

public class DividerFinder {
    public static void main(String[] args) {
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
    }
}
