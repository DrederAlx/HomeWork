package ThreadHW;

import java.io.*;
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

        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            threads.add(new Thread(new CollectTopThread()));
        }
        for (Thread thread : threads) {
            thread.start();
            System.out.println(thread.getName());
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ReadThread implements Runnable{

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

class CollectTopThread implements Runnable{

    @Override
    public void run() {
        }
    }

class ValueComparator implements Comparator<Map.Entry<String, Integer>> {

        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            return Integer.compare(o1.getValue(), o2.getValue());
        }
    }

