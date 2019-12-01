package ExceptionHomeWork;

import ExceptionHomeWork.CalcExcept.FailArgException;
import ExceptionHomeWork.CalcExcept.InputFormatException;
import ExceptionHomeWork.CalcExcept.OperatorsException;

import java.util.Scanner;

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
            try {
                calc.parseIn(input);
            }

            catch (InputFormatException e) {
                System.out.println(e.getMessage());
            }

            catch (OperatorsException e) {
                System.out.println(e.getMessage());
            }

            catch (FailArgException e) {
                System.out.println(e.getMessage());
            }


        }
    }
}
