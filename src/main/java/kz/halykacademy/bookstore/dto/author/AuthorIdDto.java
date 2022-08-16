package kz.halykacademy.bookstore.dto.author;

public class AuthorIdDto {
    private int id;

    public AuthorIdDto(){}

    public AuthorIdDto(int id){
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
        return "AuthorIdDto{" +
                "id=" + id +
                '}';
    }
}
