package kz.halykacademy.bookstore.controller;

import kz.halykacademy.bookstore.entity.Book;
import kz.halykacademy.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping("/books")
    public List<Book> showAllBooks() {
        List<Book> allBooks = bookService.getAllBooks();

        return allBooks;
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable int id) {
        Book book = bookService.getBook(id);

        return book;
    }

    @PostMapping("/books")
    public Book addNewBook(@RequestBody Book book) {
        bookService.saveBook(book);

        return book;
    }

    @PutMapping("/books/")
    public Book updateBook(@RequestBody Book book) {
        bookService.saveBook(book);

        return book;
    }

    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable int id){
        Book book = bookService.getBook(id);
        bookService.deleteBook(id);
        return "book: " + book.getTitle() + " was deleted";
    }

}
