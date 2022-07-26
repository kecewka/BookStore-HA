package kz.halykacademy.bookstore.controller;

import kz.halykacademy.bookstore.entity.Publisher;
import kz.halykacademy.bookstore.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;


    @GetMapping("/publishers")
    public List<Publisher> showAllPublishers() {
        List<Publisher> allPublishers = publisherService.getAllPublishers();

        return allPublishers;
    }

    @GetMapping("/publishers/{id}")
    public Publisher getPublisher(@PathVariable int id) {
        Publisher publisher = publisherService.getPublisher(id);

        return publisher;
    }

    @PostMapping("/publishers")
    public Publisher addNewPublisher(@RequestBody Publisher publisher) {
        publisherService.savePublisher(publisher);

        return publisher;
    }

    @PutMapping("/publishers")
    public Publisher updatePublisher(@RequestBody Publisher publisher) {
        publisherService.savePublisher(publisher);

        return publisher;
    }

    @DeleteMapping("/publishers/{id}")
    public String deletePublisher(@PathVariable int id) {
        Publisher publisher = publisherService.getPublisher(id);
        publisherService.deletePublisher(id);
        return "publisher: " + publisher.getName() + " was deleted";
    }

    @GetMapping("/publishers/")
    public List<Publisher> findAllByNameContaining(@RequestParam String name){
        List<Publisher> publishers = publisherService.findAllByNameContaining(name);
        return publishers;
    }

}
