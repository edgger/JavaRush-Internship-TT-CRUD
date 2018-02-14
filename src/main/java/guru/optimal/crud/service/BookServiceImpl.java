package guru.optimal.crud.service;

import guru.optimal.crud.dao.BookDao;
import guru.optimal.crud.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
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
    @Transactional
    public void removeBook(int id) {
        bookDao.removeBook(id);
    }
}
