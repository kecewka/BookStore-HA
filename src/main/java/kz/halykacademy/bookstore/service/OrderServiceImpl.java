package kz.halykacademy.bookstore.service;

import kz.halykacademy.bookstore.dao.OrderRepository;
import kz.halykacademy.bookstore.entity.Book;
import kz.halykacademy.bookstore.entity.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrder(int id) {
        Order order = null;
        Optional<Order> optional = orderRepository.findById(id);
        if (optional.isPresent()) {
            order = optional.get();
        }
        return order;
    }

    @Override
    public void saveOrder(Order order) {
        checkTotalPrice(order);
        checkDeletedBooks(order);
        checkBlockedUser(order);
        orderRepository.save(order);
    }

    @Override
    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }

    public void checkTotalPrice(Order order){
        double totalPrice = 0;
        for (Book b : order.getOrderedBooks()) {
            totalPrice += b.getPrice();
        }
        if (totalPrice > 10000) {
            throw new RuntimeException("Price is more than 10000, please lower price");
        }
    }

    public void checkDeletedBooks(Order order){
        for (Book b : order.getOrderedBooks()) {
            if (b.getDeleted_at() != null) {
                throw new RuntimeException("Trying to order deleted book");
            }
        }
    }

    public void checkBlockedUser(Order order){
        if(order.getUser().isBlocked()){
            throw new RuntimeException("Blocked user trying to order");
        }
    }
}
