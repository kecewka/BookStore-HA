package kz.halykacademy.bookstore.service;

import kz.halykacademy.bookstore.dao.AuthorRepository;
import kz.halykacademy.bookstore.entity.Author;
import kz.halykacademy.bookstore.exceptions.AuthorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @Override
    public Author getAuthor(int id) {
        Author author = null;
        Optional<Author> optional = authorRepository.findById(id);
        if (optional.isPresent()) {
            author = optional.get();
        }
        if (optional.isEmpty()){
            throw new AuthorNotFoundException("Author with " + id + " not found");
        }
        return author;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public void deleteAuthor(int id) {
        authorRepository.deleteById(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @Override
    public List<Author> findAllByNameContaining(String name) {
        List<Author> authors = authorRepository.findAllByNameContaining(name);
        return authors;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @Override
    public List<String> findGenresOfAuthor(int id) {
        List<String> genres = authorRepository.findGenresOfAuthors(id);
        return genres;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @Override
    public List<Author> findAllByGenreList(List<String> genres) {
        List<Author> authors = authorRepository.findAllByGenreList(genres);
        return authors;
    }
}
