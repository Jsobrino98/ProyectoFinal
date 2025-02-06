CREATE database IF NOT exists CompetenciasDeportivas;

use CompetenciasDeportivas;

-- Crear tabla de Torneos
CREATE TABLE torneos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,
    ubicacion VARCHAR(255)
);

-- Crear tabla de Equipos
CREATE TABLE equipos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    ciudad VARCHAR(255),
    torneo_id BIGINT,
    FOREIGN KEY (torneo_id) REFERENCES torneos(id)
);

-- Crear tabla de Jugadores
CREATE TABLE jugadores (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    edad INT,
    posicion VARCHAR(255),
    equipo_id BIGINT,
    FOREIGN KEY (equipo_id) REFERENCES equipos(id)
);

-- Crear tabla de Partidos
CREATE TABLE partidos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    equipo_local_id BIGINT,
    equipo_visitante_id BIGINT,
    torneo_id BIGINT,
    FOREIGN KEY (equipo_local_id) REFERENCES equipos(id),
    FOREIGN KEY (equipo_visitante_id) REFERENCES equipos(id),
    FOREIGN KEY (torneo_id) REFERENCES torneos(id)
);

-- Crear tabla de Resultados
CREATE TABLE resultados (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    partido_id BIGINT,
    goles_local INT,
    goles_visitante INT,
    FOREIGN KEY (partido_id) REFERENCES partidos(id)
);