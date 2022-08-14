package kz.halykacademy.bookstore.controller;

import kz.halykacademy.bookstore.dto.author.AuthorFullDto;
import kz.halykacademy.bookstore.dto.author.AuthorPostDto;
import kz.halykacademy.bookstore.dto.genre.GenreSlimDto;
import kz.halykacademy.bookstore.mapper.MapStructMapper;
import kz.halykacademy.bookstore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class AuthorController {

    private final AuthorService authorService;
    private final MapStructMapper mapStructMapper;

    @Autowired
    public AuthorController(AuthorService authorService, MapStructMapper mapStructMapper) {
        this.authorService = authorService;
        this.mapStructMapper = mapStructMapper;
    }

    @GetMapping("/authors")
    public List<AuthorFullDto> showAllAuthors() {
        List<AuthorFullDto> allAuthors = mapStructMapper.authorToDtos(authorService.getAllAuthors());
        List<String> genre_names = new ArrayList<>();

        for (AuthorFullDto a : allAuthors) {
            List<GenreSlimDto> genres = new ArrayList<>();
            genre_names = authorService.findGenresOfAuthor(a.getId());
            converter(genre_names, genres);
            removeDuplicateGenres(genres);
            a.setGenresList(genres);

        }
        return allAuthors;
    }

    @GetMapping("/authors/{id}")
    public AuthorFullDto getAuthor(@PathVariable int id) {
        AuthorFullDto author = mapStructMapper.authorToDto(authorService.getAuthor(id));
        List<String> genre_names = authorService.findGenresOfAuthor(id);
        List<GenreSlimDto> genres = new ArrayList<>(genre_names.size());
        converter(genre_names, genres);
        removeDuplicateGenres(genres);
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

    @GetMapping(value = "/authors/", params = "genres")
    public List<AuthorFullDto> findAllByGenreList(@RequestParam List<String> genres) {
        List<AuthorFullDto> authors = mapStructMapper.authorToDtos(authorService.findAllByGenreList(genres));
        List<String> genre_names = new ArrayList<>();
        List<GenreSlimDto> genresList;
        for (AuthorFullDto a : authors) {
            genresList = new ArrayList<>();
            genre_names = authorService.findGenresOfAuthor(a.getId());
            converter(genre_names, genresList);
            removeDuplicateGenres(genresList);
            a.setGenresList(genresList);
        }
        authors = removeDuplicateAuthors(authors);
        return authors;
    }

    public List<GenreSlimDto> converter(List<String> genre_names, List<GenreSlimDto> genres) {
        for (String name : genre_names) {
            GenreSlimDto newGenre = new GenreSlimDto(name);

            genres.add(newGenre);

        }
        return genres;
    }

    public List<GenreSlimDto> removeDuplicateGenres(List<GenreSlimDto> genres) {
        for (int i = 0; i < genres.size() - 1; i++) {
            for (int j = i + 1; j < genres.size(); j++) {
                if (genres.get(i).getName().equals(genres.get(j).getName())) {
                    genres.remove(j);
                }
            }
        }
        return genres;
    }

    public List<AuthorFullDto> removeDuplicateAuthors(List<AuthorFullDto> authors) {
        for (int i = 0; i < authors.size() - 1; i++) {
            for (int j = i + 1; j < authors.size(); j++) {
                if (authors.get(i).getId() == authors.get(j).getId()) {
                    authors.remove(j);
                }
            }
        }

        return authors;
    }
}
