CREATE DATABASE IF NOT EXISTS CompetenciasDeportivas;
USE CompetenciasDeportivas;

-- Tabla de Torneos
CREATE TABLE torneos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,
    ubicacion VARCHAR(255),
    logo_competicion VARCHAR(255)  -- Logo de la competición
);

-- Tabla de Equipos
CREATE TABLE equipos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    ciudad VARCHAR(255),
    escudo_url VARCHAR(255),
    torneo_id BIGINT,                  -- Relación con un torneo específico
    competicion_secundaria_id BIGINT,    -- Relación con competición secundaria, si aplica
    FOREIGN KEY (torneo_id) REFERENCES torneos(id) ON DELETE SET NULL,
    FOREIGN KEY (competicion_secundaria_id) REFERENCES torneos(id) ON DELETE SET NULL
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
    FOREIGN KEY (torneo_id) REFERENCES torneos(id) ON DELETE CASCADE
);

-- Tabla de Usuarios
CREATE TABLE usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre_usuario VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    nombre_completo VARCHAR(255),
    email VARCHAR(255) NOT NULL UNIQUE,
    rol ENUM('ADMIN', 'NORMAL') NOT NULL  -- Role: ADMIN or NORMAL
);
-- Tabla de equipo_torneo (Relación Muchos a Muchos entre Equipos y Torneos)
CREATE TABLE equipo_torneo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    equipo_id BIGINT,
    torneo_id BIGINT,
    FOREIGN KEY (equipo_id) REFERENCES equipos(id) ON DELETE CASCADE,
    FOREIGN KEY (torneo_id) REFERENCES torneos(id) ON DELETE CASCADE
);

-- SCRIPT LIGAS --
INSERT INTO torneos (id, nombre, fecha_inicio, fecha_fin, ubicacion, logo_competicion) VALUES
(1, 'Premier League', '2024-08-01', '2025-05-15', 'Inglaterra', 'https://paladarnegro.net/escudoteca/ligas/ligas/img/inglaterra.jpg'),
(2, 'Championship', '2024-08-01', '2025-05-15', 'Inglaterra', 'https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEi1bk0O8YLTBWWxw7VhEt1EfVuD5x0T82VwElx-a1RZ2bEpEKfbmYFQi_byHriYeVilszvBoS_9I3ERvhakAGIrDQO6IaavhuC1UipS5prP36qLGVZE4vpTJ4VSQhm6y-nnmt9eq-ld4w/s320/Sky+Bet+Championship.png'),
(3, 'Scottish Premiership', '2024-08-01', '2025-05-15', 'Escocia', 'https://paladarnegro.net/escudoteca/ligas/ligas/img/escocia.jpg'),
(4, 'Bundesliga', '2024-08-10', '2025-05-20', 'Alemania', 'https://paladarnegro.net/escudoteca/ligas/ligas/img/alemania.jpg'),
(5, 'Serie A', '2024-08-15', '2025-05-25', 'Italia', 'https://paladarnegro.net/escudoteca/ligas/ligas/img/italia.jpg'),
(6, 'Ligue 1', '2024-08-05', '2025-05-18', 'Francia', 'https://paladarnegro.net/escudoteca/ligas/ligas/img/francia.jpg'),
(7, 'LaLiga', '2024-08-12', '2025-05-22', 'España', 'https://assets.laliga.com/assets/public/logospage/pressroom/laliga/LL_RGB_h_color.png'),
(8, 'Superliga de Grecia', '2024-08-10', '2025-05-20', 'Grecia', 'https://paladarnegro.net/escudoteca/ligas/ligas/img/grecia.jpg'),
(9, 'Eredivisie', '2024-08-10', '2025-05-20', 'Países Bajos', 'https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEiKqzMnnQcAUxCzd0w-5EN-zW0U6Hv5exyzxaXulWT2ASKYYnvXJwfZa3Cm7C6j4COnnrG2hd31pvQsPsub_nyFaWwXYEVx93rjOTOOa3G19WJdootTABUhlnHTj_sGpJBbTxsrtXl4-A/s320/Eredivisie+v2.png'),
(10, 'Jupiler Pro League', '2024-08-10', '2025-05-20', 'Bélgica', 'https://paladarnegro.net/escudoteca/ligas/ligas/img/belgica.jpg'),
(11, 'Süper Lig', '2024-08-10', '2025-05-20', 'Turquía', 'https://paladarnegro.net/escudoteca/ligas/ligas/img/turquia.jpg'),
(12, 'Superliga Danesa', '2024-08-10', '2025-05-20', 'Dinamarca', 'https://1000marcas.net/wp-content/uploads/2020/03/logo-Danish-Superliga-640x360.png'),
(13, 'Primeira Liga', '2024-08-10', '2025-05-20', 'Portugal', 'https://paladarnegro.net/escudoteca/ligas/ligas/img/portugal.jpg'),
(14, 'MLS', '2024-02-25', '2024-12-15', 'Estados Unidos', 'https://paladarnegro.net/escudoteca/ligas/ligas/img/estadosunidos.jpg'),
(15, 'Allsvenskan', '2024-04-01', '2024-11-15', 'Suecia', 'https://paladarnegro.net/escudoteca/ligas/ligas/img/suecia.jpg'),
(16, 'Liga MX', '2024-07-20', '2025-05-30', 'México', 'https://paladarnegro.net/escudoteca/ligas/ligas/img/mexico.jpg'),
(17, 'Brasileirão', '2024-04-15', '2024-12-10', 'Brasil', 'https://paladarnegro.net/escudoteca/ligas/ligas/img/brasil.jpg'),
(18, 'Liga Premier de Ucrania', '2024-08-10', '2025-05-20', 'Ucrania', 'https://upl.ua/images/logo-horizontal-en.png'),
(19, 'Liga Premier de Rusia', '2024-08-10', '2025-05-20', 'Rusia', 'https://paladarnegro.net/escudoteca/ligas/ligas/img/rusia.jpg'),
(20, 'A-League', '2024-10-01', '2025-05-31', 'Australia', 'https://paladarnegro.net/escudoteca/ligas/ligas/img/australia.jpg'),
(21, 'Eliteserien', '2024-04-10', '2024-11-20', 'Noruega', 'https://www.eliteserien.no/_/asset/no.seeds.app.football:0000019494ae4320/img/elite_header.svg'),
(29, 'LaLiga 2', '2024-08-10', '2025-05-20', 'España', 'https://assets.laliga.com/assets/public/logospage/pressroom/laliga/LALIGA_HYPERMOTION_RGB_h_color.png'),
(40, 'UEFA Champions League', '2024-06-25', '2025-06-01', 'Europa', 'https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhyt2VQGXlYN9FWhc07l5Qc8h4NO1w0Nsmk5hBtuh2AqSQ4LEFMEyLTJQacA-Jiz8baIGRXjtRVpGm-myVOSPbh4zWrJUSZKznmWCe68o21EkkfP_88F2eWaheroWE7r1nxkfw0RLGDpw/s320/UEFA+Champions+League.png'),
(39, 'UEFA Europa League', '2024-07-11', '2025-05-21', 'Europa', 'https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhmpxWM5nRaZgTyXzN4VI653s21kXq7TBMSUdFPBP3bL5HRc7uiPDcdtY6xC6OmqFYYaJYPqEUysMKTsV-uGClg5fFWKH0i0tUg0VlGe8IsMqcy9NIHEXYl5dJt84ADGG4yqF3-LWvZ7g/s320/UEFA+Europa+League.png'),
(38, 'UEFA Europa Conference League', '2024-07-11', '2025-05-28', 'Europa', 'https://www.fifplay.com/img/public/uecl-logo-dark.png');
;



