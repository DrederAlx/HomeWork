package Library;

public class Book {
    // свойства, поля, аттрибуты объектов
    // Названия книг
    private String title; // значение null по умолчанию для ссылочных типов
    private String author; // модификатор доступа private говорит о том что доступ к свойству элемента доступен только внутри класса (между {})
    private boolean isAvailable; // null - значение по умолчанию для ссылочных типов
    private boolean isForHome;

    // Конструкторы

    public Book(){} // Конструктор по умолчанию (если не создан никакой другой конструтор, он невидим)
    public Book(String title, String author){ // Если мы прописали какой то конструктор, то конструктор по умолчанию перестает существовать
        setTitle(title);
        setAuthor(author);
    }
    public Book(String title){
        setTitle(title);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isAvailable=" + isAvailable +
                ", isForHome=" + isForHome +
                '}';
    }
// методы, устанавливающий значение свойств title и author

    public void setTitle(String title){     // void - метод не возвращает никаких значений и результат его работы в переменную не записать
        // this - это ссылка на текущий объект
        if (title != null && !"".equals(title)) {
            this.title = title;
        }
    }

    // ctrl + enter или cmd + N

    public void setAuthor(String author) { // сеттеры - это методы которые устанавливают значение свойств
        if (author != null && !"".equals(author)) {
            this.author = author;
        }
    }

    public void setIsAvailable(boolean isAvailable) {

        this.isAvailable = isAvailable;
    }

    public void setIsForHome(boolean isForHome){
        this.isForHome = isForHome;
    }

    // геттеры - это методы, которые возвращают значение свойств

    public String getTitle() { // здесь String это тип возвращаемого значения
        return title; // return прекращает работу метода и возвращает значение (все что после return выполнено не будет)
        // в войде сразу прекратит работу метода
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {

        return isAvailable;
    }

    public boolean isForHome() {

        return isForHome;
    }
}
