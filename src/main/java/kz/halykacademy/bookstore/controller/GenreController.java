package kz.halykacademy.bookstore.controller;

import kz.halykacademy.bookstore.dto.GenreDto;
import kz.halykacademy.bookstore.mapper.MapStructMapper;
import kz.halykacademy.bookstore.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GenreController {

    @Autowired
    private GenreService genreService;
    @Autowired
    private MapStructMapper mapStructMapper;

    @GetMapping("/genres")
    public List<GenreDto> showAllGenres() {
        List<GenreDto> allGenres = mapStructMapper.genreToDtos(genreService.getAllGenres());
        return allGenres;
    }

    @GetMapping("/genres/{id}")
    public GenreDto getGenre(@PathVariable int id) {
        GenreDto genre = mapStructMapper.genreToDto(genreService.getGenre(id));
        return genre;
    }

    @PostMapping("/genres")
    public GenreDto addNewGenre(@RequestBody GenreDto genre) {
        genreService.saveGenre(mapStructMapper.dtoToGenre(genre));
        return genre;
    }

    @PutMapping("/genres")
    public GenreDto updateGenre(@RequestBody GenreDto genre) {
        genreService.saveGenre(mapStructMapper.dtoToGenre(genre));
        return genre;
    }

    @DeleteMapping("/genres/{id}")
    public String deleteGenre(@PathVariable int id) {
        GenreDto genre = mapStructMapper.genreToDto(genreService.getGenre(id));
        genreService.deleteGenre(id);
        return "genre: " + genre.getName() + "was deleted";
    }
}
