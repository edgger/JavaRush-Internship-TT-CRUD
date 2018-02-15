package guru.optimal.crud.service;

import guru.optimal.crud.dao.BookDao;
import guru.optimal.crud.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookDao bookDao;

    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    @Transactional
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> listBooks() {
        return bookDao.listBooks();
    }

    @Override
    @Transactional(readOnly = true)
    public Book getBookById(int id) {
        return bookDao.getBookById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> getBooksRange(int start) {
        return bookDao.getBooksRange(start);
    }

    @Override
    @Transactional
    public void removeBook(int id) {
        bookDao.removeBook(id);
    }

    @Override
    @Transactional(readOnly = true)
    public long getBooksTotalCount() {
        return bookDao.getBooksTotalCount();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> getBooksByField(String field, String value) {
        String fieldLC = field.toLowerCase();
        if ("id".equals(fieldLC)){
            try {
                int intValue = Integer.parseInt(value);
                return Collections.singletonList(getBookById(intValue));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Wrong value for ID");
            }
        } else if ("title".equals(fieldLC)||"author".equals(fieldLC)){
            return bookDao.getBooksByField(field, value);
        } else {
            throw new IllegalArgumentException("Wrong field name");
        }
    }
}
