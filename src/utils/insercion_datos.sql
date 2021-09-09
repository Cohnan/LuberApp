-- Vehiculos
INSERT INTO vehiculo(veh_placa, veh_marca, veh_modelo, veh_anio, veh_capacidad, veh_color, veh_kilometros) VALUES('klm 565', 'chevrolet', 'spark', 2015, 5, 'amarillo', 120000);
INSERT INTO vehiculo(veh_placa, veh_marca, veh_modelo, veh_anio, veh_capacidad, veh_color, veh_kilometros) VALUES('lcs 364', 'chevrolet', 'spark', 2016, 5, 'blanco', 125000);
INSERT INTO vehiculo(veh_placa, veh_marca, veh_modelo, veh_anio, veh_capacidad, veh_color, veh_kilometros) VALUES('kgh 211', 'kia', 'picanto', 2015, 5, 'amarillo', 80000);
INSERT INTO vehiculo(veh_placa, veh_marca, veh_modelo, veh_anio, veh_capacidad, veh_color, veh_kilometros) VALUES('pet 363', 'kia', 'rio', 2019, 5, 'blanco', 150000);
INSERT INTO vehiculo(veh_placa, veh_marca, veh_modelo, veh_anio, veh_capacidad, veh_color, veh_kilometros) VALUES('cul 073', 'renault', 'duster', 2006, 5, 'blanco', 220000);
INSERT INTO vehiculo(veh_placa, veh_marca, veh_modelo, veh_anio, veh_capacidad, veh_color, veh_kilometros) VALUES('pel 456', 'renault', 'duster', 2015, 5, 'blanco', 130000);

-- Usuarios
INSERT INTO usuario(usu_cc, usu_nombre, usu_apellido, usu_email) VALUES(454671556, 'Camilo', 'Garcia', 'cgarcia@mail.com');
INSERT INTO usuario(usu_cc, usu_nombre, usu_apellido, usu_email) VALUES(65448733, 'Ana', 'Riascos', 'ariascos@mail.com');
INSERT INTO usuario(usu_cc, usu_nombre, usu_apellido, usu_email) VALUES(35448452, 'Pedro', 'Perez', 'pperez@mail.com');
INSERT INTO usuario(usu_cc, usu_nombre, usu_apellido, usu_email) VALUES(325555451, 'Maria', 'Lopez', 'mlopez@mail.com');
INSERT INTO usuario(usu_cc, usu_nombre, usu_apellido, usu_email) VALUES(76636633, 'Nelson', 'Ruiz', 'nruiz@mail.com');
INSERT INTO usuario(usu_cc, usu_nombre, usu_apellido, usu_email) VALUES(64588522, 'Ana', 'Lopez', 'alopez@mail.com');
INSERT INTO usuario(usu_cc, usu_nombre, usu_apellido, usu_email) VALUES(65544788, 'Carlos', 'Penagos', 'cpenagos@mail.com');
INSERT INTO usuario(usu_cc, usu_nombre, usu_apellido, usu_email) VALUES(987445125, 'Fredy', 'Bustos', 'fbustos@mail.com');
INSERT INTO usuario(usu_cc, usu_nombre, usu_apellido, usu_email) VALUES(55987784, 'Viviana', 'Henao', 'vhenao@mail.com');
INSERT INTO usuario(usu_cc, usu_nombre, usu_apellido, usu_email) VALUES(4548844, 'Claudia', 'Mendez', 'cmendez@mail.com');
INSERT INTO usuario(usu_cc, usu_nombre, usu_apellido, usu_email) VALUES(55844775, 'Andres', 'Cruz', 'acruz@mail.com');
INSERT INTO usuario(usu_cc, usu_nombre, usu_apellido, usu_email) VALUES(55488445, 'Luis', 'Rojas', 'lrojas@mail.com');
INSERT INTO usuario(usu_cc, usu_nombre, usu_apellido, usu_email) VALUES(987367363, 'Jorge', 'Rodriguez', 'jrodriguez@mail.com');
INSERT INTO usuario(usu_cc, usu_nombre, usu_apellido, usu_email) VALUES(5584669, 'Paola', 'Angulo', 'pangulo@mail.com');

