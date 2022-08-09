package kz.halykacademy.bookstore.dao;

import kz.halykacademy.bookstore.entity.Book;
import kz.halykacademy.bookstore.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    public List<Book> findAllByTitleContaining(String titlepart);
    @Query(value = "select * from books where id = :id", nativeQuery = true)
    public Book findAnyBook(int id);

    @Query(value = "SELECT b from Book b join b.genresList g where g.name in (:genres)")
    public List<Book> findAllByGenresList(List<String> genres);
}
