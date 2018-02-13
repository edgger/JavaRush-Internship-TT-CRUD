package guru.optimal.crud.service;

import guru.optimal.crud.entity.Book;

import java.util.List;

public interface BookService {
    public void addBook(Book book);
    public void updateBook(Book book);
    public List<Book> listBooks();
    public Book getBookById(int id);
    public void removeBook(int id);
}
