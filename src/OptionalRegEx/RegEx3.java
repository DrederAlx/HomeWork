package OptionalRegEx;

public class RegEx3 {
    public static void main(String[] args) {
        // найти самое длинное слово в предложении
        // (при условии, что все слова разной длинны)
        String str = "Съешь ещё этих мягких французских булочек";
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