SET FOREIGN_KEY_CHECKS = 0;

-- SCRIPT CON TODOS LOS EQUIPOS --

INSERT INTO equipos (id, nombre, ciudad, torneo_id, escudo_url, competicion_secundaria_id) VALUES
-- PREMIER --
(1, 'Arsenal', 'Londres', 1, 'https://resources.premierleague.com/premierleague/badges/50/t3@x2.png', 40),
(2, 'Manchester City', 'Manchester', 1, 'https://resources.premierleague.com/premierleague/badges/50/t43@x2.png', 40),
(3, 'Manchester United', 'Manchester', 1, 'https://resources.premierleague.com/premierleague/badges/50/t1@x2.png', null),
(4, 'Chelsea', 'Londres', 1, 'https://resources.premierleague.com/premierleague/badges/50/t8@x2.png', null),
(5, 'Liverpool', 'Liverpool', 1, 'https://resources.premierleague.com/premierleague/badges/50/t14@x2.png', 40),
(6, 'Tottenham Hotspur', 'Londres', 1, 'https://resources.premierleague.com/premierleague/badges/50/t6@x2.png', null),
(7, 'Newcastle United', 'Newcastle', 1, 'https://resources.premierleague.com/premierleague/badges/50/t4@x2.png', null),
(8, 'Aston Villa', 'Birmingham', 1, 'https://resources.premierleague.com/premierleague/badges/50/t7@x2.png', 40),
(9, 'West Ham United', 'Londres', 1, 'https://resources.premierleague.com/premierleague/badges/50/t21@x2.png', null),
(10, 'Brighton & Hove Albion', 'Brighton', 1, 'https://resources.premierleague.com/premierleague/badges/50/t36@x2.png', null),
(11, 'Brentford', 'Londres', 1, 'https://resources.premierleague.com/premierleague/badges/50/t94@x2.png', null),
(12, 'Crystal Palace', 'Londres', 1, 'https://resources.premierleague.com/premierleague/badges/50/t31@x2.png', null),
(13, 'Fulham', 'Londres', 1, 'https://resources.premierleague.com/premierleague/badges/50/t54@x2.png', null),
(14, 'Wolverhampton Wanderers', 'Wolverhampton', 1, 'https://resources.premierleague.com/premierleague/badges/50/t39@x2.png', null),
(15, 'Nottingham Forest', 'Nottingham', 1, 'https://resources.premierleague.com/premierleague/badges/50/t17@x2.png', null),
(16, 'Everton', 'Liverpool', 1, 'https://resources.premierleague.com/premierleague/badges/50/t11@x2.png', null),
(17, 'Burnley', 'Burnley', 1, 'https://resources.premierleague.com/premierleague/badges/50/t90@x2.png', null),
(18, 'Sheffield United', 'Sheffield', 1, 'https://resources.premierleague.com/premierleague/badges/50/t49@x2.png', null),
(19, 'Luton Town', 'Luton', 1, 'https://resources.premierleague.com/premierleague/badges/50/t102@x2.png', null),
(20, 'Bournemouth', 'Bournemouth', 1, 'https://resources.premierleague.com/premierleague/badges/50/t91@x2.png', null),
-- LIGUE 1 --
(61, 'Paris Saint-Germain', 'París', 6, 'https://upload.wikimedia.org/wikipedia/en/a/a7/Paris_Saint-Germain_F.C..svg',40),
(62, 'Olympique de Marseille', 'Marsella', 6, 'https://upload.wikimedia.org/wikipedia/en/6/6d/Olympique_Marseille_logo.svg',null),
(63, 'OGC Nice', 'Niza', 6, 'https://upload.wikimedia.org/wikipedia/en/8/8b/OGC_Nice_logo.svg',null),
(64, 'AS Monaco', 'Mónaco', 6, 'https://upload.wikimedia.org/wikipedia/en/6/6b/AS_Monaco_FC.svg',40),
(65, 'LOSC Lille', 'Lille', 6, 'https://upload.wikimedia.org/wikipedia/en/6/62/LOSC_Lille_M%C3%A9tropole.svg',40),
(66, 'Olympique Lyonnais', 'Lyon', 6, 'https://upload.wikimedia.org/wikipedia/en/c/c6/Olympique_Lyonnais.svg',null),
(67, 'RC Lens', 'Lens', 6, 'https://upload.wikimedia.org/wikipedia/en/f/f6/RC_Lens_logo.svg',null),
(68, 'Stade Brestois 29', 'Brest', 6, 'https://upload.wikimedia.org/wikipedia/en/9/9e/Stade_Brestois_29_logo.svg',40),
(69, 'RC Strasbourg Alsace', 'Estrasburgo', 6, 'https://upload.wikimedia.org/wikipedia/en/6/6e/Racing_Club_de_Strasbourg_logo.svg',null),
(70, 'Toulouse FC', 'Toulouse', 6, 'https://upload.wikimedia.org/wikipedia/en/7/7e/Toulouse_FC_logo.svg',null),
(71, 'AJ Auxerre', 'Auxerre', 6, 'https://upload.wikimedia.org/wikipedia/en/5/5b/Logo_AJ_Auxerre.svg',null),
(72, 'Stade Rennais FC', 'Rennes', 6, 'https://upload.wikimedia.org/wikipedia/en/7/7e/Stade_Rennais_FC.svg',null),
(73, 'Angers SCO', 'Angers', 6, 'https://upload.wikimedia.org/wikipedia/en/0/0b/Angers_SCO_logo.svg',null),
(74, 'Stade de Reims', 'Reims', 6, 'https://upload.wikimedia.org/wikipedia/en/7/7f/Stade_de_Reims_logo.svg',null),
(75, 'FC Nantes', 'Nantes', 6, 'https://upload.wikimedia.org/wikipedia/en/3/3b/FC_Nantes_logo.svg',null),
(76, 'AS Saint-Étienne', 'Saint-Étienne', 6, 'https://upload.wikimedia.org/wikipedia/en/5/5f/ASSE_logo.svg',null),
(77, 'Le Havre AC', 'Le Havre', 6, 'https://upload.wikimedia.org/wikipedia/en/5/5e/Le_Havre_AC_logo.svg',null),
(78, 'Montpellier HSC', 'Montpellier', 6, 'https://upload.wikimedia.org/wikipedia/en/3/3f/Montpellier_HSC_logo.svg',null),
-- SERIE A --
(41, 'Nápoles', 'Nápoles', 5, 'https://img.legaseriea.it/vimages/6681d23a/Napoli.png?webp&q=70&size=210x-', null),
(42, 'Juventus', 'Turín', 5, 'https://img.legaseriea.it/vimages/62cfda28/colore=BLACK.png?webp&q=70&size=210x-', 40),
(43, 'Inter de Milán', 'Milán', 5, 'https://img.legaseriea.it/vimages/62cef496/inter.png?webp&q=70&size=210x-', 40),
(44, 'AC Milan', 'Milán', 5, 'https://img.legaseriea.it/vimages/62cef513/milan.png?webp&q=70&size=210x-', 40),
(45, 'AS Roma', 'Roma', 5, 'https://img.legaseriea.it/vimages/62cfd5ce/roma.png?webp&q=70&size=210x-', null),
(46, 'Lazio', 'Roma', 5, 'https://img.legaseriea.it/vimages/62cef4d5/lazio.png?webp&q=70&size=210x-', null),
(47, 'Atalanta', 'Bérgamo', 5, 'https://img.legaseriea.it/vimages/6681d23a/Atalanta.png?webp&q=70&size=210x', 40),
(48, 'Fiorentina', 'Florencia', 5, 'https://img.legaseriea.it/vimages/62cef452/fiorentina.png?webp&q=70&size=210x-', null),
(49, 'Bologna', 'Bolonia', 5, 'hhttps://img.legaseriea.it/vimages/62cef3f6/bologna.png?webp&q=70&size=210x-', 40),
(50, 'Torino', 'Turín', 5, 'https://img.legaseriea.it/vimages/6681d23a/Torino.png?webp&q=70&size=210x', null),
(51, 'Sampdoria', 'Génova', 5, 'https://d5rzfs5ck83rq.cloudfront.net/legab.it/img/club/loghi/sampdoria.png', null),
(52, 'Lecce', 'Lecce', 5, 'https://img.legaseriea.it/vimages/6681d23a/Lecce.png?webp&q=70&size=210x', null),
(53, 'Udinese', 'Udine', 5, 'https://img.legaseriea.it/vimages/62cef5e9/udinese.png?webp&q=70&size=210x-', null),
(54, 'Monza', 'Monza', 5, 'https://img.legaseriea.it/vimages/62c6acbd/monza.png?webp&q=70&size=210x-', null),
(55, 'Empoli', 'Empoli', 5, 'https://img.legaseriea.it/vimages/62cef42e/empoli.png?webp&q=70&size=210x-', null),
(56, 'Sassuolo', 'Reggio Emilia', 5, 'https://d5rzfs5ck83rq.cloudfront.net/legab.it/img/club/loghi/sassuolo.png', null),
(57, 'Salernitana', 'Salerno', 5, 'https://d5rzfs5ck83rq.cloudfront.net/legab.it/img/club/loghi/salernitana.png', null),
(58, 'Cagliari', 'Cagliari', 5, 'https://img.legaseriea.it/vimages/62cfd202/cagliari.png?webp&q=70&size=210x-', null),
(59, 'Verona', 'Verona', 5, 'https://img.legaseriea.it/vimages/62cfe8b8/colore=BLUE.png?webp&q=70&size=210x-', null),
(60, 'Frosinone', 'Frosinone', 5, 'https://d5rzfs5ck83rq.cloudfront.net/legab.it/img/club/loghi/frosinone.png', null),

