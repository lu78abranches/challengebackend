create table depoimentos(

    id bigint not null auto_increment,
    foto varchar(100) not null,
    depoimento varchar(200) not null,
    nome varchar(100) not null,

    primary key(id)
);