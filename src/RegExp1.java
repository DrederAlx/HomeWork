import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp1 {
    public static void main(String[] args) {

        // имеются 2 строки. Найти вхождений
        // одной строки в другую (сколько раз встречается подстрока в строке)

        String str = "Это тестовый текст для тестового поиска тестовой подстроки";
        String str1 = "тест";
        Pattern patt = Pattern.compile(str1);
        Matcher matcher = patt.matcher(str);
        int i = 0;
        while (matcher.find()) {
            i++;
        }
        System.out.println(i);
    }
}
