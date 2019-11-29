package ExceptionHomeWork;

import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import java.util.jar.JarException;

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

public class EnumException {
    static void throwException(Status status) throws JarException, FileNotFoundException, AccessDeniedException {

        if (status.equals(Status.FILE_NOT_FOUND)) {
            throw new FileNotFoundException();
        }

        if (status.equals(Status.ACCESS_DENIED)) {
            throw new AccessDeniedException("AccessDeniedException text");
        }

        if (status.equals(Status.JAR_ERROR)) {
            throw new JarException();
        }
    }
}

enum  Status {
    FILE_NOT_FOUND, ACCESS_DENIED, JAR_ERROR
}
