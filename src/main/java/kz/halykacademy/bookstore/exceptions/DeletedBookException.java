package kz.halykacademy.bookstore.exceptions;

public class DeletedBookException extends RuntimeException{
    public DeletedBookException(String message){
        super(message);
    }
}
