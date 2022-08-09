package kz.halykacademy.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import kz.halykacademy.bookstore.dto.PublisherSlimDto;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "publishers")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, mappedBy = "publisher")
    private List<Book> publishedBooksList;

    @Column(name = "deleted_at")
    private LocalDateTime deleted_at;

    public Publisher() {
    }

    public Publisher(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addBookToPublishedList(Book book) {
        if (publishedBooksList == null) {
            publishedBooksList = new ArrayList<>();
        }

        publishedBooksList.add(book);
        book.setPublisher(this);
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

    public List<Book> getPublishedBooksList() {
        return publishedBooksList;
    }

    public void setPublishedBooksList(List<Book> publishedBooksList) {
        this.publishedBooksList = publishedBooksList;
    }

    public LocalDateTime getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(LocalDateTime deleted_at) {
        this.deleted_at = deleted_at;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publishedBooksList=" + publishedBooksList +
                '}';
    }

    public PublisherSlimDto toPublisherSlimDto() {
        return new PublisherSlimDto(this.id, this.name);
    }
}
