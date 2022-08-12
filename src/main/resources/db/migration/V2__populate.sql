insert into publishers(name) values ('Казахстан');
insert into publishers(name) values ('Жазушы');
insert into publishers(name) values ('Жалын');
insert into publishers(name) values ('Рауан');
insert into publishers(name) values ('Онер');
insert into publishers(name) values ('Кайнар');
insert into publishers(name) values ('Гылым');
insert into publishers(name) values ('Білім');
insert into publishers(name) values ('Атамұра');
insert into publishers(name) values ('Сарыарка');
insert into publishers(name) values ('Балауса');
insert into publishers(name) values ('Өлке');

insert into books (price, publisher_id, title, numberofpages, yearofrelease) values (500, 1, 'Harry Potter', 300, 1987);
insert into books (price, publisher_id, title, numberofpages, yearofrelease) values (350, 1, '1984', 223, 1949);
insert into books (price, publisher_id, title, numberofpages, yearofrelease) values (888, 2, 'Көксерек', 300, 1911);
insert into books (price, publisher_id, title, numberofpages, yearofrelease) values (222, 3, 'Абай жолы', 700, 1956);
insert into books (price, publisher_id, title, numberofpages, yearofrelease) values (6482, 4, 'Harry Potter', 520, 2011);
insert into books (price, publisher_id, title, numberofpages, yearofrelease) values (123, 5, 'Harolds book', 465, 2021);
insert into books (price, publisher_id, title, numberofpages, yearofrelease) values (2013, 10, 'Algorithms', 156, 1987);
insert into books (price, publisher_id, title, numberofpages, yearofrelease) values (5000, 12, 'Здоровье', 50, 1852);
insert into books (price, publisher_id, title, numberofpages, yearofrelease) values (500, 11, 'Мақал мәтелдер', 30, 1987);

insert into authors (surname, name, patronymicname, date_of_birth) values ('Әуезов', 'Мұхтар', 'Омарханұлы', '1897-09-28');
insert into authors (surname, name, patronymicname, date_of_birth) values ('Rowling', 'Joanne', '', '1965-07-31');
insert into authors (surname, name, patronymicname, date_of_birth) values ('', 'Ибраһим', 'Құнанбайұлы', '1845-08-10');
insert into authors (surname, name, patronymicname, date_of_birth) values ('Kim', 'Jongkook', '', '1976-04-25');
insert into authors (surname, name, patronymicname, date_of_birth) values ('Orwell', 'George', '', '1903-06-25');
insert into authors (surname, name, patronymicname, date_of_birth) values ('Jake', 'Artur', '', '1967-09-28');
insert into authors (surname, name, patronymicname, date_of_birth) values ('Адамов', 'Человек', 'Хюманович', '1970-01-01');

insert into book_author(book_id, author_id) VALUES (1, 2);
insert into book_author(book_id, author_id) VALUES (2, 5);
insert into book_author(book_id, author_id) VALUES (3, 1);
insert into book_author(book_id, author_id) VALUES (4, 1);
insert into book_author(book_id, author_id) VALUES (5, 2);
insert into book_author(book_id, author_id) VALUES (6, 6);
insert into book_author(book_id, author_id) VALUES (7, 7);
insert into book_author(book_id, author_id) VALUES (8, 4);
insert into book_author(book_id, author_id) VALUES (9, 3);
insert into book_author(book_id, author_id) VALUES (9, 7);

insert into genres (name) values ('Comedy');
insert into genres (name) values ('Science Fiction');
insert into genres (name) values ('Adventure');
insert into genres (name) values ('Romance');
insert into genres (name) values ('Biography');
insert into genres (name) values ('Health');
insert into genres (name) values ('Triller');
insert into genres (name) values ('Mystery');
insert into genres (name) values ('Horror');
insert into genres (name) values ('Children story');
insert into genres (name) values ('Folk');


