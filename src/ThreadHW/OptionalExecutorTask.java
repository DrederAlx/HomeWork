package ThreadHW;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OptionalExecutorTask {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Scanner scanner = new Scanner(System.in);
        String command;
        while (true) {
            System.out.println("Введите команду или exit для выхода");
            command = scanner.nextLine();
            if ("exit".equals(command)) {
                threadPool.shutdown();
                break;
            }
            else if ("time".equals(command)) {
                threadPool.execute(new Time());
            }
            else if ("getFromFile".equals(command)) {
                threadPool.execute(new GetFromFile());
            }
            else if ("help".equals(command)){
                threadPool.execute(new Help());
            }
        }
    }
}

    class Time implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(LocalDateTime.now());
        }
    }

    class Help implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Список доступных команд: \nhelp - помощь \ntime - текущее время \n" +
                    "getFromFile - получение данных из файла");
        }
    }

    class GetFromFile implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                System.out.println(Files.readAllLines(new File("resources/source.txt").toPath()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


