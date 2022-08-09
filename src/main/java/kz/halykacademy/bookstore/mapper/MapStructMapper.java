package kz.halykacademy.bookstore.mapper;

import kz.halykacademy.bookstore.dto.*;
import kz.halykacademy.bookstore.entity.*;
import org.mapstruct.Mapper;

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
    List<UserDto> userToDtos(List<User> user);

    OrderSlimDto orderToSlimDto(Order order);
    OrderDto orderToDto(Order order);
    Order dtoToOrder(OrderPostDto dto);
    List<OrderSlimDto> orderListToSlimDtos(List<Order> orders);
    List<OrderDto> orderToDtos(List<Order> orders);

    BookIdDto intToBookId(Integer value);
    List<BookIdDto> intIdsToDtos(List<Integer> ids);
    List<Book> bookIdsDtoToBook(List<BookIdDto> ids);
}
