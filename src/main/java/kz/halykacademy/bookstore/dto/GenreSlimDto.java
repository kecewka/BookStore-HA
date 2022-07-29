package kz.halykacademy.bookstore.dto;

public class GenreSlimDto {
    private String name;

    public GenreSlimDto(){}

    public GenreSlimDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GenreSlimDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
