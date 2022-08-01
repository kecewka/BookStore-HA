package kz.halykacademy.bookstore.dao;

import kz.halykacademy.bookstore.entity.Author;
import kz.halykacademy.bookstore.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    public List<Author> findAllByNameContaining(String name);

    @Query(value = "select g.name from authors a " +
            "join book_author ba on a.id = ba.author_id " +
            "join book_genre bg on ba.book_id = bg.book_id " +
            "join genres g on bg.genre_id = g.id where a.id = :id ", nativeQuery = true)

    List<String> findGenresOfAuthors(Integer id);

//    @Query(value = "select a.surname, a.name, a.patronymicname from authors a" +
//            "join book_author ba on a.id = ba.author_id" +
//            "join book_genre bg on ba.book_id = bg.book_id" +
//            "join genres g on bg.genre_id = g.id where g.name in (:genres)", nativeQuery = true)
    @Query(value = "select a from Author a join a.writtenBooksList ab join ab.genresList ag join ag.bookList")
    List<Author> findAllByGenreList(List<String> genres);
}
