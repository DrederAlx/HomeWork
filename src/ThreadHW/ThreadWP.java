package ThreadHW;

import java.io.*;
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

        MultiRead multiRead = new MultiRead();
        multiRead.readFile(new File("resources/wp.txt"));
        for (Map.Entry<String, Integer> entry : multiRead.getTopHundred().entrySet()) {
            System.out.println("Слово \"" + entry.getKey() + "\" встречается " + entry.getValue() + " раз.");
        }
    }
}

class ReadThread extends Thread{

    private File file;
    private long startPos;
    private long length;
    private Map<String, Integer> wordMap = new HashMap<>();

    public ReadThread(File file, long startPos, long length) {
        this.file = file;
        this.startPos = startPos;
        this.length = length;
    }

    public Map<String, Integer> getWordMap() {
        return wordMap;
    }

    @Override
    public void run() {
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            // r - модификатор обозначающий что файл будет открыт только для чтения
        raf.seek(startPos);
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(raf.getFD()))){
                String line;
                while ((line = bufferedReader.readLine()) != null && raf.getFilePointer() < (startPos + length)){
                    String[] words = line
                            .replaceAll("'", "")
                            .replaceAll("[0-9]", "")
                            .replaceAll("\\p{Punct}", " ")
                            .trim()
                            .split(" ");

                    for (String string: words){
                        if (!"".equals(string)){
                            Integer num = wordMap.get(string);
                            wordMap.put(string, num == null ? 1 : num + 1);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MultiRead {

    private Map<String, Integer> resultMap;
    private LinkedHashMap<String, Integer> topHundred;

    public HashMap<String, Integer> getTopHundred() {
        return topHundred;
    }

    private void wordsFromMaps(Map<String, Integer> map) {
        if (resultMap == null) {
            resultMap = map;
        }
        else {
           for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String key = entry.getKey();
                if (resultMap.containsKey(key)) {
                    resultMap.put(key, resultMap.get(key) + entry.getValue());
                }
                else {
                    resultMap.put(key, entry.getValue());
                }
            }
        }
    }

    public void readFile(File file){
        int numberOfThreads = Runtime.getRuntime().availableProcessors();
        long fileLength = file.length();
        long partLength = fileLength%numberOfThreads == 0 ? fileLength / (long) numberOfThreads : fileLength / (long) numberOfThreads + 1;
        ReadThread[] threads = new ReadThread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new ReadThread(file, i * partLength, partLength);
        }
        for (ReadThread thread: threads) {
            thread.start();
        }
        for (ReadThread thread: threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (ReadThread thread: threads) {
            wordsFromMaps(thread.getWordMap());
        }
        topHundred = new LinkedHashMap<>();
        resultMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(100)
                .forEach(e -> topHundred.put(e.getKey(), e.getValue()));
    }
}
