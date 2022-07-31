package kz.halykacademy.bookstore.controller;

import kz.halykacademy.bookstore.dto.BookDto;
import kz.halykacademy.bookstore.dto.BookPostDto;
import kz.halykacademy.bookstore.mapper.MapStructMapper;
import kz.halykacademy.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private MapStructMapper mapStructMapper;


    @GetMapping("/books")
    public List<BookDto> showAllBooks() {
        List<BookDto> allBooks = mapStructMapper.bookToDtos(bookService.getAllBooks());

        return allBooks;
    }

    @GetMapping("/books/{id}")
    public BookDto getBook(@PathVariable int id) {
        BookDto book = mapStructMapper.bookToDto(bookService.getBook(id));

        return book;
    }

    @PostMapping("/books")
    public BookPostDto addNewBook(@RequestBody BookPostDto book) {
        bookService.saveBook(mapStructMapper.dtoToBook(book));

        return book;
    }

    @PutMapping("/books")
    public BookPostDto updateBook(@RequestBody BookPostDto book) {
        bookService.saveBook(mapStructMapper.dtoToBook(book));

        return book;
    }

    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable int id){
        BookDto book = mapStructMapper.bookToDto(bookService.getBook(id));
        bookService.deleteBook(id);
        return "book: " + book.getTitle() + " was deleted";
    }

    @GetMapping("/books/")
    public List<BookDto> getBookByTitle(@RequestParam String title){
        List<BookDto> books = mapStructMapper.bookToDtos(bookService.findAllByTitleContaining(title));
        return books;
    }
}
