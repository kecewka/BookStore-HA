package kz.halykacademy.bookstore.dao;

import kz.halykacademy.bookstore.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

}
