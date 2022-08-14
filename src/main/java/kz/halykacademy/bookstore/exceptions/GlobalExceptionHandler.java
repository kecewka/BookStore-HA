package kz.halykacademy.bookstore.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ReturnMessage> handleException(DeletedBookException exception) {
        ReturnMessage data = new ReturnMessage();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ReturnMessage> handleException(NotOrderOwnerException exception) {
        ReturnMessage data = new ReturnMessage();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ReturnMessage> handleException(BlockedUserException exception) {
        ReturnMessage data = new ReturnMessage();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ReturnMessage> handleException(LockedException exception) {
        ReturnMessage data = new ReturnMessage();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler
    public ResponseEntity<ReturnMessage> handleException(UsernameNotFoundException exception) {
        ReturnMessage data = new ReturnMessage();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ReturnMessage> handleException(AuthorNotFoundException exception) {
        ReturnMessage data = new ReturnMessage();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ReturnMessage> handleException(BookNotFoundException exception) {
        ReturnMessage data = new ReturnMessage();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ReturnMessage> handleException(UserNotFoundException exception) {
        ReturnMessage data = new ReturnMessage();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ReturnMessage> handleException(GenreNotFoundException exception) {
        ReturnMessage data = new ReturnMessage();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ReturnMessage> handleException(PublisherNotFoundException exception) {
        ReturnMessage data = new ReturnMessage();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ReturnMessage> handleException(OrderNotFoundException exception) {
        ReturnMessage data = new ReturnMessage();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ReturnMessage> handleException(AuthenticationException exception) {
        ReturnMessage data = new ReturnMessage();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler
    public ResponseEntity<ReturnMessage> handleException(InsufficientAuthenticationException exception) {
        ReturnMessage data = new ReturnMessage();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.FORBIDDEN);
    }
}
