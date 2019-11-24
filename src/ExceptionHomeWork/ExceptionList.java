package ExceptionHomeWork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExceptionList {

    /* Создать список исключений и заполнить его 9 различными runtime исключениями. Например,

  try {
      int[] arr = new int[5];
      arr[7] = 12;
  } catch (Exception e) {
      exceptionsList.add(e);
  }
     */

    static void generate() {
        List <RuntimeException> exceptionList = new ArrayList<>();

        try {
            int a = 1;
            int b = 0;
            int c = a/b;
        } catch (RuntimeException e) {
            exceptionList.add(e);
        }

        try {
            int [] arr = new int [-10];
        } catch (RuntimeException e) {
            exceptionList.add(e);
        }

        try {
            int [] arr = new int [10];
            System.out.println(arr[15]);
        } catch (RuntimeException e) {
            exceptionList.add(e);
        }

        try {
            String someString = "Exception String";
            char [] charArr = new char[10];
            someString.getChars(30,35,charArr,0);
        } catch (RuntimeException e) {
            exceptionList.add(e);
        }

        try {
            String [] arr = new String[10];
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i].length());
            }
        } catch (RuntimeException e) {
            exceptionList.add(e);
        }

        try {
            String s = "Abc";
            int a = 1;
            int b = Integer.parseInt(s);
        } catch (RuntimeException e) {
            exceptionList.add(e);
        }

        try {
            Object s = "string";
            int a = (int) s;
        } catch (RuntimeException e) {
            exceptionList.add(e);
        }

        try {
            Object[] o = new Object[10];
            for (int i = 0; i < o.length; i++) {
                o[i] = i;
            }
            String[] s = new String[10];
            s = Arrays.copyOf(o, o.length, String[].class);
        } catch (RuntimeException e) {
            exceptionList.add(e);
        }

        try {

        } catch (RuntimeException e) {
            exceptionList.add(e);
        }

        try {
            int [] arr = new int [10];
            for (int i = 0; i < 15; i++) {
                arr[i] = i;
            }
        } catch (RuntimeException e) {
            exceptionList.add(e);
        }

        System.out.println("В массиве " + exceptionList.size() + " элементов.");
        for (RuntimeException exception : exceptionList) {
            System.out.println(exception);
        }

    }
}
