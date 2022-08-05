package kz.halykacademy.bookstore.dao;

import kz.halykacademy.bookstore.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {


}
