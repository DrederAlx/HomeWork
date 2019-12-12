package ThreadHW;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class ThreadWP {

    // топ 100 слов параллельно.
    // Количество потоков = Runtime.getRuntime().availableProcessors()
    // Каждый поток собирает результат в свой map, затем добавляет в общий map.
    // Поток, который создавал другие потоки должен ожидать их завершения и
    // выводить результат в консоль

    // the - 234
    // the - 56

    public static void main(String[] args) {
        File file1 = new File("resources/wp.txt");
        List<String> strings = parseFile(file1);
        topTen(strings);

    }

    public static List<String> parseFile(File file) {
        List<String> strings = null;
        try {
            strings = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> newStrings = new ArrayList<>();
        for (String string : strings) {
            String[] strings1 = string
                    .replaceAll("'", "")
                    .replaceAll("[0-9]", "")
                    .replaceAll("\\p{Punct}", " ")
                    .trim()
                    .split(" ");

            for (String s : strings1) {
                if (s.toLowerCase().equals("i") || s.toLowerCase().equals("a") || s.length() > 1) {
                    newStrings.add(s);
                }
            }
        }
        return newStrings;
    }

    public static void topTen(List<String> strings) {
        Map<String, Integer> map = new HashMap<>();

        for (String string : strings) {
            if (!map.containsKey(string)) {
                map.put(string, 1);
            } else {
                map.put(string, map.get(string) + 1);
            }
        }
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Comparator<Map.Entry<String, Integer>> mapComparator = new ValueComparator();
        list.sort(mapComparator);
        for (int i = list.size() - 1; i > list.size() - 11; i--) {
            System.out.println("Слово \"" + list.get(i).getKey() + "\" встречается " + list.get(i).getValue() + " раз.");
        }
    }
}


class ValueComparator implements Comparator<Map.Entry<String, Integer>> {

        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            return Integer.compare(o1.getValue(), o2.getValue());
        }
    }
