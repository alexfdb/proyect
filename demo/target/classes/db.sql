DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS departamento;

CREATE TABLE departamento (
    id INTEGER PRIMARY KEY,
    nombre TEXT NOT NULL
);

CREATE TABLE user (
    id INTEGER PRIMARY KEY,
    id_departamento INTEGER NOT NULL,
    nombre TEXT NOT NULL,
    fecha DATE NOT NULL,
    sueldo REAL NOT NULL,
    FOREIGN KEY (id_departamento) REFERENCES departamento(id)
);

INSERT INTO departamento (id, nombre) VALUES (1, 'Recursos Humanos');
INSERT INTO departamento (id, nombre) VALUES (2, 'Ingeniería');
INSERT INTO departamento (id, nombre) VALUES (3, 'Marketing');

INSERT INTO user (id, id_departamento, nombre, fecha, sueldo)
VALUES (1, 1, 'Ana Torres', '1990-05-20', 3500.75);

INSERT INTO user (id, id_departamento, nombre, fecha, sueldo)
VALUES (2, 2, 'Luis Fernández', '1988-03-15', 4200.00);

INSERT INTO user (id, id_departamento, nombre, fecha, sueldo)
VALUES (3, 1, 'Marta López', '1992-11-01', 3100.50);

INSERT INTO user (id, id_departamento, nombre, fecha, sueldo)
VALUES (4, 3, 'Carlos Díaz', '1995-07-25', 2800.00);