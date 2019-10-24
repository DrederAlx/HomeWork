package Library;

import java.util.Arrays;

public class Library {
    private Book[] books = new Book[10];

    // в библиотеку можно добавить одну книгу

    public void addBook(Book newBook) {
        for (int i = 0; i < this.books.length; i++) {
            if (this.books[i] == null) {
                this.books[i] = newBook;
                break;
            }
        }
    }

    // в библиотеку можно добавить сразу несколько книг

    public void addBook(Book... newBooks) { // при передаче в метод нескольких книг в методе newBooks станет массивом

        for (int i = 0; i < newBooks.length; i++) {
            for (int j = 0; j < this.books.length; j++) {
                if (this.books[j] == null) {
                    this.books[j] = newBooks[i];
                    break;
                }
            }
        }
    }

        /* должна быть возможность получать информацию по книге, указав ее название
        (получаемая информация: автор, название, можно ли забрать домой, доступна ли книга)
        если книга не найдена сообщаем что такой книги нет */
        public String getInfo(String title){
            return "Книга найдена. Название: . Автор: . " +
                    "Доступна в читальном зале/для выдачи на дом." +
                    "Для выдачи доступна/пока не доступна";
        }
        // должна быть возможность взять книгу на дом, указав название
        public Book takeHome (String title){
            Book returnBook = null;
            // определяем есть ли книга в библиотеке и можно ли ее вызять и не взял ли ее кто то другой
            return returnBook;
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + Arrays.toString(books) +
                '}';
    }

    public Book[] getBooks() {
        return books;
    }
}