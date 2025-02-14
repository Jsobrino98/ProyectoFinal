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

-- Insertar torneos en la base de datos --
INSERT INTO torneos (nombre, fecha_inicio, fecha_fin, ubicacion, logo_url)
VALUES
('Premier League', '2024-08-01', '2025-05-15', 'Inglaterra', NULL),
('Championship', '2024-08-01', '2025-05-15', 'Inglaterra', NULL),
('Scottish Premiership', '2024-08-01', '2025-05-15', 'Escocia', NULL),
('Bundesliga', '2024-08-10', '2025-05-20', 'Alemania', NULL),
('Serie A', '2024-08-15', '2025-05-25', 'Italia', NULL),
('Ligue 1', '2024-08-05', '2025-05-18', 'Francia', NULL),
('LaLiga', '2024-08-12', '2025-05-22', 'España', NULL),
('Superliga de Grecia', '2024-08-10', '2025-05-20', 'Grecia', NULL),
('Eredivisie', '2024-08-10', '2025-05-20', 'Países Bajos', NULL),
('Jupiler Pro League', '2024-08-10', '2025-05-20', 'Bélgica', NULL),
('Süper Lig', '2024-08-10', '2025-05-20', 'Turquía', NULL),
('Superliga Danesa', '2024-08-10', '2025-05-20', 'Dinamarca', NULL),
('Primeira Liga', '2024-08-10', '2025-05-20', 'Portugal', NULL),
('MLS', '2024-02-25', '2024-12-15', 'Estados Unidos', NULL),
('Allsvenskan', '2024-04-01', '2024-11-15', 'Suecia', NULL),
('Liga MX', '2024-07-20', '2025-05-30', 'México', NULL),
('Brasileirão', '2024-04-15', '2024-12-10', 'Brasil', NULL),
('Liga Premier de Ucrania', '2024-08-10', '2025-05-20', 'Ucrania', NULL),
('Liga Premier de Rusia', '2024-08-10', '2025-05-20', 'Rusia', NULL),
('A-League', '2024-10-01', '2025-05-31', 'Australia', NULL),
('Eliteserien', '2024-04-10', '2024-11-20', 'Noruega', NULL),
('Superliga China', '2024-03-01', '2024-11-30', 'China', NULL),
('Serie B', '2024-08-10', '2025-05-20', 'Italia', NULL),
('Scottish Championship', '2024-08-10', '2025-05-20', 'Escocia', NULL),
('League One', '2024-08-10', '2025-05-20', 'Inglaterra', NULL),
('League Two', '2024-08-10', '2025-05-20', 'Inglaterra', NULL),
('Serie C', '2024-08-10', '2025-05-20', 'Italia', NULL),
('2. Bundesliga', '2024-08-10', '2025-05-20', 'Alemania', NULL),
('LaLiga 2', '2024-08-10', '2025-05-20', 'España', NULL),
('Ligue 2', '2024-08-10', '2025-05-20', 'Francia', NULL),
('Superettan', '2024-04-01', '2024-11-15', 'Suecia', NULL),
('Brasileirão Serie B', '2024-04-15', '2024-12-10', 'Brasil', NULL),
('Liga Profesional Argentina', '2024-07-15', '2025-05-30', 'Argentina', NULL);



-- PARA BUSCAR UN LOGO DE UNA LIGA --
    -- https://cdn.footystats.org/img/competitions/[nombre_de_la_liga].png  --




-- Equipos LaLiga --

