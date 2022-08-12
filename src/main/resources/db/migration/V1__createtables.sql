
create table if not exists publishers(
                                         id serial primary key,
                                         name varchar(100),
                                         deleted_at timestamp without time zone

);

create table if not exists books(
                                    id serial primary key,
                                    price numeric,
                                    publisher_id integer references publishers (id),
                                    title varchar(100),
                                    numberofpages integer,
                                    yearofrelease integer,
                                    deleted_at timestamp without time zone
);

create table if not exists authors(
                                      id serial primary key,
                                      surname varchar(100),
                                      name varchar(100),
                                      patronymicname varchar(100),
                                      date_of_birth date,
                                      deleted_at timestamp without time zone
);

create table if not exists genres(
                                     id serial primary key,
                                     name varchar(100)
);

create table if not exists book_author(
                                          book_id int references books(id),
                                          author_id int references authors(id)
);

create table if not exists book_genre(
                                         book_id int references books(id),
                                         genre_id int references genres(id)
);


create table if not exists users(
                                    id serial primary key,
                                    login varchar(30) unique not null,
                                    password varchar(255) not null,
                                    user_role varchar(10) not null,
                                    is_blocked boolean not null
);


create table if not exists orders(
                                     id serial primary key,
                                     user_id int references users(id),
                                     order_status varchar(100) not null,
                                     ordered_at timestamp without time zone
);

create table if not exists order_book(
                                         order_id int references orders(id),
                                         book_id int references books(id)
);

