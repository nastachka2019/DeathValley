create table user
(
    userId  int auto_increment
        primary key,
    name    varchar(45) not null,
    surname varchar(45) not null
);

create table account
(
    accountId   int auto_increment
        primary key,
    accountUser int not null,
    userId      int not null,
    constraint user_id_fk
        foreign key (userId) references user (userId)
            on update cascade on delete cascade
);

create index user_id_fk_idx
    on account (userId);

insert into user (name, surname) VALUES ("Anna", "Smith");
insert into user (name, surname) VALUES ("Kate", "Jonson");
insert into user (name, surname) VALUES ("Jack", "Williams");
insert into user (name, surname) VALUES ("Alex", "Jones");
insert into user (name, surname) VALUES ("Davis", "Brown");
insert into user (name, surname) VALUES ("David", "Miller");
insert into user (name, surname) VALUES ("Leo", "Willson");
insert into user (name, surname) VALUES ("Monica", "Taylor");
insert into user (name, surname) VALUES ("Kate", "Anderson");
insert into user (name, surname) VALUES ("Anna", "Brown");
insert into user (name, surname) VALUES ("Jane", "Martin");

insert into account (accountUser, userId) VALUES (100, 3);
insert into account (accountUser, userId) VALUES (120, 1);
insert into account (accountUser, userId) VALUES (30, 5);
insert into account (accountUser, userId) VALUES (70, 9);
insert into account (accountUser, userId) VALUES (85, 10);
insert into account (accountUser, userId) VALUES (130, 2);
insert into account (accountUser, userId) VALUES (70, 8);
insert into account (accountUser, userId) VALUES (180, 4);
insert into account (accountUser, userId) VALUES (125, 7);
insert into account (accountUser, userId) VALUES (90, 11);
insert into account (accountUser, userId) VALUES (110, 6);
