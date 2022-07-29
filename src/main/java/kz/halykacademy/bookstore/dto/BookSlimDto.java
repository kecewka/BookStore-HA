package kz.halykacademy.bookstore.dto;

public class BookSlimDto {
    private String title;

    public BookSlimDto(){}
    public BookSlimDto(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "BookSlimDto{" +
                "title='" + title + '\'' +
                '}';
    }
}
