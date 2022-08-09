package kz.halykacademy.bookstore.dto;

public class UserIdDto {
    private int id;

    public UserIdDto() {
    }

    public UserIdDto(int id) {
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
        return "UserIdDto{" +
                "id=" + id +
                '}';
    }
}
