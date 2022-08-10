package kz.halykacademy.bookstore.dto.book;

public class BookIdDto {
    private int id;

    public BookIdDto(){}
    public BookIdDto(int id){
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
        return "BookIdDto{" +
                "id=" + id +
                '}';
    }
}
