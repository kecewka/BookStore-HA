package kz.halykacademy.bookstore.enums;

public enum Roles {
    USER("USER"),
    ADMIN("ADMIN");

    private String name;

    public String getName() {
        return name;
    }

    Roles(String name) {this.name = name;}
}
