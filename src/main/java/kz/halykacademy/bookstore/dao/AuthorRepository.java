package kz.halykacademy.bookstore.dao;

import kz.halykacademy.bookstore.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    public List<Author> findAllByNameContaining(String name);

}
