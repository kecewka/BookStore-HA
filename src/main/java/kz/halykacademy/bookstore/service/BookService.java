package kz.halykacademy.bookstore.service;

import kz.halykacademy.bookstore.entity.Book;

import java.util.List;

public interface BookService {
    public List<Book> getAllBooks();

    public Book getBook(int id);

    public void saveBook(Book book);

    public void deleteBook(int id);
}
