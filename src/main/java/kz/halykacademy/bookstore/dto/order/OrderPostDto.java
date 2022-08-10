package kz.halykacademy.bookstore.dto.order;

import kz.halykacademy.bookstore.dto.user.UserIdDto;
import kz.halykacademy.bookstore.enums.Statuses;

import java.time.LocalDateTime;
import java.util.List;

public class OrderPostDto {
    private int id;
    private Statuses status;
    private LocalDateTime orderTime;

    private UserIdDto user;

    private List<Integer> orderedBooks;


    public OrderPostDto(){}

    public OrderPostDto(int id, Statuses status,LocalDateTime orderTime, UserIdDto user, List<Integer> orderedBooks) {
        this.id = id;
        this.status = status;
        this.orderTime = orderTime;
        this.user = user;
        this.orderedBooks = orderedBooks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public UserIdDto getUser() {
        return user;
    }

    public void setUser(UserIdDto user) {
        this.user = user;
    }

    public List<Integer> getOrderedBooks() {
        return orderedBooks;
    }

    public void setOrderedBooks(List<Integer> orderedBooks) {
        this.orderedBooks = orderedBooks;
    }




    @Override
    public String toString() {
        return "OrderPostDto{" +
                "id=" + id +
                ", status=" + status +
                ", orderTime=" + orderTime +
                '}';
    }
}
