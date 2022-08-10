package kz.halykacademy.bookstore.service;

import kz.halykacademy.bookstore.dao.PublisherRepository;
import kz.halykacademy.bookstore.entity.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherServiceImpl implements PublisherService {


    private final PublisherRepository publisherRepository;
    @Autowired
    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @Override
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @Override
    public Publisher getPublisher(int id) {
        Publisher publisher = null;
        Optional<Publisher> optional = publisherRepository.findById(id);
        if (optional.isPresent()) {
            publisher = optional.get();
        }
        return publisher;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public void savePublisher(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public void deletePublisher(int id) {
        publisherRepository.deleteById(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @Override
    public List<Publisher> findAllByNameContaining(String name) {
        List<Publisher> publishers = publisherRepository.findAllByNameContaining(name);
        return publishers;
    }
}
