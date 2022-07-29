package kz.halykacademy.bookstore.dao;

import kz.halykacademy.bookstore.entity.Book;
import kz.halykacademy.bookstore.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    public List<Book> findAllByTitleContaining(String titlepart);

   // public List<Book> findAllByGenresList(List<Genre> genres);
}
