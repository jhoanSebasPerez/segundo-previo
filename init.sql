CREATE DATABASE IF NOT EXISTS sistema;

USE sistema;

create table if not exists users
(
    id int auto_increment primary key,
    name    varchar(45) not null,
    email   varchar(45) not null,
    country varchar(45) not null
);


