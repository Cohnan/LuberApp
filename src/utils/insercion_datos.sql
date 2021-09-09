-- Vehiculos
INSERT INTO vehiculo VALUES('klm 565', 'chevrolet', 'spark', 2015, 5, 'amarillo', 120000);
INSERT INTO vehiculo VALUES('lcs 364', 'chevrolet', 'spark', 2016, 5, 'blanco', 125000);
INSERT INTO vehiculo VALUES('kgh 211', 'kia', 'picanto', 2015, 5, 'amarillo', 80000);
INSERT INTO vehiculo VALUES('pet 363', 'kia', 'rio', 2019, 5, 'blanco', 150000);
INSERT INTO vehiculo VALUES('cul 073', 'renault', 'duster', 2006, 5, 'blanco', 220000);
INSERT INTO vehiculo VALUES('pel 456', 'renault', 'duster', 2015, 5, 'blanco', 130000);

-- Usuarios
INSERT INTO usuario VALUES(454671556, 'Camilo', 'Garcia', 'cgarcia@mail.com');
INSERT INTO usuario VALUES(65448733, 'Ana', 'Riascos', 'ariascos@mail.com');
INSERT INTO usuario VALUES(35448452, 'Pedro', 'Perez', 'pperez@mail.com');
INSERT INTO usuario VALUES(325555451, 'Maria', 'Lopez', 'mlopez@mail.com');
INSERT INTO usuario VALUES(76636633, 'Nelson', 'Ruiz', 'nruiz@mail.com');
INSERT INTO usuario VALUES(64588522, 'Ana', 'Lopez', 'alopez@mail.com');
INSERT INTO usuario VALUES(65544788, 'Carlos', 'Penagos', 'cpenagos@mail.com');
INSERT INTO usuario VALUES(987445125, 'Fredy', 'Bustos', 'fbustos@mail.com');
INSERT INTO usuario VALUES(55987784, 'Viviana', 'Henao', 'vhenao@mail.com');
INSERT INTO usuario VALUES(4548844, 'Claudia', 'Mendez', 'cmendez@mail.com');
INSERT INTO usuario VALUES(55844775, 'Andres', 'Cruz', 'acruz@mail.com');
INSERT INTO usuario VALUES(55488445, 'Luis', 'Rojas', 'lrojas@mail.com');
INSERT INTO usuario VALUES(987367363, 'Jorge', 'Rodriguez', 'jrodriguez@mail.com');
INSERT INTO usuario VALUES(5584669, 'Paola', 'Angulo', 'pangulo@mail.com');

-- Conductores
INSERT INTO conductor VALUES(4548844, "KLM 565");
INSERT INTO conductor VALUES(325555451, "KLM 565");
INSERT INTO conductor VALUES(76636633, "LCS 364");
INSERT INTO conductor VALUES(64588522, "PET 363");
INSERT INTO conductor VALUES(65544788, "PET 363");
INSERT INTO conductor VALUES(55844775, "LCS 364");
INSERT INTO conductor VALUES(55488445, "KGH 211");
INSERT INTO conductor VALUES(987367363, "KGH 211");

-- Viajes
INSERT INTO viaje (usu_cc, con_cc, fecha) VALUES (65448733, 4548844, '2017-10-25 20:00:00');
INSERT INTO viaje (usu_cc, con_cc, fecha) VALUES (65448733, 325555451, '2019-03-15 18:30:00');
INSERT INTO viaje (usu_cc, con_cc, fecha) VALUES (65448733, 55844775, '2019-05-20 20:30:00');
INSERT INTO viaje (usu_cc, con_cc, fecha) VALUES (35448452, 4548844, '2018-05-20 20:30:00');
INSERT INTO viaje (usu_cc, con_cc, fecha) VALUES (35448452, 55844775, '2020-01-20 20:30:00');
INSERT INTO viaje (usu_cc, con_cc, fecha) VALUES (325555451, 64588522, '2019-05-20 20:30:00');
INSERT INTO viaje (usu_cc, con_cc, fecha) VALUES (325555451, 65544788, '2018-06-22 21:30:00');
INSERT INTO viaje (usu_cc, con_cc, fecha) VALUES (325555451, 55488445, '2020-03-17 15:30:20');
INSERT INTO viaje (usu_cc, con_cc, fecha) VALUES (64588522,  55488445, '2020-03-17 15:30:20');
INSERT INTO viaje (usu_cc, con_cc, fecha) VALUES (64588522, 76636633, '2020-04-10 18:30:20');
INSERT INTO viaje (usu_cc, con_cc, fecha) VALUES (55488445, 987367363, '2020-02-17 20:30:20');
INSERT INTO viaje (usu_cc, con_cc, fecha) VALUES (55488445, 55844775, '2020-02-20 16:30:20');
INSERT INTO viaje (usu_cc, con_cc, fecha) VALUES (55488445, 64588522, '2020-03-27 18:30:20');
INSERT INTO viaje (usu_cc, con_cc, fecha) VALUES (55844775, 64588522, '2020-03-20 21:30:20');
INSERT INTO viaje (usu_cc, con_cc, fecha) VALUES (76636633, 64588522, '2020-01-10 17:30:20');
INSERT INTO viaje (usu_cc, con_cc, fecha) VALUES (76636633, 325555451, '2020-02-15 20:30:20');
INSERT INTO viaje (usu_cc, con_cc, fecha) VALUES (76636633, 987367363, '2020-03-17 18:30:20');