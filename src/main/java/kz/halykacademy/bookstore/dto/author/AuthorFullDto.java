package kz.halykacademy.bookstore.dto.author;

import kz.halykacademy.bookstore.dto.book.BookSlimDto;
import kz.halykacademy.bookstore.dto.genre.GenreSlimDto;

import java.time.LocalDate;
import java.util.List;

public class AuthorFullDto {
    private int id;
    private String surname;
    private String name;
    private String patronymicName;
    private LocalDate dateOfBirth;
    List<BookSlimDto> writtenBooksList;
    List<GenreSlimDto> genresList;

    public AuthorFullDto(){}

    public AuthorFullDto(int id, String surname, String name, String patronymicName, LocalDate dateOfBirth, List<BookSlimDto> writtenBooksList, List<GenreSlimDto> genresList) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymicName = patronymicName;
        this.dateOfBirth = dateOfBirth;
        this.writtenBooksList = writtenBooksList;
        this.genresList = genresList;
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

    public List<BookSlimDto> getWrittenBooksList() {
        return writtenBooksList;
    }

    public void setWrittenBooksList(List<BookSlimDto> writtenBooksList) {
        this.writtenBooksList = writtenBooksList;
    }

    public List<GenreSlimDto> getGenresList() {
        return genresList;
    }

    public void setGenresList(List<GenreSlimDto> genresList) {
        this.genresList = genresList;
    }

    @Override
    public String toString() {
        return "AuthorFullDto{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymicName='" + patronymicName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", writtenBooksList=" + writtenBooksList +
                ", genresList=" + genresList +
                '}';
    }
}
