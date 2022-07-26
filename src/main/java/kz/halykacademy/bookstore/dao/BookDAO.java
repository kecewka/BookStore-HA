package kz.halykacademy.bookstore.dao;

import kz.halykacademy.bookstore.entity.Book;

import java.util.List;

public interface BookDAO {
    public List<Book> getAllBooks();

    public Book getBook(int id);

    public void saveBook(Book book);

    public void deleteBook(int id);
}
