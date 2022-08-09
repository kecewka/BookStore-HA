package kz.halykacademy.bookstore.enums;

public enum Statuses {
    CREATED("CREATED"),
    PROCESSING("PROCESSING"),
    COMPLETED("COMPLETED"),
    CANCELLED("CANCELLED");

    private String name;

    public String getName() {
        return name;
    }
    Statuses(String name) {
        this.name = name;
    }
}
