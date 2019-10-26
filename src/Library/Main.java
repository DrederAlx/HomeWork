package Library;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Book java = new Book();
        Book cleanCode = new Book();

        // для доступа к свойству объекта нужно написать его имя, точка и свойство к которому хотим обратиться
        // доступ к свойству
        //java.title = "Философия Java";
        //cleanCode.title = "Чистый код";

        //java.author = "Брюс Эккель";
        //cleanCode.author = "Роберт Мартин";

        // вызов метода
        java.setTitle("Философия Java");
        cleanCode.setTitle("Чистый код");

        // System.out.println(java.getTitle()); // у объекта java вызываем метод getTitle
        // System.out.println(cleanCode.getTitle());

        java.setAuthor("Брюс Эккель");
        cleanCode.setAuthor("Роберт Мартин");

        java.setIsForHome(false);

        cleanCode.setIsForHome(true);

        Book forBeginners = new Book("Руководство для начинающих", "Герберт Шилдт");

        Library library = new Library();
        library.addBook(java);
        library.addBook(cleanCode, forBeginners);

        System.out.println(Arrays.toString(library.getBooks()));
        System.out.println(library.getInfo("Философия Java"));
        System.out.println(library.takeHome("Чистый код"));
    }
}
