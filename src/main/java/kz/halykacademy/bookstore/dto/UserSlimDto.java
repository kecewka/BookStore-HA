package kz.halykacademy.bookstore.dto;

public class UserSlimDto {
    private String login;

    public UserSlimDto(){}
    public UserSlimDto(String login){
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "UserSlimDto{" +
                "login='" + login + '\'' +
                '}';
    }
}
