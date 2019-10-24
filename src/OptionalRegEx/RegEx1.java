package OptionalRegEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx1 {
    public static void main(String[] args) {

        // имеются 2 строки. Найти вхождений
        // одной строки в другую (сколько раз встречается подстрока в строке)

        String str = "java test Java test java TEST JAVA";
        String str1 = "java";
        Pattern patt = Pattern.compile(str1, Pattern.CASE_INSENSITIVE); // Поиск без учета регистра не работает для кириллицы, но это можно прописать в конце регулярного выражения
        Matcher matcher = patt.matcher(str);
        int i = 0;
        while (matcher.find()) {
            i++;
        }
        System.out.println(i);
    }
}
