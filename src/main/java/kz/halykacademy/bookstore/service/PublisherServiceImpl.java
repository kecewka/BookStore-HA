package kz.halykacademy.bookstore.service;

import kz.halykacademy.bookstore.dao.PublisherRepository;
import kz.halykacademy.bookstore.entity.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher getPublisher(int id) {
        Publisher publisher = null;
        Optional<Publisher> optional = publisherRepository.findById(id);
        if (optional.isPresent()) {
            publisher = optional.get();
        }
        return publisher;
    }

    @Override
    public void savePublisher(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    @Override
    public void deletePublisher(int id) {
        publisherRepository.deleteById(id);
    }

    @Override
    public List<Publisher> findAllByNameContaining(String name) {
        List<Publisher> publishers = publisherRepository.findAllByNameContaining(name);
        return publishers;
    }
}
