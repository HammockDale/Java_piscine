DROP SCHEMA IF EXISTS chat CASCADE;

CREATE SCHEMA IF NOT EXISTS chat;

CREATE TABLE chat.Users (id serial primary key unique, login VARCHAR(20), password VARCHAR(20), createdRooms int[] , rooms int[]);
CREATE TABLE chat.Chatroom (id serial primary key unique, name VARCHAR(20), owner int not null references chat.Users(id), roomMessages int[]);
CREATE TABLE chat.Message (id serial primary key unique, author int not null references chat.Users(id), chatroom int not null references chat.chatroom(id), text TEXT, messageDateTime timestamp(0) default now());
