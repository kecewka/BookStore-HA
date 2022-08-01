package kz.halykacademy.bookstore.mapper;

import kz.halykacademy.bookstore.dto.*;
import kz.halykacademy.bookstore.entity.Author;
import kz.halykacademy.bookstore.entity.Book;
import kz.halykacademy.bookstore.entity.Genre;
import kz.halykacademy.bookstore.entity.Publisher;

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
}
