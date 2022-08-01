package kz.halykacademy.bookstore.controller;

import kz.halykacademy.bookstore.dto.AuthorFullDto;
import kz.halykacademy.bookstore.dto.AuthorPostDto;
import kz.halykacademy.bookstore.dto.GenreSlimDto;
import kz.halykacademy.bookstore.entity.Genre;
import kz.halykacademy.bookstore.mapper.MapStructMapper;
import kz.halykacademy.bookstore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class AuthorController {

    @Autowired
    private AuthorService authorService;
    @Autowired
    private MapStructMapper mapStructMapper;

    @GetMapping("/authors")
    public List<AuthorFullDto> showAllAuthors() {
        List<AuthorFullDto> allAuthors = mapStructMapper.authorToDtos(authorService.getAllAuthors());
        return allAuthors;
    }

    @GetMapping("/authors/{id}")
    public AuthorFullDto getAuthor(@PathVariable int id) {
        AuthorFullDto author = mapStructMapper.authorToDto(authorService.getAuthor(id));
        List<String> genre_names = authorService.findGenresOfAuthor(id);
        List<GenreSlimDto> genres = new ArrayList<>(genre_names.size());
        for (String name : genre_names) {
            GenreSlimDto newGenre = new GenreSlimDto(name);
            if (!genres.contains(new GenreSlimDto()))
                genres.add(newGenre);
        }
        author.setGenresList(genres);
        return author;
    }

    @PostMapping("/authors")
    public AuthorPostDto addNewAuthor(@RequestBody AuthorPostDto author) {
        authorService.saveAuthor(mapStructMapper.dtoToAuthor(author));
        return author;
    }

    @PutMapping("/authors")
    public AuthorPostDto updateAuthor(@RequestBody AuthorPostDto author) {
        authorService.saveAuthor(mapStructMapper.dtoToAuthor(author));
        return author;
    }

    @DeleteMapping("/authors/{id}")
    public String deleteAuthor(@PathVariable int id) {
        AuthorFullDto author = mapStructMapper.authorToDto(authorService.getAuthor(id));
        authorService.deleteAuthor(id);
        return "author: " + author.getName() + "was deleted";
    }

    @GetMapping("/authors/")
    public List<AuthorFullDto> findAllByNameContaining(@RequestParam String name) {
        List<AuthorFullDto> authors = mapStructMapper.authorToDtos(authorService.findAllByNameContaining(name));
        return authors;
    }
}
