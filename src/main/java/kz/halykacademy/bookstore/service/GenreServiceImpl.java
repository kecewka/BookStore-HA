package kz.halykacademy.bookstore.service;

import kz.halykacademy.bookstore.dao.GenreRepository;
import kz.halykacademy.bookstore.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    GenreRepository genreRepository;

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public Genre getGenre(int id) {
        Genre genre = null;
        Optional<Genre> optional = genreRepository.findById(id);
        if (optional.isPresent()) {
            genre = optional.get();
        }

        return genre;
    }

    @Override
    public void saveGenre(Genre genre) {
        genreRepository.save(genre);
    }

    @Override
    public void deleteGenre(int id) {
        genreRepository.deleteById(id);
    }
}
