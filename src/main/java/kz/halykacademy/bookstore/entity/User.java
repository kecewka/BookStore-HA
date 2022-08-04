package kz.halykacademy.bookstore.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import kz.halykacademy.bookstore.enums.Roles;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private double password;

    @Column(name = "price")
    private double price;
    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private Roles role;

    @Column(name = "is_blocked")
    private boolean isBlocked;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    public User() {
    }

    public User(int id, String login, double password, double price, Roles role, boolean isBlocked) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.price = price;
        this.role = role;
        this.isBlocked = isBlocked;
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

    public double getPassword() {
        return password;
    }

    public void setPassword(double password) {
        this.password = password;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password=" + password +
                ", price=" + price +
                ", role=" + role +
                ", isBlocked=" + isBlocked +
                '}';
    }
}