-- Conductor
INSERT INTO conductor(usu_cc, veh_placa) VALUES(
					(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Claudia' AND usu_apellido = 'Mendez'),
                    'KLM 565');
INSERT INTO conductor(usu_cc, veh_placa) VALUES(
					(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Maria' AND usu_apellido = 'Lopez'),
                    'KLM 565');
INSERT INTO conductor(usu_cc, veh_placa) VALUES(
					(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Nelson' AND usu_apellido = 'Ruiz'),
                    'LCS 364');
INSERT INTO conductor(usu_cc, veh_placa) VALUES(
					(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Ana' AND usu_apellido = 'Lopez'),
                    'PET 363');
INSERT INTO conductor(usu_cc, veh_placa) VALUES(
					(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Carlos' AND usu_apellido = 'Penagos'),
                    'PET 363');
INSERT INTO conductor(usu_cc, veh_placa) VALUES(
					(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Andres' AND usu_apellido = 'Cruz'),
                    'LCS 364');
INSERT INTO conductor(usu_cc, veh_placa) VALUES(
					(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Luis' AND usu_apellido = 'Rojas'),
                    'KGH 211');
INSERT INTO conductor(usu_cc, veh_placa) VALUES(
					(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Jorge' AND usu_apellido = 'Rodriguez'),
                    'KGH 211');

-- Viaje
INSERT INTO viaje(usu_cc, con_cc, fecha) VALUES(
					(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Ana' AND usu_apellido = 'Riascos'), 
                    (SELECT usu_cc FROM usuario WHERE usu_nombre = 'Claudia' AND usu_apellido = 'Mendez'), -- (SELECT conductor.usu_cc FROM conductor JOIN usuario ON conductor.usu_cc = usuario.usu_cc WHERE usuario.usu_nombre = 'Claudia' AND usuario.usu_apellido = 'Mendez'), 
                    '2017-10-25 20:00:00');
INSERT INTO viaje(usu_cc, con_cc, fecha) VALUES(
					(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Ana' AND usu_apellido = 'Riascos'), 
                    (SELECT usu_cc FROM usuario WHERE usu_nombre = 'Maria' AND usu_apellido = 'Lopez'), 
                    '2019-03-15 18:30:00');
INSERT INTO viaje(usu_cc, con_cc, fecha) VALUES(
					(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Ana' AND usu_apellido = 'Riascos'), 
                    (SELECT usu_cc FROM usuario WHERE usu_nombre = 'Andres' AND usu_apellido = 'Cruz'), 
                    '2019-05-20 20:30:00');
INSERT INTO viaje(usu_cc, con_cc, fecha) VALUES(
					(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Pedro' AND usu_apellido = 'Perez'), 
                    (SELECT usu_cc FROM usuario WHERE usu_nombre = 'Claudia' AND usu_apellido = 'Mendez'), 
                    '2018-05-20 20:30:00');
INSERT INTO viaje(usu_cc, con_cc, fecha) VALUES(
					(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Pedro' AND usu_apellido = 'Perez'), 
                    (SELECT usu_cc FROM usuario WHERE usu_nombre = 'Andres' AND usu_apellido = 'Cruz'), 
                    '2020-01-20 20:30:00');
INSERT INTO viaje(usu_cc, con_cc, fecha) VALUES(
					(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Maria' AND usu_apellido = 'Lopez'), 
                    (SELECT usu_cc FROM usuario WHERE usu_nombre = 'Ana' AND usu_apellido = 'Lopez'), 
                    '2019-05-20 20:30:00');
INSERT INTO viaje(usu_cc, con_cc, fecha) VALUES(
					(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Maria' AND usu_apellido = 'Lopez'), 
                    (SELECT usu_cc FROM usuario WHERE usu_nombre = 'Carlos' AND usu_apellido = 'Penagos'), 
                    '2018-06-22 21:30:00');
INSERT INTO viaje(usu_cc, con_cc, fecha) VALUES(
					(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Maria' AND usu_apellido = 'Lopez'), 
                    (SELECT usu_cc FROM usuario WHERE usu_nombre = 'Luis' AND usu_apellido = 'Rojas'), 
                    '2020-03-17 15:30:20');
INSERT INTO viaje(usu_cc, con_cc, fecha) VALUES(
					(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Ana' AND usu_apellido = 'Lopez'), 
                    (SELECT usu_cc FROM usuario WHERE usu_nombre = 'Luis' AND usu_apellido = 'Rojas'), 
                    '2020-03-17 15:30:20');
INSERT INTO viaje(usu_cc, con_cc, fecha) VALUES(
					(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Ana' AND usu_apellido = 'Lopez'), 
                    (SELECT usu_cc FROM usuario WHERE usu_nombre = 'Nelson' AND usu_apellido = 'Ruiz'), 
                    '2020-04-10 18:30:20');
INSERT INTO viaje(usu_cc, con_cc, fecha) VALUES(
					(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Luis' AND usu_apellido = 'Rojas'), 
                    (SELECT usu_cc FROM usuario WHERE usu_nombre = 'Jorge' AND usu_apellido = 'Rodriguez'), 
                    '2020-02-17 20:30:20');
INSERT INTO viaje(usu_cc, con_cc, fecha) VALUES(
					(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Luis' AND usu_apellido = 'Rojas'), 
                    (SELECT usu_cc FROM usuario WHERE usu_nombre = 'Andres' AND usu_apellido = 'Cruz'), 
                    '2020-02-20 16:30:20');
INSERT INTO viaje(usu_cc, con_cc, fecha) VALUES(
					(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Luis' AND usu_apellido = 'Rojas'), 
                    (SELECT usu_cc FROM usuario WHERE usu_nombre = 'Ana' AND usu_apellido = 'Lopez'), 
                    '2020-03-27 18:30:20');
INSERT INTO viaje(usu_cc, con_cc, fecha) VALUES(
					(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Andres' AND usu_apellido = 'Cruz'), 
                    (SELECT usu_cc FROM usuario WHERE usu_nombre = 'Ana' AND usu_apellido = 'Lopez'), 
                    '2020-03-20 21:30:20');
INSERT INTO viaje(usu_cc, con_cc, fecha) VALUES(
					(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Nelson' AND usu_apellido = 'Ruiz'), 
                    (SELECT usu_cc FROM usuario WHERE usu_nombre = 'Ana' AND usu_apellido = 'Lopez'), 
                    '2020-01-10 17:30:20');
INSERT INTO viaje(usu_cc, con_cc, fecha) VALUES(
					(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Nelson' AND usu_apellido = 'Ruiz'), 
                    (SELECT usu_cc FROM usuario WHERE usu_nombre = 'Maria' AND usu_apellido = 'Lopez'), 
                    '2020-02-15 20:30:20');
INSERT INTO viaje(usu_cc, con_cc, fecha) VALUES(
					(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Nelson' AND usu_apellido = 'Ruiz'), 
                    (SELECT usu_cc FROM usuario WHERE usu_nombre = 'Jorge' AND usu_apellido = 'Rodriguez'), 
                    '2020-03-17 18:30:20');