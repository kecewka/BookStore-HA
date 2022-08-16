package kz.halykacademy.bookstore.mapper;

import kz.halykacademy.bookstore.dto.author.AuthorIdDto;
import kz.halykacademy.bookstore.dto.genre.GenreDto;
import kz.halykacademy.bookstore.dto.genre.GenreIdDto;
import kz.halykacademy.bookstore.dto.genre.GenreSlimDto;
import kz.halykacademy.bookstore.dto.order.OrderDto;
import kz.halykacademy.bookstore.dto.order.OrderPostDto;
import kz.halykacademy.bookstore.dto.order.OrderPutDto;
import kz.halykacademy.bookstore.dto.order.OrderSlimDto;
import kz.halykacademy.bookstore.dto.author.AuthorDto;
import kz.halykacademy.bookstore.dto.author.AuthorFullDto;
import kz.halykacademy.bookstore.dto.author.AuthorPostDto;
import kz.halykacademy.bookstore.dto.book.BookDto;
import kz.halykacademy.bookstore.dto.book.BookIdDto;
import kz.halykacademy.bookstore.dto.book.BookPostDto;
import kz.halykacademy.bookstore.dto.book.BookSlimDto;
import kz.halykacademy.bookstore.dto.publisher.PublisherDto;
import kz.halykacademy.bookstore.dto.publisher.PublisherIdDto;
import kz.halykacademy.bookstore.dto.publisher.PublisherSlimDto;
import kz.halykacademy.bookstore.dto.user.UserDto;
import kz.halykacademy.bookstore.dto.user.UserPostDto;
import kz.halykacademy.bookstore.dto.user.UserPutDto;
import kz.halykacademy.bookstore.dto.user.UserSlimDto;
import kz.halykacademy.bookstore.entity.*;

import java.util.List;
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

    UserSlimDto userToSlimDto(User user);
    UserDto userToDto(User user);
    User dtoToUser(UserPostDto dto);

    User putDtoToUser(UserPutDto dto);
    List<UserDto> userToDtos(List<User> user);

    OrderSlimDto orderToSlimDto(Order order);
    OrderDto orderToDto(Order order);
    Order dtoToOrder(OrderPostDto dto);

    Order putDtoToOrder(OrderPutDto dto);
    List<OrderSlimDto> orderListToSlimDtos(List<Order> orders);
    List<OrderDto> orderToDtos(List<Order> orders);

    BookIdDto intToBookId(Integer value);
    List<BookIdDto> intIdsToDtos(List<Integer> ids);
    List<Book> bookIdsDtoToBook(List<BookIdDto> ids);

    Publisher idDtoToPublisher(PublisherIdDto publisherIdDto);
    PublisherIdDto publisherToIdDto(Publisher publisher);

    Author idDtoToAuthor(AuthorIdDto authorIdDto);
    AuthorIdDto AuthorToIdDto(Author author);

    Genre idDtoToGenre(GenreIdDto genreIdDto);

    GenreIdDto genreToIdDto(Genre genre);
    List<Author> idDtosToAuthors(List<AuthorIdDto> idsList);
    List<Genre> idDtosToGenres(List<GenreIdDto> genresList);
}
