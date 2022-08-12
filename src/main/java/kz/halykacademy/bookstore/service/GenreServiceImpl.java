package kz.halykacademy.bookstore.service;

import kz.halykacademy.bookstore.dao.GenreRepository;
import kz.halykacademy.bookstore.entity.Genre;
import kz.halykacademy.bookstore.exceptions.GenreNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;

    @Autowired
    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @Override
    public Genre getGenre(int id) {
        Genre genre = null;
        Optional<Genre> optional = genreRepository.findById(id);
        if (optional.isPresent()) {
            genre = optional.get();
        }
        if (optional.isEmpty()) {
            throw new GenreNotFoundException("Genre with id " + id + " not found");
        }

        return genre;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public void saveGenre(Genre genre) {
        genreRepository.save(genre);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public void deleteGenre(int id) {
        genreRepository.deleteById(id);
    }
}
