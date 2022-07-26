package kz.halykacademy.bookstore.service;

import kz.halykacademy.bookstore.entity.Publisher;

import java.util.List;

public interface PublisherService {
    public List<Publisher> getAllPublishers();

    public Publisher getPublisher(int id);

    public void savePublisher(Publisher publisher);

    public void deletePublisher(int id);

    public List<Publisher> findAllByNameContaining(String name);
}
