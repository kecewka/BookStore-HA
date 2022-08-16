package kz.halykacademy.bookstore.dto.genre;

public class GenreIdDto {
    private int id;

    public GenreIdDto(){}

    public GenreIdDto(int id){
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
        return "GenreIdDto{" +
                "id=" + id +
                '}';
    }
}
