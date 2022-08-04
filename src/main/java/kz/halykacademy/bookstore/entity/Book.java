package kz.halykacademy.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "books")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "price")
    private double price;
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "book_author"
            , joinColumns = @JoinColumn(name = "book_id")
            , inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authorsList;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "publisher_id", nullable=false)
    private Publisher publisher;
    @Column(name = "title")
    private String title;
    @Column(name = "numberofpages")
    private int numberOfPages;
    @Column(name = "yearofrelease")
    private int yearOfRelease;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "book_genre"
            , joinColumns = @JoinColumn(name = "book_id")
            , inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genresList;

    @Column(name = "deleted_at")
    private LocalDateTime deleted_at;
    public Book() {
    }

    public Book(int id, double price, List<Author> authorsList, Publisher publisher, String title, int numberOfPages, int yearOfRelease, List<Genre> genresList) {
        this.id = id;
        this.price = price;
        this.authorsList = authorsList;
        this.publisher = publisher;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.yearOfRelease = yearOfRelease;
        this.genresList = genresList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Author> getAuthorsList() {
        return authorsList;
    }

    public void setAuthorsList(List<Author> authorsList) {
        this.authorsList = authorsList;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public List<Genre> getGenresList() {
        return genresList;
    }

    public void setGenresList(List<Genre> genresList) { this.genresList = genresList;
    }

    public LocalDateTime getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(LocalDateTime deleted_at) {
        this.deleted_at = deleted_at;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", price=" + price +
                ", authorsList=" + authorsList +
                ", publisher=" + publisher +
                ", title='" + title + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", yearOfRelease=" + yearOfRelease +
                ", genresList=" + genresList +
                '}';
    }

}

