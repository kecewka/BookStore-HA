package kz.halykacademy.bookstore.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import kz.halykacademy.bookstore.enums.Statuses;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = {/*CascadeType.PERSIST,*/ CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "user_id", nullable=false)
    private User user;

    @ManyToMany
    @JoinTable(name = "order_book"
            , joinColumns = @JoinColumn(name = "order_id")
            , inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> orderedBooks;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private Statuses status;

    @Column(name = "ordered_at")
    private LocalDateTime orderTime;


    public Order() {
    }

    public Order(int id, User user, List<Book> orderedBooks, Statuses status, LocalDateTime orderTime) {
        this.id = id;
        this.user = user;
        this.orderedBooks = orderedBooks;
        this.status = status;
        this.orderTime = orderTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Book> getOrderedBooks() {
        return orderedBooks;
    }

    public void setOrderedBooks(List<Book> orderedBooks) {
        this.orderedBooks = orderedBooks;
    }

    public Statuses getStatus() {
        return status;
    }

    public void setStatus(Statuses status) {
        this.status = status;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", orderedBooks=" + orderedBooks +
                ", status=" + status +
                ", orderTime=" + orderTime +
                '}';
    }
}
