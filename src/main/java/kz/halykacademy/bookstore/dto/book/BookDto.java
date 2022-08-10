package kz.halykacademy.bookstore.dto.book;

import kz.halykacademy.bookstore.dto.genre.GenreSlimDto;
import kz.halykacademy.bookstore.dto.publisher.PublisherSlimDto;
import kz.halykacademy.bookstore.dto.author.AuthorDto;

import java.util.List;

public class BookDto {
    private int id;
    private double price;
    private List<AuthorDto> authorsList;
    private PublisherSlimDto publisher;
    private String title;
    private int numberOfPages;
    private int yearOfRelease;

    private List<GenreSlimDto> genresList;

    public BookDto() {
    }

    public BookDto(int id, double price, List<AuthorDto> authorsList, PublisherSlimDto publisher, String title, int numberOfPages, int yearOfRelease, List<GenreSlimDto> genresList) {
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

    public List<AuthorDto> getAuthorsList() {
        return authorsList;
    }

    public void setAuthorsList(List<AuthorDto> authorsList) {
        this.authorsList = authorsList;
    }

    public PublisherSlimDto getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherSlimDto publisher) {
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

    public List<GenreSlimDto> getGenresList() {
        return genresList;
    }

    public void setGenresList(List<GenreSlimDto> genresList) {
        this.genresList = genresList;
    }

    @Override
    public String toString() {
        return "BookDto{" +
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
