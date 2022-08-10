package kz.halykacademy.bookstore.dto.publisher;

public class PublisherSlimDto {
    private int id;
    private String name;

    public PublisherSlimDto(){}

    public PublisherSlimDto(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "PublisherSlimDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
