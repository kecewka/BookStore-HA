package kz.halykacademy.bookstore.dao;

import kz.halykacademy.bookstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select * from users where is_blocked = false", nativeQuery = true)
    public List<User> findAllNotBlockedStatus();
}