-- LA LIGA --
(21, 'Athletic Club', 'Bilbao', 7, 'https://assets.laliga.com/assets/2019/06/07/xsmall/athletic.png', NULL),
(22, 'Atlético de Madrid', 'Madrid', 7, 'https://d2bk74em32frqb.cloudfront.net/assets/2024/06/17/xsmall/cbc5c8cc8c3e8abd0e175c00ee53b723.png', 40),
(23, 'CA Osasuna', 'Pamplona', 7, 'https://d2bk74em32frqb.cloudfront.net/assets/2019/06/07/xsmall/osasuna.png', NULL),
(24, 'CD Leganés', 'Leganés', 7, 'https://d2bk74em32frqb.cloudfront.net/assets/2019/06/07/xsmall/leganes.png', NULL),
(25, 'Deportivo Alavés', 'Vitoria-Gasteiz', 7, 'https://d2bk74em32frqb.cloudfront.net/assets/2020/09/01/xsmall/27002754a98bf535807fe49a24cc63ea.png', NULL),
(26, 'FC Barcelona', 'Barcelona', 7, 'https://assets.laliga.com/assets/2019/06/07/xsmall/barcelona.png', 40),
(27, 'Getafe CF', 'Getafe', 7, 'https://assets.laliga.com/assets/2023/05/12/xsmall/dc59645c96bc2c9010341c16dd6d4bfa.png', NULL),
(28, 'Girona FC', 'Girona', 7, 'https://assets.laliga.com/assets/2022/06/22/xsmall/8f43addbb29e4a72f5e90b6edfe4728f.png', 40),
(29, 'Rayo Vallecano', 'Madrid', 7, 'https://assets.laliga.com/assets/2023/04/27/xsmall/57d9950a8745ead226c04d37235c0786.png', NULL),
(30, 'RC Celta', 'Vigo', 7, 'https://d2bk74em32frqb.cloudfront.net/assets/2019/06/07/xsmall/celta.png', NULL),
(31, 'RCD Espanyol de Barcelona', 'Cornellà de Llobregat', 7, 'https://d2bk74em32frqb.cloudfront.net/assets/2019/06/07/xsmall/espanyol.png', NULL),
(32, 'RCD Mallorca', 'Palma de Mallorca', 7, 'https://assets.laliga.com/assets/2023/03/22/xsmall/013ae97735bc8e519dcf30f6826168ca.png', NULL),
(33, 'Real Betis', 'Sevilla', 7, 'https://assets.laliga.com/assets/2022/09/15/xsmall/e4a09419d3bd115b8f3dab73d480e146.png', NULL),
(34, 'Real Madrid', 'Madrid', 7, 'https://assets.laliga.com/assets/2019/06/07/xsmall/real-madrid.png', 40),
(35, 'Real Sociedad', 'San Sebastián', 7, 'https://assets.laliga.com/assets/2019/06/07/xsmall/real-sociedad.png', NULL),
(36, 'Real Valladolid CF', 'Valladolid', 7, 'https://assets.laliga.com/assets/2024/06/17/xsmall/1467dcd5efb813a742d86f8eb39504a3.png', NULL),
(37, 'Sevilla FC', 'Sevilla', 7, 'https://assets.laliga.com/assets/2019/06/07/xsmall/sevilla.png', NULL),
(38, 'UD Las Palmas', 'Las Palmas de Gran Canaria', 7, 'https://assets.laliga.com/assets/2019/06/07/xsmall/las-palmas.png', NULL),
(39, 'Valencia CF', 'Valencia', 7, 'https://assets.laliga.com/assets/2019/06/07/xsmall/valencia.png', NULL),
(40, 'Villarreal CF', 'Villarreal', 7, 'https://assets.laliga.com/assets/2019/06/07/xsmall/villarreal.png', NULL),

