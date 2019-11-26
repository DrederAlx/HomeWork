package ExceptionHomeWork;

import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import java.util.jar.JarException;

public class Main {
    public static void main(String[] args){
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



    }
}
