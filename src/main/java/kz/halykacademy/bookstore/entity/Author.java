package kz.halykacademy.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "authors")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "surname")
    private String surname;
    @Column(name = "name")
    private String name;
    @Column(name = "patronymicname")
    private String patronymicName;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "book_author"
            , joinColumns = @JoinColumn(name = "author_id")
            , inverseJoinColumns = @JoinColumn(name = "book_id"))

    private List<Book> writtenBooksList;

    @Column(name = "deleted_at")
    private LocalDateTime deleted_at;

    public Author() {
    }

    public Author(int id, String surname, String name, String patronymicName, LocalDate dateOfBirth, List<Book> writtenBooksList) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymicName = patronymicName;
        this.dateOfBirth = dateOfBirth;
        this.writtenBooksList = writtenBooksList;
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

    public List<Book> getWrittenBooksList() {
        return writtenBooksList;
    }

    public void setWrittenBooksList(List<Book> writtenBooksList) {
        this.writtenBooksList = writtenBooksList;
    }

    public LocalDateTime getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(LocalDateTime deleted_at) {
        this.deleted_at = deleted_at;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymicName='" + patronymicName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", writtenBooksList=" + writtenBooksList +
                '}';
    }

}
