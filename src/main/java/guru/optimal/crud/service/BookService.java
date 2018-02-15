package guru.optimal.crud.service;

import guru.optimal.crud.entity.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookService {
    public void addBook(Book book);
    public void updateBook(Book book);
    public List<Book> listBooks();
    public Book getBookById(int id);
    public void removeBook(int id);
    public List<Book> getBooksRange(int start);
    public long getBooksTotalCount();

    @Transactional(readOnly = true)
    List<Book> getBooksByField(String field, String value);
}
