package kz.halykacademy.bookstore.service;

import kz.halykacademy.bookstore.dao.UserRepository;
import kz.halykacademy.bookstore.entity.User;
import kz.halykacademy.bookstore.security.UserCredentialsDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCredentialsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserCredentialsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty())
            throw new UsernameNotFoundException("Not found");

        return new UserCredentialsDetails(user.get());
    }
}
