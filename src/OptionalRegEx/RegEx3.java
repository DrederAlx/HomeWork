package OptionalRegEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx3 {
    public static void main(String[] args) {
        // найти самое длинное слово в предложении
        // (при условии, что все слова разной длинны)
        String str = "Съешь! еще! этих! мягких? французских, булочек.";
        Pattern pattern = Pattern.compile("[А-Яа-я ]");
        Matcher matcher = pattern.matcher(str);
        StringBuilder builder = new StringBuilder();
        while (matcher.find()) builder.append(matcher.group());
        str = builder.toString();
        String[] strArr = str.split("\\s");
        int length = strArr[0].length();
        int pos = 0;
        for (int i = 1; i < strArr.length; i++) {
            if (strArr[i].length()>length) {
                length = strArr[i].length();
                pos = i;
            }
        }
        System.out.println(strArr[pos]);
    }
}