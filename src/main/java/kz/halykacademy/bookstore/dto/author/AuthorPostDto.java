package kz.halykacademy.bookstore.dto.author;

import kz.halykacademy.bookstore.dto.book.BookIdDto;

import java.time.LocalDate;
import java.util.List;

public class AuthorPostDto {
    private int id;
    private String surname;
    private String name;
    private String patronymicName;
    private LocalDate dateOfBirth;

    private List<BookIdDto> books;

    public AuthorPostDto() {

    }

    public AuthorPostDto(int id, String surname, String name, String patronymicName, LocalDate dateOfBirth) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymicName = patronymicName;
        this.dateOfBirth = dateOfBirth;
    }

    public AuthorPostDto(int id, String surname, String name, String patronymicName, LocalDate dateOfBirth, List<BookIdDto> books) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymicName = patronymicName;
        this.dateOfBirth = dateOfBirth;
        this.books = books;
    }

    public List<BookIdDto> getBooks() {
        return books;
    }

    public void setBooks(List<BookIdDto> books) {
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "AuthorPostDto{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymicName='" + patronymicName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}

