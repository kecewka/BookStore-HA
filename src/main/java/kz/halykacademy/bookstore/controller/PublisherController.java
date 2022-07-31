package kz.halykacademy.bookstore.controller;

import kz.halykacademy.bookstore.dto.PublisherDto;
import kz.halykacademy.bookstore.dto.PublisherSlimDto;
import kz.halykacademy.bookstore.mapper.MapStructMapper;
import kz.halykacademy.bookstore.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;
    @Autowired
    private MapStructMapper mapStructMapper;

    @GetMapping("/publishers")
    public List<PublisherDto> showAllPublishers() {
        List<PublisherDto> allPublishers = mapStructMapper.publisherToDtos(publisherService.getAllPublishers());

        return allPublishers;
    }

    @GetMapping("/publishers/{id}")
    public PublisherDto getPublisher(@PathVariable int id) {
        PublisherDto publisher = mapStructMapper.publisherToDto(publisherService.getPublisher(id));

        return publisher;
    }

    @PostMapping("/publishers")
    public PublisherSlimDto addNewPublisher(@RequestBody PublisherSlimDto publisher) {
        publisherService.savePublisher(mapStructMapper.dtoToPublisher(publisher));

        return publisher;
    }

    @PutMapping("/publishers")
    public PublisherSlimDto updatePublisher(@RequestBody PublisherSlimDto publisher) {
        publisherService.savePublisher(mapStructMapper.dtoToPublisher(publisher));

        return publisher;
    }

    @DeleteMapping("/publishers/{id}")
    public String deletePublisher(@PathVariable int id) {
        PublisherDto publisher = mapStructMapper.publisherToDto(publisherService.getPublisher(id));
        publisherService.deletePublisher(id);
        return "publisher: " + publisher.getName() + " was deleted";
    }

    @GetMapping("/publishers/")
    public List<PublisherDto> findAllByNameContaining(@RequestParam String name){
        List<PublisherDto> publishers = mapStructMapper.publisherToDtos(publisherService.findAllByNameContaining(name));
        return publishers;
    }

}
