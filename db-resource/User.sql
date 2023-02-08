use mydb;

drop table if exists user;

create table if not exists user(id int not null primary key, name varchar(20), email varchar(30));

select * from user;

INSERT INTO user VALUES(1, 'Gorazd', 'gorazd.murko@gmail.com');

delete from user where id=6;

update user set name='Gorazd Murko', email='gorazd@murko.si' where id=2;