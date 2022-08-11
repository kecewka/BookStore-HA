package kz.halykacademy.bookstore.exceptions;

import kz.halykacademy.bookstore.entity.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OrderGlobalExceptionHandler {

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
}
