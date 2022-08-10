package kz.halykacademy.bookstore.dto.author;

import kz.halykacademy.bookstore.entity.Author;

import java.time.LocalDate;

public class AuthorDto {
    private String surname;
    private String name;
    private String patronymicName;
    private LocalDate dateOfBirth;

    public AuthorDto(){}

    public AuthorDto(String surname, String name, String patronymicName, LocalDate dateOfBirth) {
        this.surname = surname;
        this.name = name;
        this.patronymicName = patronymicName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public void setPatronymicName(String patronymicName) {
        this.patronymicName = patronymicName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "AuthorDto{" +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymicName='" + patronymicName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
