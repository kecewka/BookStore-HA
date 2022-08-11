package kz.halykacademy.bookstore.exceptions;

public class NotOrderOwnerException extends RuntimeException{
    public NotOrderOwnerException(String message){
        super(message);
    }
}
