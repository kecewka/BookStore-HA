package kz.halykacademy.bookstore.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, mappedBy = "publisher")
    private List<Book> publishedBooksList;

    public Publisher(){}

    public Publisher(int id, String name, List<Book> publishedBooksList) {
        this.id = id;
        this.name = name;
        this.publishedBooksList = publishedBooksList;
    }

    public void addBookToPublishedList(Book book){
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

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publishedBooksList=" + publishedBooksList +
                '}';
    }
}
