package kz.halykacademy.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("kz.halykacademy.bookstore.dao.bookDAO")
public class BookStoreHaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookStoreHaApplication.class, args);
    }

}
