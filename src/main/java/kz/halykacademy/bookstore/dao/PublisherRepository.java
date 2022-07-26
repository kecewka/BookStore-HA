package kz.halykacademy.bookstore.dao;

import kz.halykacademy.bookstore.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
    public List<Publisher> findAllByNameContaining(String name);

}
