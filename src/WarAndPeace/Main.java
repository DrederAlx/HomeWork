package WarAndPeace;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        File file1 = new File("resources/wp.txt");
        List<String> strings = parseFile(file1);

        countWords(strings, "help me");
        countWords(strings, "told me");
        countWords(strings, "did not finish");
        wordsToGroup(strings);

        for (Map.Entry<Integer, ArrayList<String>> entry : wordsToGroup(strings).entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        for (Map.Entry<Integer, HashSet<String>> entry : wordsToGroupNoArt(strings).entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        topTen(strings);
        countLetters(strings);
    }

    public static void countWords (List<String> strings, String wordOrPhrase) {

        int count = 0;
        String[] phrase = wordOrPhrase.split(" ");

        Iterator<String> stringIterator = strings.listIterator();

        int j = 0;
        while (stringIterator.hasNext()) {
            if (phrase[j].toLowerCase().equals(stringIterator.next().toLowerCase())) {
                j++;
                if (j == phrase.length) {
                    j = 0;
                    count++;
                }
            }
            else j = 0;
        }

        System.out.println("Количество слов \"" + wordOrPhrase + "\" в тексте: " + count);
    }

    public static Map<Integer, ArrayList<String>> wordsToGroup(List<String> strings) {
        Map<Integer, ArrayList<String>> map = new HashMap<>();

        for (String string: strings) {
            if (!map.containsKey(string.length())) {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(string);
                map.put(string.length(), arrayList);
            } else {
                map.get(string.length()).add(string);
            }
        }
        return map;
    }

    public static Map<Integer, HashSet<String>> wordsToGroupNoArt(List<String> strings) {
        Map<Integer, HashSet<String>> map = new HashMap<>();
        boolean isArticle;

        for (String string: strings) {
            isArticle = false;
            for (int i = 0; i < Articles.articles.length; i++) {
                if (Articles.articles[i].equals(string.toLowerCase())) isArticle = true;
            }
            if (!isArticle) {
                if (!map.containsKey(string.length())) {
                    HashSet<String> hashSet = new HashSet<>();
                    hashSet.add(string);
                    map.put(string.length(), hashSet);
                } else {
                    map.get(string.length()).add(string);
                }
            }
        }
        return map;
    }

    public static List<String> parseFile (File file) {
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

            for (String s: strings1){
                if (s.toLowerCase().equals("i") || s.toLowerCase().equals("a") || s.length() > 1) {
                    newStrings.add(s);
                }
            }
        }
        return newStrings;
    }

    public static void topTen (List<String> strings) {
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

    public static void countLetters (List<String> strings) {

        Map<Character, Double> map = new HashMap<>();
        int generalChar = 0;

        for (String string: strings) {
            string = string.toLowerCase().replaceAll("[^a-z]", "");
            generalChar += string.toCharArray().length;
            for (Character character : string.toCharArray()) {
                if (!map.containsKey(character)) {
                    map.put(character, 1.00);
                } else {
                    map.put(character, map.get(character) + 1.00);
                }
            }
        }

        Map<Character, Double> percentMap = new HashMap<>();
        for (Map.Entry<Character, Double> entry : map.entrySet()) {
            percentMap.put(entry.getKey(), entry.getValue()/generalChar*100);
        }

        for (Map.Entry<Character, Double> entry : percentMap.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            System.out.printf("%.2f", entry.getValue());
            System.out.print("%" + "\n");

        }
    }
}

class ValueComparator implements Comparator<Map.Entry<String, Integer>> {

    @Override
    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        return Integer.compare(o1.getValue(), o2.getValue());
    }
}