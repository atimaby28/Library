use library;

create table user
(
	id bigint auto_increment,
    name varchar(25),
    age int,
    primary key (id)
);

create table book
(
	id bigint auto_increment,
    name varchar(255) not null,
    primary key(id)
);

create table user_loan_history
(
    id bigint auto_increment,
    user_id bigint,
    book_name varchar(255),
    is_return tinyint(1),
    primary key (id)
);