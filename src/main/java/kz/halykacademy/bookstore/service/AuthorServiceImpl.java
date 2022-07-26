package kz.halykacademy.bookstore.service;

import kz.halykacademy.bookstore.dao.AuthorRepository;
import kz.halykacademy.bookstore.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthor(int id) {
        Author author = null;
        Optional<Author> optional = authorRepository.findById(id);
        if (optional.isPresent()) {
            author = optional.get();
        }
        return author;
    }

    @Override
    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(int id) {
        authorRepository.deleteById(id);
    }

    @Override
    public List<Author> findAllByNameContaining(String name) {
        List<Author> authors = authorRepository.findAllByNameContaining(name);
        return authors;
    }
}
