package kz.halykacademy.bookstore.mapper;

import kz.halykacademy.bookstore.dto.*;
import kz.halykacademy.bookstore.entity.*;

import java.util.ArrayList;
import java.util.List;

public class MapSturctMapperImpl implements MapStructMapper {
    @Override
    public BookDto bookToDto(Book book) {
        if (book == null) {
            return null;
        }

        return new BookDto(
                book.getId(),
                book.getPrice(),
                authorListToSlimDtos(book.getAuthorsList()),
                publisherToSlimDto(book.getPublisher()),
                book.getTitle(),
                book.getNumberOfPages(),
                book.getYearOfRelease(),
                genreListToSlimDtos(book.getGenresList()));
    }

    @Override
    public BookSlimDto bookToSlimDto(Book book) {
        if (book == null) {
            return null;
        }
        return new BookSlimDto(book.getTitle());
    }

    @Override
    public BookPostDto bookToPostDto(Book book) {
        if (book == null) {
            return null;
        }
        return new BookPostDto(
                book.getId(),
                book.getPrice(),
                book.getTitle(),
                book.getNumberOfPages(),
                book.getYearOfRelease(),
                publisherToSlimDto(book.getPublisher()));
    }

    @Override
    public Book dtoToBook(BookPostDto dto) {
        if (dto == null) {
            return null;
        }
        return new Book(dto.getId(),
                dto.getPrice(),
                null,
                dtoToPublisher(dto.getPublisher()),
                dto.getTitle(),
                dto.getNumberOfPages(),
                dto.getYearOfRelease(),
                null);
    }

    @Override
    public List<BookSlimDto> bookListToSlimDtos(List<Book> books) {
        if (books == null) {
            return null;
        }
        List<BookSlimDto> bookslist = new ArrayList<>(books.size());
        for (Book b : books) {
            bookslist.add(bookToSlimDto(b));
        }
        return bookslist;
    }

    @Override
    public List<BookDto> bookToDtos(List<Book> books) {
        if (books == null) {
            return null;
        }
        List<BookDto> bookslist = new ArrayList<>(books.size());
        for (Book b : books) {
            bookslist.add(bookToDto(b));
        }
        return bookslist;
    }

    @Override
    public AuthorDto authorToSlimDto(Author author) {
        if (author == null) {
            return null;
        }
        return new AuthorDto(
                author.getSurname(),
                author.getName(),
                author.getPatronymicName(),
                author.getDateOfBirth());
    }

    @Override
    public AuthorFullDto authorToDto(Author author) {
        if (author == null) {
            return null;
        }
        return new AuthorFullDto(
                author.getId(),
                author.getSurname(),
                author.getName(),
                author.getPatronymicName(),
                author.getDateOfBirth(),
                bookListToSlimDtos(author.getWrittenBooksList()),
                null);

    }

    @Override
    public AuthorPostDto authorToPostDto(Author author) {
        if (author == null) {
            return null;
        }
        return new AuthorPostDto(
                author.getId(),
                author.getSurname(),
                author.getName(),
                author.getPatronymicName(),
                author.getDateOfBirth()
        );
    }

    @Override
    public Author dtoToAuthor(AuthorPostDto dto) {
        if (dto == null) {
            return null;
        }

        return new Author(
                dto.getId(),
                dto.getSurname(),
                dto.getName(),
                dto.getPatronymicName(),
                dto.getDateOfBirth(),
                null
        );
    }

    @Override
    public List<AuthorDto> authorListToSlimDtos(List<Author> authors) {
        if (authors == null) {
            return null;
        }

        List<AuthorDto> authorDtos = new ArrayList<>(authors.size());
        for (Author a : authors) {
            authorDtos.add(authorToSlimDto(a));
        }

        return authorDtos;
    }

    @Override
    public List<AuthorFullDto> authorToDtos(List<Author> authors) {
        if (authors == null) {
            return null;
        }

        List<AuthorFullDto> authorDtos = new ArrayList<>(authors.size());
        for (Author a : authors) {
            authorDtos.add(authorToDto(a));
        }

        return authorDtos;
    }

    @Override
    public PublisherSlimDto publisherToSlimDto(Publisher publisher) {
        if (publisher == null) {
            return null;
        }

        return new PublisherSlimDto(
                publisher.getId(),
                publisher.getName()
        );
    }

