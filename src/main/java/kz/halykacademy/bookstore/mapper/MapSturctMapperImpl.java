package kz.halykacademy.bookstore.mapper;

import kz.halykacademy.bookstore.dao.BookRepository;
import kz.halykacademy.bookstore.dao.OrderRepository;
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
import kz.halykacademy.bookstore.enums.Statuses;
import kz.halykacademy.bookstore.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class MapSturctMapperImpl implements MapStructMapper {


    private final UserService userService;
    private final BookRepository bookRepository;

    private final PublisherService publisherService;
    private final OrderRepository orderRepository;
    private final AuthorService authorService;
    private final GenreService genreService;

    private final BookService bookService;



    @Autowired
    public MapSturctMapperImpl(UserService userService, BookRepository bookRepository, PublisherService publisherService, OrderRepository orderRepository, AuthorService authorService, GenreService genreService, BookService bookService) {
        this.userService = userService;
        this.bookRepository = bookRepository;
        this.publisherService = publisherService;
        this.orderRepository = orderRepository;
        this.authorService = authorService;
        this.genreService = genreService;
        this.bookService = bookService;
    }

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
                publisherToIdDto(book.getPublisher()));
    }

    @Override
    public Book dtoToBook(BookPostDto dto) {
        if (dto == null) {
            return null;
        }
        return new Book(dto.getId(),
                dto.getPrice(),
                idDtosToAuthors(dto.getAuthorsList()),
                idDtoToPublisher(dto.getPublisher()),
                dto.getTitle(),
                dto.getNumberOfPages(),
                dto.getYearOfRelease(),
                idDtosToGenres(dto.getGenresList()));
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
                bookIdsDtoToBook(dto.getBooks())
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
                dto.getName()
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
                false);
    }

    @Override
    public User putDtoToUser(UserPutDto dto) {
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

    //Костыль
    @Override
    public Order dtoToOrder(OrderPostDto dto) {
        if (dto == null) {
            return null;
        }

        List<Book> books = new ArrayList<>(dto.getOrderedBooks().size());
        User user = userService.getUser(dto.getUser().getId());
        for (Integer i : dto.getOrderedBooks()) {
            books.add(bookRepository.findAnyBook(i));
        }

        return new Order(dto.getId(),
                user,
                books,
                Statuses.CREATED,
                LocalDateTime.now());
    }

    @Override
    public Order putDtoToOrder(OrderPutDto dto) {
        if (dto == null) {
            return null;
        }

        List<Book> books = new ArrayList<>(dto.getOrderedBooks().size());
        User user = userService.getUser(dto.getUser().getId());
        for (Integer i : dto.getOrderedBooks()) {
            books.add(bookRepository.findAnyBook(i));
        }


        return new Order(dto.getId(),
                user,
                books,
                dto.getStatus(),
                orderRepository.findById(dto.getId()).get().getOrderTime()
        );
    }

    @Override
    public List<OrderSlimDto> orderListToSlimDtos(List<Order> orders) {
        if (orders == null) {
            return null;
        }
        List<OrderSlimDto> ordersList = new ArrayList<>(orders.size());
        for (Order o : orders) {
            ordersList.add(orderToSlimDto(o));
        }
        return ordersList;
    }

    @Override
    public List<OrderDto> orderToDtos(List<Order> orders) {
        if (orders == null) {
            return null;
        }

        List<OrderDto> ordersList = new ArrayList<>(orders.size());
        for (Order o : orders) {
            ordersList.add(orderToDto(o));
        }
        return ordersList;
    }

    public BookIdDto intToBookId(Integer value) {
        return new BookIdDto(value);
    }

    @Override
    public List<BookIdDto> intIdsToDtos(List<Integer> ids) {
        if (ids == null) {
            return null;
        }
        List<BookIdDto> dtoIds = new ArrayList<>(ids.size());
        for (Integer i : ids) {
            dtoIds.add(new BookIdDto(i));
        }
        return dtoIds;
    }

    @Override
    public List<Book> bookIdsDtoToBook(List<BookIdDto> ids) {
        if (ids == null) {
            return null;
        }
        List<Book> books = new ArrayList<>(ids.size());
        for (BookIdDto i : ids) {
            books.add(idDtoToBook(i));
        }
        return books;
    }

    @Override
    public Publisher idDtoToPublisher(PublisherIdDto publisherIdDto) {
        if (publisherIdDto == null) {
            return null;
        }
        return publisherService.getPublisher(publisherIdDto.getId());
    }

    @Override
    public PublisherIdDto publisherToIdDto(Publisher publisher) {
        if (publisher == null) {
            return null;
        }

        return new PublisherIdDto(publisher.getId());
    }

    @Override
    public Author idDtoToAuthor(AuthorIdDto authorIdDto) {
        if (authorIdDto == null) {
            return null;
        }

        return authorService.getAuthor(authorIdDto.getId());
    }

    @Override
    public AuthorIdDto AuthorToIdDto(Author author) {
        if (author == null) {
            return null;
        }
        return new AuthorIdDto(author.getId());
    }

    @Override
    public Genre idDtoToGenre(GenreIdDto genreIdDto) {
        if (genreIdDto == null) {
            return null;
        }
        return genreService.getGenre(genreIdDto.getId());
    }

    @Override
    public GenreIdDto genreToIdDto(Genre genre) {
        if (genre == null) {
            return null;
        }
        return new GenreIdDto(genre.getId());
    }

    public List<Author> idDtosToAuthors(List<AuthorIdDto> idsList) {
        if (idsList == null) {
            return null;
        }
        List<Author> authorList = new ArrayList<>(idsList.size());
        for (AuthorIdDto a : idsList) {
            authorList.add(idDtoToAuthor(a));
        }
        return authorList;
    }

    public List<Genre> idDtosToGenres(List<GenreIdDto> genresList) {
        if (genresList == null) {
            return null;
        }
        List<Genre> genres = new ArrayList<>(genresList.size());
        for (GenreIdDto g : genresList) {
            genres.add(idDtoToGenre(g));
        }

        return genres;
    }

    public Book idDtoToBook(BookIdDto book) {
        if (book == null) {
            return null;
        }
        return bookService.getBook(book.getId());
    }

}
