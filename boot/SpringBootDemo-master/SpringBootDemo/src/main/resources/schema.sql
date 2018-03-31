create table UserInfo (

username varchar(50) primary key,
password varchar(50) not null


);

create table Roles(

rolename  varchar(50) primary key,
username   varchar(50) references UserInfo (username)

);
