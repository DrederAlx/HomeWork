package ExceptionHomeWork;

import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import java.util.jar.JarException;

public class Main {
    public static void main(String[] args){
        ExceptionList.generate();

       /* Метод static void throwException(Status status)
       throws JarException, FileNotFoundException, AccessDeniedException
       принимает на вход enum и выбрасывает следующие исключения в зависимости от значения status:
        если status FILE_NOT_FOUND, выбрасывает FileNotFoundException
        если status ACCESS_DENIED, выбрасывает AccessDeniedException
        если status JAR_ERROR, выбрасывает JarException.
       При вызове метода throwException обработать исключения следующим образом:
       FileNotFoundException - выводить в консоль стек трейс, AccessDeniedException
        - выводить в консоль сообщение исключения (метод getMessage()) и снова
        выбрасывать exception, JarException - выводить в консоль стек трейс.

        enum с необходимыми константами нужно создать.*/

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
    }
}
