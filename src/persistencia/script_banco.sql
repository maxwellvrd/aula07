create schema if not exists aula07;

use aula07;

create or replace table aluno(
	id bigint primary key auto_increment,
	matricula int not null,
	nome varchar(150) not null,
	email varchar (200) not null,
	nota01 float8,
	nota02 float8
);

+-----------+--------------+------+-----+---------+----------------+
| Field     | Type         | Null | Key | Default | Extra          |
+-----------+--------------+------+-----+---------+----------------+
| id        | bigint(20)   | NO   | PRI | NULL    | auto_increment |
| matricula | int(11)      | NO   |     | NULL    |                |
| nome      | varchar(150) | NO   |     | NULL    |                |
| email     | varchar(200) | NO   |     | NULL    |                |
| nota01    | double       | YES  |     | NULL    |                |
| nota02    | double       | YES  |     | NULL    |                |
+-----------+--------------+------+-----+---------+----------------+

desc aluno;

/* insere dados na tabela*/ 
insert into aluno values(null, 1234, "Max", "max@hotmail.com", 9.8, 9.9);

/* */ 
select * from aluno;