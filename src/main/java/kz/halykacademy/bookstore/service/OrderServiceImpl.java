package kz.halykacademy.bookstore.service;

import kz.halykacademy.bookstore.dao.OrderRepository;
import kz.halykacademy.bookstore.dao.UserRepository;
import kz.halykacademy.bookstore.entity.Book;
import kz.halykacademy.bookstore.entity.Order;

import kz.halykacademy.bookstore.entity.User;
import kz.halykacademy.bookstore.enums.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }


    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @Override
    public Order getOrder(int id) {
        Order order = null;
        Optional<Order> optional = orderRepository.findById(id);
        if (optional.isPresent()) {
            order = optional.get();
        }
        return order;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @Override
    public void saveOrder(Order order) {
        checkTotalPrice(order);
        checkDeletedBooks(order);
        checkBlockedUser(order);
        checkUserRoleById(order);
        changeOwnOrder(order);
        orderRepository.save(order);
    }

    @Override
    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }

    private void checkTotalPrice(Order order) {
        double totalPrice = 0;
        for (Book b : order.getOrderedBooks()) {
            totalPrice += b.getPrice();
        }
        if (totalPrice > 10000) {
            throw new RuntimeException("Price is more than 10000, please lower price");
        }
    }

    private void checkDeletedBooks(Order order) {
        for (Book b : order.getOrderedBooks()) {
            if (b.getDeleted_at() != null) {
                throw new RuntimeException("Trying to order deleted book");
            }
        }
    }

    private void checkBlockedUser(Order order) {
        if (order.getUser().isBlocked()) {
            throw new RuntimeException("Blocked user trying to order");
        }
    }

    private void checkUserRoleById(Order order) {
        User user = null;
        Optional<User> optional = userRepository.findById(order.getUser().getId());
        if (optional.isPresent()) {
            user = optional.get();
        }

        if (user.getRole() == Roles.ROLE_USER) {
            if (getOrder(order.getId()).getStatus() != order.getStatus()) {
                order.setStatus(getOrder(order.getId()).getStatus());
            }
        }
    }

    private void changeOwnOrder(Order order) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        if(!order.getUser().getLogin().equals(username)){
            throw new RuntimeException("Trying to modify not own order");
        }
    }
}
