package kz.halykacademy.bookstore.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<OrderIncorrectData> handleException(DeletedBookException exception) {
        OrderIncorrectData data = new OrderIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<OrderIncorrectData> handleException(NotOrderOwnerException exception) {
        OrderIncorrectData data = new OrderIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<OrderIncorrectData> handleException(BlockedUserException exception) {
        OrderIncorrectData data = new OrderIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<OrderIncorrectData> handleException(LockedException exception) {
        OrderIncorrectData data = new OrderIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<OrderIncorrectData> handleException(UsernameNotFoundException exception) {
        OrderIncorrectData data = new OrderIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<OrderIncorrectData> handleException(AuthorNotFoundException exception) {
        OrderIncorrectData data = new OrderIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<OrderIncorrectData> handleException(BookNotFoundException exception) {
        OrderIncorrectData data = new OrderIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<OrderIncorrectData> handleException(UserNotFoundException exception) {
        OrderIncorrectData data = new OrderIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<OrderIncorrectData> handleException(GenreNotFoundException exception) {
        OrderIncorrectData data = new OrderIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<OrderIncorrectData> handleException(PublisherNotFoundException exception) {
        OrderIncorrectData data = new OrderIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<OrderIncorrectData> handleException(OrderNotFoundException exception) {
        OrderIncorrectData data = new OrderIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }
}