-- BUNDESLIGA --
(79, 'FC Bayern München', 'Múnich', 4, 'https://upload.wikimedia.org/wikipedia/commons/1/1f/FC_Bayern_München_logo_(2017).svg', 40),
(80, 'Bayer 04 Leverkusen', 'Leverkusen', 4, 'https://upload.wikimedia.org/wikipedia/en/5/59/Bayer_04_Leverkusen_logo.svg', 40),
(81, 'Eintracht Frankfurt', 'Fráncfort', 4, 'https://upload.wikimedia.org/wikipedia/commons/0/04/Eintracht_Frankfurt_Logo.svg', NULL),
(82, 'VfB Stuttgart', 'Stuttgart', 4, 'https://upload.wikimedia.org/wikipedia/commons/3/38/VfB_Stuttgart_Logo.svg', 40),
(83, 'RB Leipzig', 'Leipzig', 4, 'https://upload.wikimedia.org/wikipedia/en/0/04/RB_Leipzig_2014_logo.svg', 40),
(84, '1. FSV Mainz 05', 'Maguncia', 4, 'https://upload.wikimedia.org/wikipedia/commons/9/9e/FSV_Mainz_05_Logo.svg', NULL),
(85, 'VfL Wolfsburg', 'Wolfsburgo', 4, 'https://upload.wikimedia.org/wikipedia/commons/f/f3/Logo-VfL-Wolfsburg.svg', NULL),
(86, 'SC Freiburg', 'Friburgo', 4, 'https://upload.wikimedia.org/wikipedia/en/8/81/SC_Freiburg_logo.svg', NULL),
(87, 'SV Werder Bremen', 'Bremen', 4, 'https://upload.wikimedia.org/wikipedia/commons/b/be/SV-Werder-Bremen-Logo.svg', NULL),
(88, 'Borussia Dortmund', 'Dortmund', 4, 'https://upload.wikimedia.org/wikipedia/commons/6/67/Borussia_Dortmund_logo.svg', 40),
(89, 'Borussia Mönchengladbach', 'Mönchengladbach', 4, 'https://upload.wikimedia.org/wikipedia/commons/8/81/Borussia_Mönchengladbach_logo.svg', NULL),
(90, 'FC Augsburg', 'Augsburgo', 4, 'https://upload.wikimedia.org/wikipedia/en/b/b5/FC_Augsburg_logo.svg', NULL),
(91, '1. FC Union Berlin', 'Berlín', 4, 'https://upload.wikimedia.org/wikipedia/commons/e/e7/1.FC_Union_Berlin_Logo.svg', NULL),
(92, 'FC St. Pauli', 'Hamburgo', 4, 'https://upload.wikimedia.org/wikipedia/commons/1/1b/FC_St_Pauli_logo.svg', NULL),
(93, 'TSG 1899 Hoffenheim', 'Sinsheim', 4, 'https://upload.wikimedia.org/wikipedia/commons/1/12/TSG_1899_Hoffenheim_Logo.svg', NULL),
(94, '1. FC Heidenheim', 'Heidenheim', 4, 'https://upload.wikimedia.org/wikipedia/commons/0/0a/1._FC_Heidenheim_1846_Logo.svg', NULL),
(95, 'Holstein Kiel', 'Kiel', 4, 'https://upload.wikimedia.org/wikipedia/commons/3/3d/Holstein_Kiel_Logo.svg', NULL),
(96, 'VfL Bochum', 'Bochum', 4, 'https://upload.wikimedia.org/wikipedia/commons/4/4f/VfL_Bochum_logo.svg', NULL),

