package kz.halykacademy.bookstore.dto.publisher;

import kz.halykacademy.bookstore.dto.book.BookSlimDto;

import java.util.List;

public class PublisherDto {
    private int id;
    private String name;
    private List<BookSlimDto> publishedBooksList;

    public PublisherDto(){}

    public PublisherDto(int id, String name, List<BookSlimDto> publishedBooksList) {
        this.id = id;
        this.name = name;
        this.publishedBooksList = publishedBooksList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookSlimDto> getPublishedBooksList() {
        return publishedBooksList;
    }

    public void setPublishedBooksList(List<BookSlimDto> publishedBooksList) {
        this.publishedBooksList = publishedBooksList;
    }

    @Override
    public String toString() {
        return "PublisherDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publishedBooksList=" + publishedBooksList +
                '}';
    }
}
