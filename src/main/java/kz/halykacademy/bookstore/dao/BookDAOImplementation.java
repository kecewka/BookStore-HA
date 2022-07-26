package kz.halykacademy.bookstore.dao;

import kz.halykacademy.bookstore.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BookDAOImplementation implements BookDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Book> getAllBooks() {
        //EntityManager is a wrapper(обёртка) of session.
        Query query = entityManager.createQuery("from Book");
        List<Book> allBooks = query.getResultList();

        return allBooks;
    }

    @Override
    public Book getBook(int id) {
        Book book = entityManager.find(Book.class, id);
        return book;
    }

    @Override
    public void saveBook(Book book) {
        entityManager.merge(book);
    }

    @Override
    public void deleteBook(int id) {
        Query query = entityManager.createQuery("delete from Book where id =: bookId");
        query.setParameter("bookId", id);
        query.executeUpdate();
    }
}
