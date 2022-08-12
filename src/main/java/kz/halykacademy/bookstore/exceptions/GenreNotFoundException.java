package kz.halykacademy.bookstore.exceptions;

public class GenreNotFoundException extends RuntimeException{
    public GenreNotFoundException(String message){
        super(message);
    }
}