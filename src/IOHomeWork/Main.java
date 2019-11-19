package IOHomeWork;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //TODO Написать свои реализации InputStream и OutputStream, которые будут расширять FilterInputStream и
        // FilterOutputStream, в переопределяемых методах (write и read) необходимо шифровать и дешифровать данные
        // (использовать xor)

        //TODO Есть файл, написать метод который берет файл и разбивает его на две части и одну часть записывает в один файл,
        // вторую - в другой. Написать метод, который берет два файла на вход и записывает их в один файл

        File file = new File("resources/iofile.txt");
        try {
            readByteArray(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readByteArray (File file) throws IOException {
        File file1 = new File("resources/newiofile1.txt");
        File file2 = new File("resources/newiofile2.txt");
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
}