-- LA LIGA 2 --
(121, 'R. Racing Club', 'Santander', 29, 'https://github.com/Jsobrino98/Escudos/blob/main/RacingSant.png', NULL),
(122, 'SD Huesca', 'Huesca', 29, 'https://github.com/Jsobrino98/Escudos/blob/main/Huesca.png', NULL),
(123, 'Elche CF', 'Elche', 29, 'https://github.com/Jsobrino98/Escudos/blob/main/Elche.png', NULL),
(124, 'CD Mirandés', 'Miranda de Ebro', 29, 'https://github.com/Jsobrino98/Escudos/blob/main/CDMirandés.png', NULL),
(125, 'Real Oviedo', 'Oviedo', 29, 'https://github.com/Jsobrino98/Escudos/blob/main/Oviedo.png', NULL),
(126, 'UD Almería', 'Almería', 29, 'https://github.com/Jsobrino98/Escudos/blob/main/Almería.png', NULL),
(127, 'Levante UD', 'Valencia', 29, 'https://github.com/Jsobrino98/Escudos/blob/main/Levante.png', NULL),
(128, 'Granada CF', 'Granada', 29, 'https://github.com/Jsobrino98/Escudos/blob/main/Granada.png', NULL),
(129, 'Real Sporting', 'Gijón', 29, 'https://github.com/Jsobrino98/Escudos/blob/main/SportingGijón.png', NULL),
(130, 'RC Deportivo', 'La Coruña', 29, 'https://github.com/Jsobrino98/Escudos/blob/main/LaCoruña.png', NULL),
(131, 'Real Zaragoza', 'Zaragoza', 29, 'https://github.com/Jsobrino98/Escudos/blob/main/Zaragoza.png', NULL),
(132, 'Cádiz CF', 'Cádiz', 29, 'https://github.com/Jsobrino98/Escudos/blob/main/Cádiz.png', NULL),
(133, 'Albacete BP', 'Albacete', 29, 'https://github.com/Jsobrino98/Escudos/blob/main/Albacete.png', NULL),
(134, 'SD Eibar', 'Eibar', 29, 'https://github.com/Jsobrino98/Escudos/blob/main/Eibar.png', NULL),
(135, 'Córdoba CF', 'Córdoba', 29, 'https://github.com/Jsobrino98/Escudos/blob/main/Córdoba.png', NULL),
(136, 'Málaga CF', 'Málaga', 29, 'https://github.com/Jsobrino98/Escudos/blob/main/Málaga.png', NULL),
(137, 'CD Castellón', 'Castellón de la Plana', 29, 'https://github.com/Jsobrino98/Escudos/blob/main/Castellón.png', NULL),
(138, 'Burgos CF', 'Burgos', 29, 'https://github.com/Jsobrino98/Escudos/blob/main/Burgos.png', NULL),
(139, 'CD Eldense', 'Elda', 29, 'https://github.com/Jsobrino98/Escudos/blob/main/Eldense.png', NULL),
(140, 'Racing Club Ferrol', 'Ferrol', 29, 'https://github.com/Jsobrino98/Escudos/blob/main/RacingFerrol.png', NULL),
(141, 'CD Tenerife', 'Santa Cruz de Tenerife', 29, 'https://github.com/Jsobrino98/Escudos/blob/main/Tenerife.png', NULL),
(142, 'FC Cartagena', 'Cartagena', 29, 'https://github.com/Jsobrino98/Escudos/blob/main/Cartagena.png', NULL),

