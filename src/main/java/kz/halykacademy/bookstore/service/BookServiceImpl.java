package kz.halykacademy.bookstore.service;

import kz.halykacademy.bookstore.dao.BookRepository;
import kz.halykacademy.bookstore.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;


    @Override
    @Transactional
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    @Transactional
    public Book getBook(int id) {
        Book book = null;
        Optional<Book> optional = bookRepository.findById(id);
        if (optional.isPresent()) {
            book = optional.get();
        }
        return book;
    }

    @Override
    @Transactional
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    @Transactional
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }
}
