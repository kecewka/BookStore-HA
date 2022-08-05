package kz.halykacademy.bookstore.service;

import kz.halykacademy.bookstore.entity.Order;

import java.util.List;

public interface OrderService {

    public List<Order> getAllOrders();

    public Order getOrder(int id);

    public void saveOrder(Order order);

    public void deleteOrder(int id);
}