-- LIGA NORUEGA --
(143, 'Bodø/Glimt', 'Bodø', 21, 'https://www.glimt.no/_/asset/no.seeds.app.football:00000194b2525600/img/logo/bod/logo.png', NULL),
(144, 'Brann', 'Bergen', 21, 'https://www.brann.no/images/escudo.png', NULL),
(145, 'Bryne FK', 'Bryne', 21, 'https://www.brynefk.no/_img/logo/brynefk-logo.png', NULL),
(146, 'Fredrikstad FK', 'Fredrikstad', 21, 'https://www.fredrikstadfk.no/_img/logo/fredrikstad-logo.png', NULL),
(147, 'HamKam', 'Hamar', 21, 'https://www.hamkam.no/_img/logo/hamkam-logo.png', NULL),
(148, 'Haugesund', 'Haugesund', 21, 'https://www.fkh.no/_img/logo/haugesund-logo.png', NULL),
(149, 'KFUM Oslo', 'Oslo', 21, 'https://www.kfum-kam.no/_img/logo/kfum-oslo-logo.png', NULL),
(150, 'Kristiansund BK', 'Kristiansund', 21, 'https://www.kristiansundbk.no/_img/logo/kristiansund-logo.png', NULL),
(151, 'Molde FK', 'Molde', 21, 'https://www.moldefk.no/_img/logo/molde-logo.png', NULL),
(152, 'Rosenborg BK', 'Trondheim', 21, 'https://www.rosenborg.no/_img/logo/rosenborg-logo.png', NULL),
(153, 'Sarpsborg 08', 'Sarpsborg', 21, 'https://www.sarpsborg08.no/_img/logo/sarpsborg-logo.png', NULL),
(154, 'Stabæk', 'Bekkestua', 21, 'https://www.stabak.no/_img/logo/stabak-logo.png', NULL),
(155, 'Strømsgodset', 'Drammen', 21, 'https://www.sgodset.no/_img/logo/sgodset-logo.png', NULL),
(156, 'Tromsø IL', 'Tromsø', 21, 'https://www.til.no/_img/logo/til-logo.png', NULL),
(157, 'Viking FK', 'Stavanger', 21, 'https://www.viking-fk.no/_img/logo/viking-logo.png', NULL),
(158, 'Vålerenga', 'Oslo', 21, 'https://www.vif.no/_img/logo/vif-logo.png', NULL),

