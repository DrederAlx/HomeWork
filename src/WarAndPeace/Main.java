package WarAndPeace;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        File file1 = new File("resources/wp.txt");
        List<String> strings = parseFile(file1);
        countWords(strings, "war");
    }

    public static void countWords (List<String> strings, String word) {

        Map<String, Integer> wordMap = new HashMap<>();
        word = word.toLowerCase();
        for (String string : strings) {
            string = string.toLowerCase();
            if (word.equals(string) && !wordMap.containsKey(string)) {
                wordMap.put(string, 1);
            }
            else if (word.equals(string) && wordMap.containsKey(string)){
                wordMap.put(string, wordMap.get(string) + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            System.out.println("Количество слов " + entry.getKey() + " в тексте: " + entry.getValue());
        }

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
                    .replaceAll("\\p{Punct}", "")
                    .trim()
                    .split(" ");

            for (String s: strings1){
                if (s.length() > 0) {
                    newStrings.add(s);
                }
            }
        }
        return newStrings;
    }
}