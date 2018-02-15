package guru.optimal.crud.dao;

import guru.optimal.crud.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(book);
    }

    @Override
    public void updateBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.update(book);
    }

    @Override
    public List<Book> listBooks() {
        Session session = sessionFactory.getCurrentSession();
        List<Book> booksList = session.createQuery("from Book").list();
        return booksList;
    }

    @Override
    public Book getBookById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Book.class, id);
    }

    @Override
    public List<Book> getBooksRange(int start) {
        Session session = sessionFactory.getCurrentSession();
        List<Book> booksList = session.createQuery("from Book")
                .setFirstResult(start)
                .setMaxResults(10)
                .list();
        return booksList;
    }

    @Override
    public void removeBook(int id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = session.load(Book.class, id);
        if (book!=null){
            session.delete(book);
        }
    }

    @Override
    public long getBooksTotalCount() {
        Session session = sessionFactory.getCurrentSession();
        Long countResults = (Long) session.createQuery("select count (b.id) from Book b").uniqueResult();
        return countResults;
    }

    @Override
    public List<Book> getBooksByField(String field, String value) {
        Session session = sessionFactory.getCurrentSession();
        List<Book> booksList = session.createQuery("from Book b where b."+field+" = :fieldValue")
                .setParameter("fieldValue",value).list();
        return booksList;
    }
}