-- LIGA ESCOCESA --
(159, 'Aberdeen FC', 'Aberdeen', 3, 'https://upload.wikimedia.org/wikipedia/en/9/90/Aberdeen_FC_logo.svg', NULL),
(160, 'Celtic FC', 'Glasgow', 3, 'https://upload.wikimedia.org/wikipedia/en/9/9c/Celtic_FC.svg', 40),
(161, 'Dundee FC', 'Dundee', 3, 'https://upload.wikimedia.org/wikipedia/en/4/43/Dundee_FC_logo.svg', NULL),
(162, 'Dundee United FC', 'Dundee', 3, 'https://upload.wikimedia.org/wikipedia/en/5/5c/Dundee_United_FC_logo.svg', NULL),
(163, 'Heart of Midlothian FC', 'Edimburgo', 3, 'https://upload.wikimedia.org/wikipedia/en/0/0c/Heart_of_Midlothian_FC_logo.svg', NULL),
(164, 'Hibernian FC', 'Edimburgo', 3, 'https://upload.wikimedia.org/wikipedia/en/8/8c/Hibernian_FC_logo.svg', NULL),
(165, 'Kilmarnock FC', 'Kilmarnock', 3, 'https://upload.wikimedia.org/wikipedia/en/5/5e/Kilmarnock_FC_logo.svg', NULL),
(166, 'Motherwell FC', 'Motherwell', 3, 'https://upload.wikimedia.org/wikipedia/en/3/3a/Motherwell_FC_crest.svg', NULL),
(167, 'Rangers FC', 'Glasgow', 3, 'https://img.uefa.com/imgml/TP/teams/logos/64x64/50121.png', NULL),
(168, 'Ross County FC', 'Dingwall', 3, 'https://upload.wikimedia.org/wikipedia/en/7/7c/Ross_County_FC_logo.svg', NULL),
(169, 'St Johnstone FC', 'Perth', 3, 'https://upload.wikimedia.org/wikipedia/en/7/7c/St_Johnstone_FC_logo.svg', NULL),
(170, 'St Mirren FC', 'Paisley', 3, 'https://upload.wikimedia.org/wikipedia/en/0/0f/St_Mirren_FC_logo.svg', NULL),

-- CHAMPIONS LEAGUE --

(171, 'RB Salzburgo', 'Salzburgo', 34, 'https://img.uefa.com/imgml/TP/teams/logos/64x64/50030.png', 40),
(172, 'Sturm Graz', 'Graz', 34, 'https://img.uefa.com/imgml/TP/teams/logos/64x64/50111.png', 40),
(173, 'Feyenoord', 'Róterdam', 9, 'https://img.uefa.com/imgml/TP/teams/logos/64x64/52749.png', 40),
(174, 'PSV Eindhoven', 'Eindhoven', 9, 'https://img.uefa.com/imgml/TP/teams/logos/64x64/50062.png', 40),
(175, 'Benfica', 'Lisboa', 13, 'https://img.uefa.com/imgml/TP/teams/logos/64x64/50147.png', 40),
(176, 'Sporting CP', 'Lisboa', 13, 'https://img.uefa.com/imgml/TP/teams/logos/64x64/50149.png', 40),
(177, 'Brujas', 'Brujas', 34, 'https://img.uefa.com/imgml/TP/teams/logos/64x64/50043.png', 40),
(178, 'Dinamo Zagreb', 'Zagreb', 34, 'https://img.uefa.com/imgml/TP/teams/logos/64x64/50164.png', 40),
(179, 'Sparta de Praga', 'Praga', 34, 'https://img.uefa.com/imgml/TP/teams/logos/64x64/50033.png', 40),
(180, 'Estrella Roja', 'Belgrado', 34, 'https://img.uefa.com/imgml/TP/teams/logos/64x64/50069.png', 40),
(181, 'Slovan Bratislava', 'Bratislava', 34, 'https://img.uefa.com/imgml/TP/teams/logos/64x64/52797.png', 40),
(182, 'Young Boys', 'Berna', 34, 'https://img.uefa.com/imgml/TP/teams/logos/64x64/50031.png', 40),
(183, 'Shakhtar Donetsk', 'Donetsk', 18, 'https://img.uefa.com/imgml/TP/teams/logos/64x64/52707.png', 40)



