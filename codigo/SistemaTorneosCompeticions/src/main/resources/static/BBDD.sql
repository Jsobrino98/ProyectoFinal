CREATE DATABASE IF NOT EXISTS CompetenciasDeportivas;
USE CompetenciasDeportivas;

-- Tabla de Torneos
CREATE TABLE torneos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,
    ubicacion VARCHAR(255)
);

-- Tabla de Equipos
CREATE TABLE equipos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    ciudad VARCHAR(255)
);

-- Relación Muchos a Muchos entre Equipos y Torneos
CREATE TABLE equipo_torneo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    equipo_id BIGINT,
    torneo_id BIGINT,
    FOREIGN KEY (equipo_id) REFERENCES equipos(id) ON DELETE CASCADE,
    FOREIGN KEY (torneo_id) REFERENCES torneos(id) ON DELETE CASCADE
);

-- Tabla de Jugadores
CREATE TABLE jugadores (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    edad INT,
    posicion VARCHAR(255),
    equipo_id BIGINT,
    FOREIGN KEY (equipo_id) REFERENCES equipos(id) ON DELETE SET NULL
);

-- Tabla de Partidos
CREATE TABLE partidos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    equipo_local_id BIGINT,
    equipo_visitante_id BIGINT,
    torneo_id BIGINT,
    FOREIGN KEY (equipo_local_id) REFERENCES equipos(id) ON DELETE CASCADE,
    FOREIGN KEY (equipo_visitante_id) REFERENCES equipos(id) ON DELETE CASCADE,
    FOREIGN KEY (torneo_id) REFERENCES torneos(id) ON DELETE CASCADE,
    CONSTRAINT chk_equipos_diferentes CHECK (equipo_local_id <> equipo_visitante_id) -- Restricción para evitar que un equipo juegue contra sí mismo
);

-- Tabla de Resultados
CREATE TABLE resultados (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    partido_id BIGINT,
    goles_local INT,
    goles_visitante INT,
    ganador_id BIGINT NULL, -- Nuevo campo para guardar el equipo ganador
    FOREIGN KEY (partido_id) REFERENCES partidos(id) ON DELETE CASCADE,
    FOREIGN KEY (ganador_id) REFERENCES equipos(id) ON DELETE SET NULL
);


-- Añadir columnas para guardar imagenes de los equipos y torneos --
ALTER TABLE equipos ADD COLUMN escudo_url VARCHAR(500);
ALTER TABLE torneos ADD COLUMN logo_url VARCHAR(500);