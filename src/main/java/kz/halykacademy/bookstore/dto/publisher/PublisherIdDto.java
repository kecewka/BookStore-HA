package kz.halykacademy.bookstore.dto.publisher;

public class PublisherIdDto {
    private int id;

    public PublisherIdDto(){}
    public PublisherIdDto(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PublisherIdDto{" +
                "id=" + id +
                '}';
    }
}
