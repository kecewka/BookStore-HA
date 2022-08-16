package kz.halykacademy.bookstore.dto.book;

import kz.halykacademy.bookstore.dto.author.AuthorIdDto;
import kz.halykacademy.bookstore.dto.genre.GenreIdDto;
import kz.halykacademy.bookstore.dto.publisher.PublisherIdDto;
import kz.halykacademy.bookstore.dto.publisher.PublisherSlimDto;

import java.util.List;

public class BookPostDto {
    private int id;
    private double price;
    private String title;
    private int numberOfPages;
    private int yearOfRelease;

    private PublisherIdDto publisher;

    private List<AuthorIdDto> authorsList;
    private List<GenreIdDto> genresList;

    public BookPostDto() {
    }

    public BookPostDto(int id, double price, String title, int numberOfPages, int yearOfRelease, PublisherIdDto publisher) {
        this.id = id;
        this.price = price;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.yearOfRelease = yearOfRelease;
        this.publisher = publisher;
    }

    public BookPostDto(int id, double price, String title, int numberOfPages, int yearOfRelease, PublisherIdDto publisher, List<AuthorIdDto> authorsList, List<GenreIdDto> genresList) {
        this.id = id;
        this.price = price;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.yearOfRelease = yearOfRelease;
        this.publisher = publisher;
        this.authorsList = authorsList;
        this.genresList = genresList;
    }

    public List<AuthorIdDto> getAuthorsList() {
        return authorsList;
    }

    public void setAuthorsList(List<AuthorIdDto> authorsList) {
        this.authorsList = authorsList;
    }

    public List<GenreIdDto> getGenresList() {
        return genresList;
    }

    public void setGenresList(List<GenreIdDto> genresList) {
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

    public PublisherIdDto getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherIdDto publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "BookPostDto{" +
                "id=" + id +
                ", price=" + price +
                ", title='" + title + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", yearOfRelease=" + yearOfRelease +
                ", publisher=" + publisher +
                '}';
    }
}
