package kz.halykacademy.bookstore.dto.order;

import kz.halykacademy.bookstore.dto.user.UserSlimDto;
import kz.halykacademy.bookstore.dto.book.BookSlimDto;
import kz.halykacademy.bookstore.enums.Statuses;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDto {
    private int id;
    private UserSlimDto user;
    private List<BookSlimDto> orderedBooks;
    private Statuses status;
    private LocalDateTime orderTime;

    private OrderDto(){}

    public OrderDto(int id, UserSlimDto user, List<BookSlimDto> orderedBooks, Statuses status, LocalDateTime orderTime) {
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

    public UserSlimDto getUser() {
        return user;
    }

    public void setUser(UserSlimDto user) {
        this.user = user;
    }

    public List<BookSlimDto> getOrderedBooks() {
        return orderedBooks;
    }

    public void setOrderedBooks(List<BookSlimDto> orderedBooks) {
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
        return "OrderDto{" +
                "id=" + id +
                ", user=" + user +
                ", orderedBooks=" + orderedBooks +
                ", status=" + status +
                ", orderTime=" + orderTime +
                '}';
    }
}
