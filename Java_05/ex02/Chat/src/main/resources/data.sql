INSERT INTO chat.Users (login, password, createdRooms, rooms) VALUES ('Misha','pass123', '{1,2}', '{1, 2, 4}');
INSERT INTO chat.Users (login, password, createdRooms, rooms) VALUES ('Sasha','111', '{3}', '{3, 1}');
INSERT INTO chat.Users (login, password, createdRooms, rooms) VALUES ('Sveta','qwerty', '{}', '{1, 2, 3, 4}');
INSERT INTO chat.Users (login, password, createdRooms, rooms) VALUES ('Olga','pass', '{4, 5}', '{1, 4, 5}');
INSERT INTO chat.Users (login, password, createdRooms, rooms) VALUES ('Alex','555', '{}', '{1, 2, 3}');

INSERT INTO chat.chatroom (name, owner, roomMessages) VALUES ('Libft', 1, '{1, 2, 6}');
INSERT INTO chat.chatroom (name, owner, roomMessages) VALUES ('Cub3D', 2, '{3, 4}');
INSERT INTO chat.chatroom (name, owner, roomMessages) VALUES ('Random', 3, '{5, 1, 3}');
INSERT INTO chat.chatroom (name, owner, roomMessages) VALUES ('General', 4, '{2, 3, 4}');
INSERT INTO chat.chatroom (name, owner, roomMessages) VALUES ('school42', 5, '{1, 2, 3, 4}');

INSERT INTO chat.Message (author, chatroom, text) VALUES (1, 1, 'Hello');
INSERT INTO chat.Message (author, chatroom, text) VALUES (1, 2, 'Power');
INSERT INTO chat.Message (author, chatroom, text) VALUES (2, 3, 'Stop');
INSERT INTO chat.Message (author, chatroom, text) VALUES (1, 4, 'Play');
INSERT INTO chat.Message (author, chatroom, text) VALUES (3, 5, 'Restart');
