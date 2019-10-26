package Library;

public class Library {
    private Book[] books = new Book[10];

    // в библиотеку можно добавить одну книгу

    public void addBook(Book newBook) {
        if (this.books[this.books.length - 1] != null) {
            System.out.println("Библиотека заполнена, добавить книги нельзя");
        }
        else {
        for (int i = 0; i < this.books.length; i++) {
            if (this.books[i] == null) {
                this.books[i] = newBook;
                if (i == this.books.length - 1) {
                    System.out.println("Книга добавлена, но место в библиотеке закончилось");
                }
                break;
            }
            }
        }
    }

    // в библиотеку можно добавить сразу несколько книг

    public void addBook(Book ...newBooks) { // при передаче в метод нескольких книг в методе newBooks станет массивом
        if (this.books[this.books.length - 1] != null) {
            System.out.println("Библиотека заполнена, добавить книги нельзя");
        }
        else {
        for (int i = 0; i < this.books.length; i++) {
            if (this.books[i] == null && this.books.length - i >= newBooks.length) {
                System.arraycopy(newBooks, 0, this.books, i, newBooks.length);
                if (this.books.length - i == newBooks.length){
                    System.out.println("Книги добавлены, но место в библиотеке закончилось");
                }
                break;
            }
            else if (this.books[i] == null && this.books.length - i < newBooks.length) {
                System.arraycopy(newBooks, 0, this.books, i, this.books.length - i);
                System.out.println("В библиотеке закончилось место, добавлено только " + (this.books.length - i) + " книг");
                break;
            }
        }
        }
    }
        /* еще один способ копирования
        for (int i = 0; i < newBooks.length; i++) {
            for (int j = 0; j < this.books.length; j++) {
                if (this.books[j] == null) {
                    this.books[j] = newBooks[i];
                    break;
                }
            }
        }
    }
    */

        /* должна быть возможность получать информацию по книге, указав ее название
        (получаемая информация: автор, название, можно ли забрать домой, доступна ли книга)
        если книга не найдена сообщаем что такой книги нет */

        public String getInfo(String title) { // String это тип объекта который возвращает метод
            String s = "";
            boolean isFind = false;
            for (int i = 0; i < this.books.length; i++) {
                if (this.books[i] != null && this.books[i].getTitle().equals(title)) {
                    s = "Книга найдена. \nНазвание: " + this.books[i].getTitle() + ".\n" + "Автор: " +
                            this.books[i].getAuthor() + ".\n" + this.books[i].IsAvailableTxt() +
                            this.books[i].IsForHomeTxt() + this.books[i].IsTakenHomeTxt();
                    isFind = true;
                    break;
                }
            }
                if (!isFind) {
                    s = "Книга не найдена";
                }
            return s;
            }
        // должна быть возможность взять книгу на дом, указав название
        public Book takeHome (String title) {
            Book returnBook = null;
            for (int i = 0; i < this.books.length; i++) {
                if (this.books[i] != null && this.books[i].getTitle().equals(title) && this.books[i].getIsForHome() &&
                        !this.books[i].getIsTakenHome()) {
                    returnBook = this.books[i];
                    this.books[i].setIsTakenHome(true);
                }

                // определяем есть ли книга в библиотеке и можно ли ее вызять и не взял ли ее кто то другой

            }
            return returnBook;
        }
    public Book[] getBooks() {
        return books;
    }
}