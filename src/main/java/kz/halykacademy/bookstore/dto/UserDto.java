package kz.halykacademy.bookstore.dto;

import kz.halykacademy.bookstore.enums.Roles;

import java.util.List;

public class UserDto {
    private int id;
    private String login;
    private String password;
    private Roles role;
    private boolean isBlocked;
    private List<OrderSlimDto> orders;


    public UserDto(){}
    public UserDto(int id, String login, String password, Roles role, boolean isBlocked, List<OrderSlimDto> orders) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.isBlocked = isBlocked;
        this.orders = orders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public List<OrderSlimDto> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderSlimDto> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", isBlocked=" + isBlocked +
                ", orders=" + orders +
                '}';
    }
}
