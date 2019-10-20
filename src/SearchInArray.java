import java.util.Arrays;

public class SearchInArray {
    public static void main(String[] args) {
        // Дан массив целых чисел. Массив не отсортирован, числа могут повторяться.
        // Необходимо найти в данном массиве наиболее оптимальным способом (!) такие два числа n и m, чтобы их сумма была равна 7.
        // Например, 2 + 5 = 7, 6 + 1 = 7, -2 + 9 =7

        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100) - 50;
        }
        System.out.println("Дан массив " + Arrays.toString(arr));
        Arrays.sort(arr);
        boolean isFind = false;
        for (int i = 0; i < arr.length; i++) {
            int pair = 7 - arr[i];
            int pos = Arrays.binarySearch(arr, pair); // ищем индекс пары для проверяемого элемента, которая в сумме с ним даст 7
            if (pos >= 0) {
                isFind = true;
                System.out.println("Сумма " + arr[i] + " и " + arr[pos] + " равна 7");
                break;
            }
        }
        if (!isFind) {
            System.out.println("В массиве нет чисел, дающих в сумме 7");
        }
    }
}
