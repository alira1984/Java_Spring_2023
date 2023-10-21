drop schema if exists spring;

drop user if exists 'user'@'localhost';

create schema spring;

create user 'user'@'localhost' identified by 'pass123';

grant select, insert, delete, update on spring.* to user@'localhost';

use spring;

create table usr_usuario (
    usr_id bigint unsigned not null auto_increment,
    usr_nome varchar(20) not null,
    usr_senha varchar(150) not null,
    primary key (usr_id),
    unique key uni_usuario_nome (usr_nome)
);

create table aut_autorizacao (
    aut_id bigint unsigned not null auto_increment,
    aut_nome varchar(20) not null,
    primary key (aut_id),
    unique key uni_aut_nome (aut_nome)
);
create table uau_usuario_autorizacao (
    usr_id bigint unsigned not null,
    aut_id bigint unsigned not null,
    primary key (usr_id, aut_id),
    foreign key aut_usuario_fk (usr_id) references usr_usuario (usr_id) on delete restrict on update cascade,
    foreign key aut_autorizacao_fk (aut_id) references aut_autorizacao (aut_id) on delete restrict on update cascade
);
create table ant_anotacao (
    ant_id bigint unsigned not null auto_increment,
    ant_texto varchar(256) not null,
    ant_data_hora datetime not null,
    ant_usr_id bigint unsigned not null,
    primary key (ant_id),
    foreign key ant_usr_fk (ant_usr_id) references usr_usuario(usr_id)
);
create table emp_empregado (
 emp_id bigint primary key auto_increment,
 emp_nome_completo varchar(100) not null,
 emp_ctps bigint not null,
 emp_data_hora_cadastro datetime not null,
 emp_email varchar(30) not null,
 emp_carga_horaria float
);

insert into emp_empregado (emp_nome_completo, emp_ctps, emp_data_hora_cadastro, emp_email)
 values ('Charles Smith', 12345678910, current_timestamp(), 'chsmith@email.com'),
 ('Ann Doe', 23456743212, current_timestamp(), 'anndoe@email.com');

insert into usr_usuario (usr_nome, usr_senha)
    values ('admin', '$2a$10$i3.Z8Yv1Fwl0I5SNjdCGkOTRGQjGvHjh/gMZhdc3e7LIovAklqM6C');
insert into aut_autorizacao (aut_nome)
    values ('ROLE_ADMIN');
insert into uau_usuario_autorizacao (usr_id, aut_id)
    values (1, 1);
insert into ant_anotacao(ant_texto, ant_data_hora, ant_usr_id)
    values('Meu novo projeto', '2023-08-01 19:10', 1);