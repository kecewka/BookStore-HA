package kz.halykacademy.bookstore.service;

import kz.halykacademy.bookstore.entity.Genre;

import java.util.List;

public interface GenreService {

    public List<Genre> getAllGenres();

    public Genre getGenre(int id);

    public void saveGenre(Genre genre);

    public void deleteGenre(int id);
}
