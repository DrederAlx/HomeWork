package OptionalRegEx;

public class RegEx2 {
    public static void main(String[] args) {
        // даны два слова, состоящие из четного количества букв
        // Нужно составить третье слово из первой половины 1го и второй половины второго
        String str = "пара слов";
        String[] strings = str.split("\\s");
        String str1 = strings[0].substring(0, strings[0].length()/2) + strings[1].substring(strings[1].length()/2);
        System.out.println(str1);
    }
}
