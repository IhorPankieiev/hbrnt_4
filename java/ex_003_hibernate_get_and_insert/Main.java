package ex_003_hibernate_get_and_insert;

import ex_003_hibernate_get_and_insert.entity.Author;
import ex_003_hibernate_get_and_insert.entity.Book;

public class Main {

    public static void main(String[] args) {
        AuthorHelper ah = new AuthorHelper();
        BookHelper bh = new BookHelper();

        Author author = new Author();
        author.setName("John Steinbeck");
        ah.addAuthor(author);

        Book book = new Book();
        book.setName("East of Eden");
        book.setAuthor(author);

        bh.addBook(book);

    }

}