    @Override
    public PublisherDto publisherToDto(Publisher publisher) {
        if (publisher == null) {
            return null;
        }
        return new PublisherDto(
                publisher.getId(),
                publisher.getName(),
                bookListToSlimDtos(publisher.getPublishedBooksList())
        );
    }

    @Override
    public Publisher dtoToPublisher(PublisherSlimDto dto) {
        if (dto == null) {
            return null;
        }

        return new Publisher(
                dto.getId(),
                dto.getName(),
                null
        );
    }

    @Override
    public List<PublisherDto> publisherToDtos(List<Publisher> publishers) {
        if (publishers == null) {
            return null;
        }

        List<PublisherDto> publisherDtos = new ArrayList<>(publishers.size());
        for (Publisher p : publishers) {
            publisherDtos.add(publisherToDto(p));
        }
        return publisherDtos;
    }

    @Override
    public GenreSlimDto genreToSlimDto(Genre genre) {
        if (genre == null) {
            return null;
        }

        return new GenreSlimDto(
                genre.getName()
        );
    }

    @Override
    public GenreDto genreToDto(Genre genre) {
        if (genre == null) {
            return null;
        }
        return new GenreDto(
                genre.getId(),
                genre.getName()
        );
    }

    @Override
    public Genre dtoToGenre(GenreDto dto) {
        if (dto == null) {
            return null;
        }

        return new Genre(dto.getId(), dto.getName());
    }


    @Override
    public List<GenreDto> genreToDtos(List<Genre> genre) {
        if (genre == null) {
            return null;
        }

        List<GenreDto> genres = new ArrayList<>(genre.size());
        for (Genre g : genre) {
            genres.add(genreToDto(g));
        }
        return genres;
    }

    @Override
    public List<GenreSlimDto> genreListToSlimDtos(List<Genre> genres) {
        if (genres == null) {
            return null;
        }
        List<GenreSlimDto> genreSlimDtos = new ArrayList<>(genres.size());
        for (Genre g : genres) {
            genreSlimDtos.add(genreToSlimDto(g));
        }
        return genreSlimDtos;
    }

    @Override
    public UserSlimDto userToSlimDto(User user) {
        if (user == null) {
            return null;
        }
        return new UserSlimDto(user.getLogin());
    }

    @Override
    public UserDto userToDto(User user) {
        if (user == null) {
            return null;
        }
        return new UserDto(user.getId(),
                user.getLogin(),
                user.getPassword(),
                user.getRole(),
                user.isBlocked(),
                orderListToSlimDtos(user.getOrders()));
    }

    @Override
    public User dtoToUser(UserPostDto dto) {
        if (dto == null) {
            return null;
        }
        return new User(dto.getId(),
                dto.getLogin(),
                dto.getPassword(),
                dto.getRole(),
                dto.isBlocked());
    }

    @Override
    public List<UserDto> userToDtos(List<User> users) {
        if (users == null) {
            return null;
        }

        List<UserDto> usersList = new ArrayList<>(users.size());
        for (User u : users) {
            usersList.add(userToDto(u));
        }
        return usersList;
    }

    @Override
    public OrderSlimDto orderToSlimDto(Order order) {
        if (order == null) {
            return null;
        }
        return new OrderSlimDto(order.getId());
    }

    @Override
    public OrderDto orderToDto(Order order) {
        if (order == null) {
            return null;
        }
        return new OrderDto(
                order.getId(),
                userToSlimDto(order.getUser()),
                bookListToSlimDtos(order.getOrderedBooks()),
                order.getStatus(),
                order.getOrderTime());
    }

    @Override
    public Order dtoToOrder(OrderPostDto dto) {
        if (dto == null) {
            return null;
        }
        return new Order(dto.getId(),
                null,
                null,
                dto.getStatus(),
                dto.getOrderTime());
    }

    @Override
    public List<OrderSlimDto> orderListToSlimDtos(List<Order> orders) {
        if(orders == null){
            return null;
        }
        List<OrderSlimDto> ordersList = new ArrayList<>(orders.size());
        for(Order o : orders){
            ordersList.add(orderToSlimDto(o));
        }
        return ordersList;
    }

    @Override
    public List<OrderDto> orderToDtos(List<Order> orders) {
        if(orders == null){
            return null;
        }

        List<OrderDto> ordersList = new ArrayList<>(orders.size());
        for(Order o : orders){
            ordersList.add(orderToDto(o));
        }
        return ordersList;
    }
}