insert into book_genre(book_id, genre_id) VALUES (1,3);
insert into book_genre(book_id, genre_id) VALUES (1,6);
insert into book_genre(book_id, genre_id) VALUES (1,7);
insert into book_genre(book_id, genre_id) VALUES (2,8);
insert into book_genre(book_id, genre_id) VALUES (2,2);
insert into book_genre(book_id, genre_id) VALUES (3,10);
insert into book_genre(book_id, genre_id) VALUES (4,5);
insert into book_genre(book_id, genre_id) VALUES (5,3);
insert into book_genre(book_id, genre_id) VALUES (5,6);
insert into book_genre(book_id, genre_id) VALUES (5,7);
insert into book_genre(book_id, genre_id) VALUES (6,4);
insert into book_genre(book_id, genre_id) VALUES (7,2);
insert into book_genre(book_id, genre_id) VALUES (8,6);
insert into book_genre(book_id, genre_id) VALUES (9,11);

insert into users(login, password, user_role, is_blocked) values ('admin', '$2a$10$DvMujX4R9FujaLD1/SpHbuMPFBWAi6uMuJaolRY2Lj3E/TTQZfFrC', 'ROLE_ADMIN', false);
insert into users(login, password, user_role, is_blocked) values ('login1', '$2a$10$c6yNfyzgwCrm6GrtQUUrBufNAIF4dKXe9dYLaV6qfrxKuhwwe0O1O', 'ROLE_USER', false);
insert into users(login, password, user_role, is_blocked) values ('login2', '$2a$10$/mDvEo4ayKMElFaSldzx4eDx0D6/KIQJ8x3sqaXAVYgLh3ohtf.O.', 'ROLE_USER', false);
insert into users(login, password, user_role, is_blocked) values ('login3', '$2a$10$rbwUORNndz2URdCde4OjNeYiHzTFNzho.keM8/cu5t2ahZGXH.nNW', 'ROLE_USER', false);
insert into users(login, password, user_role, is_blocked) values ('login4', '$2a$10$fco2zE5RRhMbVZlKPpCqfuzXI3x9g4MxGGEWbLT7yMt1KDAmoCC6m', 'ROLE_USER', false);
insert into users(login, password, user_role, is_blocked) values ('login5', '$2a$10$prP./N3F8AS5mwGJjITTQe5wukYR4k0NgVpnhViYFBCNQZi7QhmRe', 'ROLE_USER', false);
insert into users(login, password, user_role, is_blocked) values ('login6', '$2a$10$EGDKkU2EmYB6fFIYtZvD8ugl6kXYARj7fmNH2Xqs1bdMVAOQ/Zv6q', 'ROLE_USER', false);
insert into users(login, password, user_role, is_blocked) values ('login7', '$2a$10$hnbNvffCRKU8nviXlL.ggOnrbZBVm0oKJgL7BU4Hsdb0L1xvepHym', 'ROLE_USER', false);
insert into users(login, password, user_role, is_blocked) values ('login8', '$2a$10$BU6m7vzQ3F5izWY9QhMN1erHvz9B.DakdcEIRox3hkPrC1.TIbN8G', 'ROLE_USER', false);
insert into users(login, password, user_role, is_blocked) values ('login9', '$2a$10$dGNJB0NddvBsG1U8l98Wou9wUI71NVVat/cui36BSUcW9lcus6Fay', 'ROLE_USER', false);
insert into users(login, password, user_role, is_blocked) values ('login10', '$2a$10$Wd/Tm3hfxwz/HHBQ4nEI2e4n27dYRkdLArKTNUWlkSA/.rNm4lBL6', 'ROLE_USER', true);

insert into orders(user_id, order_status, ordered_at) values (1, 'CREATED', NOW());
insert into orders(user_id, order_status, ordered_at) values (2, 'PROCESSING', NOW());
insert into orders(user_id, order_status, ordered_at) values (3, 'COMPLETED', NOW());
insert into orders(user_id, order_status, ordered_at) values (1, 'CANCELLED', NOW());

insert into order_book(order_id, book_id) values (1, 1);
insert into order_book(order_id, book_id) values (1, 2);
insert into order_book(order_id, book_id) values (1, 3);
insert into order_book(order_id, book_id) values (2, 8);
insert into order_book(order_id, book_id) values (3, 9);
insert into order_book(order_id, book_id) values (4, 5);

