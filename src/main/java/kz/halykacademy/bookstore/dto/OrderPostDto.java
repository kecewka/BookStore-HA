package kz.halykacademy.bookstore.dto;

import kz.halykacademy.bookstore.enums.Statuses;

import java.time.LocalDateTime;
import java.util.List;

public class OrderPostDto {
    private int id;
    private Statuses status;
    private LocalDateTime orderTime;


    public OrderPostDto(){}

    public OrderPostDto(int id, Statuses status, LocalDateTime orderTime) {
        this.id = id;
        this.status = status;
        this.orderTime = orderTime;
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

    @Override
    public String toString() {
        return "OrderPostDto{" +
                "id=" + id +
                ", status=" + status +
                ", orderTime=" + orderTime +
                '}';
    }
}
