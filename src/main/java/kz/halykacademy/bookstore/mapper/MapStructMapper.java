package kz.halykacademy.bookstore.mapper;

import kz.halykacademy.bookstore.dto.*;
import kz.halykacademy.bookstore.entity.Author;
import kz.halykacademy.bookstore.entity.Book;
import kz.halykacademy.bookstore.entity.Genre;
import kz.halykacademy.bookstore.entity.Publisher;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
    BookDto bookToDto(Book book);
    BookSlimDto bookToSlimDto(Book book);
    BookPostDto bookToPostDto(Book book);
    Book dtoToBook(BookPostDto dto);
    List<BookSlimDto> bookListToSlimDtos(List<Book> books);
    List<BookDto> bookToDtos(List<Book> books);

    AuthorDto authorToSlimDto(Author author);
    AuthorFullDto authorToDto(Author author);
    AuthorPostDto authorToPostDto(Author author);
    Author dtoToAuthor(AuthorPostDto dto);
    List<AuthorDto> authorListToSlimDtos(List<Author> authors);
    List<AuthorFullDto> authorToDtos(List<Author> authors);

    PublisherSlimDto publisherToSlimDto(Publisher publisher);
    PublisherDto publisherToDto(Publisher publisher);
    Publisher dtoToPublisher(PublisherSlimDto dto);
    List<PublisherDto> publisherToDtos(List<Publisher> publishers);

    GenreSlimDto genreToSlimDto(Genre genre);
    GenreDto genreToDto(Genre genre);
    Genre dtoToGenre(GenreDto dto);
    List<GenreDto> genreToDtos(List<Genre> genre);
    List<GenreSlimDto> genreListToSlimDtos(List<Genre> genres);
}
