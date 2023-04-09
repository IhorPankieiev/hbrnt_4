package ex_003_hibernate_get_and_insert;

import ex_003_hibernate_get_and_insert.entity.Book;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class BookHelper {

    private SessionFactory sessionFactory;

    public BookHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Book> getBooksList(){
        Session session = sessionFactory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Book.class);
        Query query = session.createQuery(cq);
        List<Book> allBooks = query.getResultList();

        session.close();

        return allBooks;
    }

    public Book getById(long id){
        Session session = sessionFactory.openSession();

        Book book = session.get(Book.class, id);

        session.close();

        return book;
    }

    public Book addBook(Book book){
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.save(book);

        session.getTransaction().commit();

        session.close();

        return book;

    }
}
