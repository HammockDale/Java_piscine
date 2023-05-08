INSERT INTO chat.Users (login, password, roomsId, chatRoomsId) VALUES ('Misha','pass123', '{1,2}', '{1, 2, 4}');
INSERT INTO chat.Users (login, password, roomsId, chatRoomsId) VALUES ('Sasha','111', '{3}', '{3, 1}');
INSERT INTO chat.Users (login, password, roomsId, chatRoomsId) VALUES ('Sveta','qwerty', '{}', '{1, 2, 3, 4}');
INSERT INTO chat.Users (login, password, roomsId, chatRoomsId) VALUES ('Olga','pass', '{4, 5}', '{1, 4, 5}');
INSERT INTO chat.Users (login, password, roomsId, chatRoomsId) VALUES ('Alex','555', '{}', '{1, 2, 3}');

INSERT INTO chat.Chatroom (name, owner, messages) VALUES ('Libft', 1, '{1, 2, 6}');
INSERT INTO chat.Chatroom (name, owner, messages) VALUES ('Cub3D', 2, '{3, 4}');
INSERT INTO chat.Chatroom (name, owner, messages) VALUES ('Random', 3, '{5, 1, 3}');
INSERT INTO chat.Chatroom (name, owner, messages) VALUES ('General', 4, '{2, 3, 4}');
INSERT INTO chat.Chatroom (name, owner, messages) VALUES ('school42', 5, '{1, 2, 3, 4}');

INSERT INTO chat.Message (author, room, text, dataTime) VALUES (1, 1, 'Hello', '2022-07-08 13:14:00');
INSERT INTO chat.Message (author, room, text, dataTime) VALUES (1, 2, 'Power', '2022-07-08 13:20:00');
INSERT INTO chat.Message (author, room, text, dataTime) VALUES (2, 3, 'Stop', '2022-07-08 13:21:00');
INSERT INTO chat.Message (author, room, text, dataTime) VALUES (1, 4, 'Play', '2022-07-08 13:21:00');
INSERT INTO chat.Message (author, room, text, dataTime) VALUES (3, 5, 'Restart', '2022-07-08 13:21:00');
