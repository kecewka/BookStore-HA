package kz.halykacademy.bookstore.dao;

import kz.halykacademy.bookstore.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
