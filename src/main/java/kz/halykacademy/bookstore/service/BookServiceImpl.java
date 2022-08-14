package kz.halykacademy.bookstore.service;

import kz.halykacademy.bookstore.dao.BookRepository;
import kz.halykacademy.bookstore.entity.Book;
import kz.halykacademy.bookstore.exceptions.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @Override
    public Book getBook(int id) {
        Book book = null;
        Optional<Book> optional = bookRepository.findById(id);
        if (optional.isPresent()) {
            book = optional.get();
        }

        if(optional.isEmpty()){
            throw new BookNotFoundException("Book with ID " + id + " not found");
        }
        return book;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @Override
    public List<Book> findAllByTitleContaining(String titlepart) {
        List<Book> books = bookRepository.findAllByTitleContaining(titlepart);
        if(books.isEmpty()){
            throw new BookNotFoundException("No books were found matching the criteria");
        }
        return books;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @Override
    public List<Book> findAllByGenresList(List<String> genres) {
        List<Book> books = bookRepository.findAllByGenresList(genres);
        if(books.isEmpty()){
            throw new BookNotFoundException("No books were found matching the criteria");
        }
        return books;
    }
}
