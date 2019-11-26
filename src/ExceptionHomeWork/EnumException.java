package ExceptionHomeWork;

import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import java.util.jar.JarException;

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
    FILE_NOT_FOUND, ACCESS_DENIED, JAR_ERROR;
}
