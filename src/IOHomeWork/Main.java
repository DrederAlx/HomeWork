package IOHomeWork;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        //TODO Написать свои реализации InputStream и OutputStream, которые будут расширять FilterInputStream и
        // FilterOutputStream, в переопределяемых методах (write и read) необходимо шифровать и дешифровать данные
        // (использовать xor)

        File file = new File("resources/source.txt");
        File part1 = new File("resources/part1.txt");
        File part2 = new File("resources/part2.txt");
        File encrypted = new File("resources/encrypted.txt");
        try {
            splitFile(file);
            mergeFiles(part1, part2);
            cryptoWrite(file, "JavaJunior");
            cryptoRead(encrypted, "JavaJunior");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void splitFile(File file) throws IOException {
        File file1 = new File("resources/part1.txt");
        File file2 = new File("resources/part2.txt");
        try (FileInputStream fileInputStream = new FileInputStream(file);
             FileOutputStream fileOutputStream1 = new FileOutputStream(file1);
             FileOutputStream fileOutputStream2 = new FileOutputStream(file2)) {

            byte[] buf = new byte[10];
            int data;

            int available = fileInputStream.available();

            while ((data = fileInputStream.read(buf)) > 0) {
                if (fileInputStream.available() > available / 2) {
                    fileOutputStream1.write(buf, 0, data);
                } else {
                    fileOutputStream2.write(buf, 0, data);
                }
            }
        }
    }

    public static void mergeFiles(File file1, File file2) throws IOException {
        File outputFile = new File("resources/mergeResult.txt");
        try (FileInputStream input1 = new FileInputStream(file1);
             FileInputStream input2 = new FileInputStream(file2);
             FileOutputStream fileOutputStream = new FileOutputStream(outputFile)) {
            SequenceInputStream sequenceInputStream = new SequenceInputStream(input1, input2);

            byte[] buf = new byte[10];
            int data;

            while ((data = sequenceInputStream.read(buf)) > 0) {
                fileOutputStream.write(buf, 0, data);
            }
        }
    }

    public static void cryptoWrite(File file, String key) throws IOException {
        File encryptedFile = new File("resources/encrypted.txt");
        try (InputStream input = new FileInputStream(file);
             MyOutputStream cryptoOut = new MyOutputStream(new FileOutputStream(encryptedFile), key)) {

            byte[] buf = new byte[10];
            int data;

            while ((data = input.read(buf)) > 0) {
                cryptoOut.write(buf, 0, data);
            }
        }
    }

    public static void cryptoRead(File file, String key) throws IOException {
        File decryptedFile = new File("resources/decrypted.txt");
        try (InputStream decryptIn = new MyInputStream(new FileInputStream(file), key);
             OutputStream cryptoOut = new FileOutputStream(decryptedFile)) {

            int data;

            while ((data = decryptIn.read()) > 0) {
                cryptoOut.write(data);
            }
        }
    }
}
