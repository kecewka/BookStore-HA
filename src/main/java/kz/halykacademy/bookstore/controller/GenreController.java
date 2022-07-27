package kz.halykacademy.bookstore.controller;

import kz.halykacademy.bookstore.entity.Genre;
import kz.halykacademy.bookstore.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping("/genres")
    public List<Genre> showAllGenres() {
        List<Genre> allGenres = genreService.getAllGenres();
        return allGenres;
    }

    @GetMapping("/genres/{id}")
    public Genre getGenre(@PathVariable int id) {
        Genre genre = genreService.getGenre(id);
        return genre;
    }

    @PostMapping("/genres")
    public Genre addNewGenre(@RequestBody Genre genre) {
        genreService.saveGenre(genre);
        return genre;
    }

    @PutMapping("/genres")
    public Genre updateGenre(@RequestBody Genre genre) {
        genreService.saveGenre(genre);
        return genre;
    }

    @DeleteMapping("/genres/{id}")
    public String deleteGenre(@PathVariable int id) {
        Genre genre = genreService.getGenre(id);
        genreService.deleteGenre(id);
        return "genre: " + genre.getName() + "was deleted";
    }
}
