package ExceptionHomeWork;

import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import java.util.Scanner;
import java.util.jar.JarException;

public class Main {
    public static void main(String[] args) {

        /*
        ExceptionList.generate();

        try {
            EnumException.throwException(Status.ACCESS_DENIED);

        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
            try {
                throw e;
            } catch (AccessDeniedException ex) {
                ex.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JarException e) {
            e.printStackTrace();
        }
        */

        Scanner in = new Scanner(System.in);
        Calculator calc = new Calculator();

        while (true){
            System.out.println("Введите выражение или exit для выхода");
            String input = in.nextLine();
            if ("exit".equals(input)) break;
            calc.parseIn(input);
        }
    }
}
