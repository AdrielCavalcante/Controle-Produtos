CREATE DATABASE projetofinaljava;

CREATE TABLE produto(
id int PRIMARY KEY auto_increment,
nome varchar(80) not null,
quantidade int not null,
preco double not null
);
