package kz.halykacademy.bookstore.service;

import kz.halykacademy.bookstore.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public User getUser(int id);

    public void saveUser(User user);

    public void deleteUser(int id);

    public List<User> findAllNotBlockedStatus();
}