;



INSERT INTO jugadores (nombre, edad, posicion, equipo_id) VALUES
-- LaLiga (España)
('Vinícius Jr.', 24, 'Delantero', 34), -- Real Madrid
('Jude Bellingham', 21, 'Centrocampista', 34), -- Real Madrid
('Robert Lewandowski', 36, 'Delantero', 26), -- FC Barcelona
('Pedri', 22, 'Centrocampista', 26), -- FC Barcelona
('Antoine Griezmann', 33, 'Delantero', 22), -- Atlético de Madrid
('Jan Oblak', 32, 'Portero', 22), -- Atlético de Madrid
('Isco', 32, 'Centrocampista', 33), -- Real Betis
('Julian Alvarez', 22, 'Delantero', 22), -- Atlético de Madrid
('Iago Aspas', 37, 'Delantero', 30), -- RC Celta
('Takefusa Kubo', 23, 'Centrocampista', 35), -- Real Sociedad

-- Premier League (Inglaterra)
('Erling Haaland', 24, 'Delantero', 50), -- Manchester City
('Kevin De Bruyne', 33, 'Centrocampista', 50), -- Manchester City
('Bukayo Saka', 23, 'Centrocampista', 51), -- Arsenal
('Declan Rice', 26, 'Centrocampista', 51), -- Arsenal
('Mohamed Salah', 32, 'Delantero', 52), -- Liverpool
('Virgil van Dijk', 33, 'Defensa', 52), -- Liverpool
('Marcus Rashford', 27, 'Delantero', 53), -- Manchester United
('Bruno Fernandes', 30, 'Centrocampista', 53), -- Manchester United
('Enzo Fernández', 24, 'Centrocampista', 54), -- Chelsea
('Christopher Nkunku', 27, 'Delantero', 54), -- Chelsea

-- Bundesliga (Alemania)
('Harry Kane', 31, 'Delantero', 79), -- Bayern Múnich
('Jamal Musiala', 22, 'Centrocampista', 79), -- Bayern Múnich
('Florian Wirtz', 22, 'Centrocampista', 80), -- Bayer Leverkusen
('Joshua Kimmich', 30, 'Centrocampista', 79), -- Bayern Múnich
('Donyell Malen', 26, 'Delantero', 88), -- Borussia Dortmund
('Marco Reus', 35, 'Centrocampista', 88), -- Borussia Dortmund
('Xavi Simons', 22, 'Centrocampista', 83), -- RB Leipzig
('Serhou Guirassy', 29, 'Delantero', 82), -- VfB Stuttgart
('Jonathan Tah', 29, 'Defensa', 80), -- Bayer Leverkusen
('Leroy Sané', 29, 'Delantero', 79), -- Bayern Múnich

-- Serie A (Italia)
('Victor Osimhen', 26, 'Delantero', 101), -- Napoli
('Khvicha Kvaratskhelia', 24, 'Centrocampista', 120), -- Napoli
('Lautaro Martínez', 27, 'Delantero', 102), -- Inter de Milán
('Nicolò Barella', 28, 'Centrocampista', 102), -- Inter de Milán
('Paulo Dybala', 31, 'Delantero', 103), -- AS Roma
('Federico Chiesa', 27, 'Delantero', 104), -- Juventus
('Dusan Vlahovic', 25, 'Delantero', 104), -- Juventus
('Rafael Leão', 25, 'Delantero', 105), -- AC Milan
('Theo Hernández', 27, 'Defensa', 105), -- AC Milan
('Sergej Milinković-Savić', 29, 'Centrocampista', 106), -- Lazio

-- Ligue 1 (Francia)
('Kylian Mbappé', 26, 'Delantero', 34), -- PSG
('Ousmane Dembélé', 27, 'Delantero', 120), -- PSG
('Achraf Hakimi', 26, 'Defensa', 120), -- PSG
('Randal Kolo Muani', 26, 'Delantero', 120), -- PSG
('Jonathan David', 25, 'Delantero', 121), -- Lille
('Alexandre Lacazette', 33, 'Delantero', 122), -- Lyon
('Wissam Ben Yedder', 34, 'Delantero', 123), -- AS Monaco
('Moses Simon', 29, 'Delantero', 124), -- Nantes
('Pierre-Emerick Aubameyang', 35, 'Delantero', 125), -- Olympique de Marsella
('Benjamin Bourigeaud', 31, 'Centrocampista', 126); -- Rennes


