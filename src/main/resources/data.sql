-- Insertar datos en la tabla game
INSERT INTO game (nombre_juego, fecha_salida, valoracion_personal, caratula)
VALUES ('Call of duty 4 modern warfare', '05-11-2007', 'Muy bueno', 'caratula1.jpg'),
       ('Super Mario galaxy', '01-11-2007', 'Bueno', 'caratula2.jpg'),
       ('Apex Legends', '2023-07-01', 'Regular', 'caratula3.jpg'),
       ('The Legend of Zelda: Breath of the Wild', '2017-03-03', 'Excelente', 'caratula4.jpg'),
       ('Red Dead Redemption 2', '2018-10-26', 'Muy bueno', 'caratula5.jpg'),
       ('The Witcher 3: Wild Hunt', '2015-05-19', 'Excelente', 'caratula6.jpg'),
       ('God of War', '2018-04-20', 'Increíble', 'caratula7.jpg'),
       ('Minecraft', '2011-11-18', 'Divertido', 'caratula8.jpg'),
       ('Fortnite', '2017-07-21', 'Adictivo', 'caratula9.jpg'),
       ('Among Us', '2018-06-15', 'Entretenido', 'caratula10.jpg'),
       ('Cyberpunk 2077', '2020-12-10', 'Controversial', 'caratula11.jpg'),
       ('Animal Crossing: New Horizons', '2020-03-20', 'Encantador', 'caratula12.jpg'),
       ('Hades', '2020-09-17', 'Muy bueno', 'caratula13.jpg'),
       ('Doom Eternal', '2020-03-20', 'Intenso', 'caratula14.jpg');

-- Insertar datos en la tabla user
INSERT INTO "user" (email, password)
VALUES ('user1@example.com', 'password1'),
       ('user2@example.com', 'password2'),
       ('user3@example.com', 'password3');

-- Insertar datos en la tabla de unión user_game
INSERT INTO user_game (user_id, game_id)
VALUES (1, 1),
       (1, 2),
       (2, 2),
       (2, 3),
       (3, 1),
       (3, 3),
       (1, 4),
       (1, 5),
       (2, 6),
       (2, 7),
       (3, 8),
       (3, 9),
       (1, 10),
       (2, 11),
       (3, 12),
       (1, 13),
       (2, 14);