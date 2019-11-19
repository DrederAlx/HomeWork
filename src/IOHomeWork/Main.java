package IOHomeWork;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        //TODO Написать свои реализации InputStream и OutputStream, которые будут расширять FilterInputStream и
        // FilterOutputStream, в переопределяемых методах (write и read) необходимо шифровать и дешифровать данные
        // (использовать xor)

        File file = new File("resources/source.txt");
        try {
            splitFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file1 = new File("resources/part1.txt");
        File file2 = new File("resources/part2.txt");
        try {
            mergeFiles(file1, file2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void splitFile (File file) throws IOException {
        File file1 = new File("resources/part1.txt");
        File file2 = new File("resources/part2.txt");
        try (FileInputStream fileInputStream = new FileInputStream(file);
             FileOutputStream fileOutputStream1 = new FileOutputStream(file1);
             FileOutputStream fileOutputStream2 = new FileOutputStream(file2)){

            byte[] buf = new byte[10];
            int data;

            int available = fileInputStream.available();

                while ((data = fileInputStream.read(buf)) > 0){
                    if (fileInputStream.available() > available / 2){
                        fileOutputStream1.write(buf, 0, data);
                    }
                    else {
                        fileOutputStream2.write(buf, 0, data);
                    }
            }
        }
    }

    public static void mergeFiles (File file1, File file2) throws IOException {
        File outputFile = new File("resources/mergeResult.txt");
        try (FileInputStream input1 = new FileInputStream(file1);
             FileInputStream input2 = new FileInputStream(file2);
             FileOutputStream fileOutputStream = new FileOutputStream(outputFile)) {
            SequenceInputStream sequenceInputStream = new SequenceInputStream(input1, input2);

            byte[] buf = new byte[10];
            int data;

            while ((data = sequenceInputStream.read(buf)) > 0){
                fileOutputStream.write(buf, 0, data);
            }
        }
    }
}
