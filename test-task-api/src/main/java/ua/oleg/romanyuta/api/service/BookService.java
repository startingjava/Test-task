package ua.oleg.romanyuta.api.service;

import ua.oleg.romanyuta.domain.Book;
import java.util.List;

public interface BookService {

    Book getBook(Long id);

    List<Book> getAllBooks();

    Book createBook(Book book);

    Book updateBook(Book book);
}
