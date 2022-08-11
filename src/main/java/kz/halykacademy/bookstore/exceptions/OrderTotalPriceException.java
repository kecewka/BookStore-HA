package kz.halykacademy.bookstore.exceptions;

public class OrderTotalPriceException extends RuntimeException {
    public OrderTotalPriceException(String message) {
        super(message);
    }
}
