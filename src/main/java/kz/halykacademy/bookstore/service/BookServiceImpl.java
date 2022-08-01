package kz.halykacademy.bookstore.service;

import kz.halykacademy.bookstore.dao.BookRepository;
import kz.halykacademy.bookstore.dto.GenreSlimDto;
import kz.halykacademy.bookstore.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;


    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(int id) {
        Book book = null;
        Optional<Book> optional = bookRepository.findById(id);
        if (optional.isPresent()) {
            book = optional.get();
        }
        return book;
    }

    @Override
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findAllByTitleContaining(String titlepart) {
        List<Book> books = bookRepository.findAllByTitleContaining(titlepart);
        return books;
    }

    @Override
    public List<Book> findAllByGenresList(List<String> genres) {
        List<Book> books = bookRepository.findAllByGenresList(genres);
        return books;
    }
}
