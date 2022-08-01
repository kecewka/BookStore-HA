package kz.halykacademy.bookstore.service;

import kz.halykacademy.bookstore.entity.Author;
import kz.halykacademy.bookstore.entity.Genre;


import java.util.List;

public interface AuthorService {
    public List<Author> getAllAuthors();

    public Author getAuthor(int id);

    public void saveAuthor(Author author);

    public void deleteAuthor(int id);

    public List<Author> findAllByNameContaining(String name);

    List<Genre> findGenresOfAuthor(int id);
}
