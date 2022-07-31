package kz.halykacademy.bookstore.dto;

public class BookPostDto {
    private int id;
    private double price;
    private String title;
    private int numberOfPages;
    private int yearOfRelease;

    private PublisherSlimDto publisher;

    public BookPostDto() {
    }

    public BookPostDto(int id, double price, String title, int numberOfPages, int yearOfRelease, PublisherSlimDto publisher) {
        this.id = id;
        this.price = price;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.yearOfRelease = yearOfRelease;
        this.publisher = publisher;
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

    public PublisherSlimDto getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherSlimDto publisher) {
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
