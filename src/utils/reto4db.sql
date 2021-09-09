-- Creacion y acceso a base de datos dedicada al reto 4
CREATE SCHEMA IF NOT EXISTS reto4db;
USE reto4db;

-- Eliminacion de tablas que se van a usar, en caso de ser necesario
DROP TABLE IF EXISTS viaje;		
DROP TABLE IF EXISTS conductor; -- Su eliminacion requiere la eliminacion previa de viaje, i.e. viaje necesita de conductor
DROP TABLE IF EXISTS usuario; 	-- Su eliminacion requiere la eliminacion previa de viaje, conductor
DROP TABLE IF EXISTS vehiculo; 	-- Su eliminacion requiere la eliminacion previa de viaje, conductor

-- Creacion de tablas a usar
CREATE TABLE vehiculo ( -- No foreign keys
	veh_placa CHAR(7) PRIMARY KEY NOT NULL,
    veh_marcha CHAR(15) NOT NULL,
    veh_modelo CHAR(15) NOT NULL,
    veh_anio SMALLINT(6) NOT NULL,
    veh_capacidad TINYINT(4) NOT NULL,
	veh_color CHAR(15) NOT NULL,
    veh_kilometros INT(11) NOT NULL
);

CREATE TABLE usuario ( -- No foreign keys
	usu_cc INT(11) PRIMARY KEY NOT NULL,
    usu_nombre CHAR(20),
    usu_apellido CHAR(20),
    usu_email CHAR(60)
);

CREATE TABLE conductor (
	usu_cc INT(11) PRIMARY KEY NOT NULL,
    veh_placa CHAR(7) NOT NULL, -- Deberia ser not null, PERO en el diagrama aparece como null
    
    FOREIGN KEY (usu_cc) REFERENCES usuario(usu_cc),
    FOREIGN KEY (veh_placa) REFERENCES vehiculo(veh_placa)
);

CREATE TABLE viaje (
	via_id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    usu_cc INT(11) NOT NULL,
    con_cc INT(11) NOT NULL,
    fecha DATETIME,
    
    FOREIGN KEY (usu_cc) REFERENCES usuario(usu_cc),
    FOREIGN KEY (con_cc) REFERENCES conductor(usu_cc)
);