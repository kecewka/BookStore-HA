package kz.halykacademy.bookstore.exceptions;

import org.springframework.security.core.AuthenticationException;

public class UsernameNotFoundException extends AuthenticationException {
    public UsernameNotFoundException(String message) {
        super(message);
    }

}