INSERT INTO equipos (id, nombre, ciudad, torneo_id, escudoURL) VALUES
(21, 'Athletic Club', 'Bilbao', 7, 'https://assets.laliga.com/assets/2019/06/07/xsmall/athletic.png'),
(22, 'Atlético de Madrid', 'Madrid', 7, 'https://d2bk74em32frqb.cloudfront.net/assets/2024/06/17/xsmall/cbc5c8cc8c3e8abd0e175c00ee53b723.png'),
(23, 'CA Osasuna', 'Pamplona', 7, 'https://d2bk74em32frqb.cloudfront.net/assets/2019/06/07/xsmall/osasuna.png'),
(24, 'CD Leganés', 'Leganés', 7, 'https://d2bk74em32frqb.cloudfront.net/assets/2019/06/07/xsmall/leganes.png'),
(25, 'Deportivo Alavés', 'Vitoria-Gasteiz', 7, 'https://d2bk74em32frqb.cloudfront.net/assets/2020/09/01/xsmall/27002754a98bf535807fe49a24cc63ea.png'),
(26, 'FC Barcelona', 'Barcelona', 7, 'https://assets.laliga.com/assets/2019/06/07/xsmall/barcelona.png'),
(27, 'Getafe CF', 'Getafe', 7, 'https://assets.laliga.com/assets/2023/05/12/xsmall/dc59645c96bc2c9010341c16dd6d4bfa.png'),
(28, 'Girona FC', 'Girona', 7, 'https://assets.laliga.com/assets/2022/06/22/xsmall/8f43addbb29e4a72f5e90b6edfe4728f.png'),
(29, 'Rayo Vallecano', 'Madrid', 7, 'https://assets.laliga.com/assets/2023/04/27/xsmall/57d9950a8745ead226c04d37235c0786.png'),
(30, 'RC Celta', 'Vigo', 7, 'https://d2bk74em32frqb.cloudfront.net/assets/2019/06/07/xsmall/celta.png'),
(31, 'RCD Espanyol de Barcelona', 'Cornellà de Llobregat', 7, 'https://d2bk74em32frqb.cloudfront.net/assets/2019/06/07/xsmall/espanyol.png'),
(32, 'RCD Mallorca', 'Palma de Mallorca', 7, 'https://assets.laliga.com/assets/2023/03/22/xsmall/013ae97735bc8e519dcf30f6826168ca.png'),
(33, 'Real Betis', 'Sevilla', 7, 'https://assets.laliga.com/assets/2022/09/15/xsmall/e4a09419d3bd115b8f3dab73d480e146.png'),
(34, 'Real Madrid', 'Madrid', 7, 'https://assets.laliga.com/assets/2019/06/07/xsmall/real-madrid.png'),
(35, 'Real Sociedad', 'San Sebastián', 7, 'https://assets.laliga.com/assets/2019/06/07/xsmall/real-sociedad.png'),
(36, 'Real Valladolid CF', 'Valladolid', 7, 'https://assets.laliga.com/assets/2024/06/17/xsmall/1467dcd5efb813a742d86f8eb39504a3.png'),
(37, 'Sevilla FC', 'Sevilla', 7, 'https://assets.laliga.com/assets/2019/06/07/xsmall/sevilla.png'),
(38, 'UD Las Palmas', 'Las Palmas de Gran Canaria', 7, 'https://assets.laliga.com/assets/2019/06/07/xsmall/las-palmas.png'),
(39, 'Valencia CF', 'Valencia', 7, 'https://assets.laliga.com/assets/2019/06/07/xsmall/valencia.png'),
(40, 'Villarreal CF', 'Villarreal', 7, 'https://assets.laliga.com/assets/2019/06/07/xsmall/villarreal.png');


-- Equipos Serie A --
INSERT INTO equipos (id, nombre, ciudad, torneo_id, escudoURL) VALUES
(41, 'Nápoles', 'Nápoles', 5, 'https://www.legaseriea.it/img/loghi/NAPOLI.svg'),
(42, 'Inter de Milán', 'Milán', 5, 'https://www.legaseriea.it/img/loghi/INTER.svg'),
(43, 'Atalanta', 'Bérgamo', 5, 'https://www.legaseriea.it/img/loghi/ATALANTA.svg'),
(44, 'Lazio', 'Roma', 5, 'https://www.legaseriea.it/img/loghi/LAZIO.svg'),
(45, 'Juventus', 'Turín', 5, 'https://www.legaseriea.it/img/loghi/JUVENTUS.svg'),
(46, 'Fiorentina', 'Florencia', 5, 'https://www.legaseriea.it/img/loghi/FIORENTINA.svg'),
(47, 'AC Milan', 'Milán', 5, 'https://www.legaseriea.it/img/loghi/MILAN.svg'),
(48, 'Bolonia', 'Bolonia', 5, 'https://www.legaseriea.it/img/loghi/BOLOGNA.svg'),
(49, 'Roma', 'Roma', 5, 'https://www.legaseriea.it/img/loghi/ROMA.svg'),
(50, 'Udinese', 'Údine', 5, 'https://www.legaseriea.it/img/loghi/UDINESE.svg'),
(51, 'Torino', 'Turín', 5, 'https://www.legaseriea.it/img/loghi/TORINO.svg'),
(52, 'Génova', 'Génova', 5, 'https://www.legaseriea.it/img/loghi/GENOA.svg'),
(53, 'Cagliari', 'Cagliari', 5, 'https://www.legaseriea.it/img/loghi/CAGLIARI.svg'),
(54, 'Lecce', 'Lecce', 5, 'https://www.legaseriea.it/img/loghi/LECCE.svg'),
(55, 'Hellas Verona', 'Verona', 5, 'https://www.legaseriea.it/img/loghi/VERONA.svg'),
(56, 'Como 1907', 'Como', 5, 'https://www.legaseriea.it/img/loghi/COMO.svg'),
(57, 'Empoli', 'Empoli', 5, 'https://www.legaseriea.it/img/loghi/EMPOLI.svg'),
(58, 'Parma', 'Parma', 5, 'https://www.legaseriea.it/img/loghi/PARMA.svg'),
(59, 'Venezia', 'Venecia', 5, 'https://www.legaseriea.it/img/loghi/VENEZIA.svg'),
(60, 'Monza', 'Monza', 5, 'https://www.legaseriea.it/img/loghi/MONZA.svg');




