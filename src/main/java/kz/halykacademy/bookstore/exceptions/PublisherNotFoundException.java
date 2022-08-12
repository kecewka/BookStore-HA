package kz.halykacademy.bookstore.exceptions;

public class PublisherNotFoundException extends RuntimeException{
    public PublisherNotFoundException(String message){
        super(message);
    }
}
