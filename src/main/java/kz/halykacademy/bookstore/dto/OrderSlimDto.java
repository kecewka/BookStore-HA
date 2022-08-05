package kz.halykacademy.bookstore.dto;

public class OrderSlimDto {
    private int id;

    public OrderSlimDto(){}

    public OrderSlimDto(int id) {
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
        return "OrderSlimDto{" +
                "id=" + id +
                '}';
    }
}
