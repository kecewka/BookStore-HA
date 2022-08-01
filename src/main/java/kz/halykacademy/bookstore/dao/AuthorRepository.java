package kz.halykacademy.bookstore.dao;

import kz.halykacademy.bookstore.entity.Author;
import kz.halykacademy.bookstore.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    public List<Author> findAllByNameContaining(String name);

    @Query(value = "select g.* from authors a " +
            "join book_author ba on a.id = ba.author_id " +
            "join book_genre bg on ba.book_id = bg.book_id " +
            "join genres g on bg.genre_id = g.id where a.id = :id ", nativeQuery = true)
//    @Query("SELECT g from Author a join a.writtenBooksList ba join ba.genresList bg join Genre g")
    List<Genre> findGenresOfAuthors(int id);
}
