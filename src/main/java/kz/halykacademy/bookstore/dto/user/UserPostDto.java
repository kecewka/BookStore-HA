package kz.halykacademy.bookstore.dto.user;

import kz.halykacademy.bookstore.enums.Roles;

public class UserPostDto {
    private int id;
    private String login;
    private String password;
    private Roles role;
    private boolean isBlocked;

    public UserPostDto(){}

    public UserPostDto(int id, String login, String password, Roles role, boolean isBlocked) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.isBlocked = isBlocked;
    }

    public UserPostDto(int id, String login, String password, Roles role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.isBlocked = false;
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

    @Override
    public String toString() {
        return "UserPostDto{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", isBlocked=" + isBlocked +
                '}';
    }
}
