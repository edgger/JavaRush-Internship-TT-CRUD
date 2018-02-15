package guru.optimal.crud.dao;

import guru.optimal.crud.entity.Book;

import java.util.List;

public interface BookDao {

    public void addBook(Book book);
    public void updateBook(Book book);
    public List<Book> listBooks();
    public Book getBookById(int id);
    public void removeBook(int id);
    public List<Book> getBooksRange(int start);
    public long getBooksTotalCount();

    List<Book> getBooksByField(String field, String value);
}
