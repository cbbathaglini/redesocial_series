CREATE DATABASE redesocial_series;
use redesocial_series;

CREATE TABLE series(
idSerie int not null AUTO_INCREMENT,
nome varchar(200) not null,
ano  int not null,
numero_temporadas  int not null,
PRIMARY KEY(idSerie)
);
INSERT INTO series (nome, ano,numero_temporadas) VALUES ("Gossip Girl: A Garota do Blog",2007,6);
INSERT INTO series (nome, ano,numero_temporadas) VALUES ("Grey''s Anatomy",2005,19);
INSERT INTO series (nome, ano,numero_temporadas) VALUES ("O Mentalista",2008,7);
INSERT INTO series (nome, ano,numero_temporadas) VALUES ("Gilmore Girls: Tal Mãe, Tal Filha",2000,7);
INSERT INTO series (nome, ano,numero_temporadas) VALUES ("Breaking Bad - A Química do Mal",2008,5);
INSERT INTO series (nome, ano,numero_temporadas) VALUES ("Friends",1994,10);

CREATE TABLE usuarios(
 idUsuario int not null AUTO_INCREMENT,
 nome varchar(200) not null,
 email  varchar(200) not null,
 PRIMARY KEY(idUsuario)
);

INSERT INTO usuarios (nome, email) VALUES ("euaqui","euaqui@email.com");
INSERT INTO usuarios (nome, email) VALUES ("usuario-dois","usuario-dois@email.com");

CREATE TABLE notas_series(
 idNotasSeries int not null AUTO_INCREMENT,
 idSerie int not null,
 idUsuario int not null,
 nota int DEFAULT 1 not null,
 comentarios varchar(400) null,
 PRIMARY KEY(idNotasSeries),
 FOREIGN KEY (idSerie) REFERENCES series(idSerie)
);

INSERT INTO notas_series (idSerie,idUsuario,nota,comentarios) VALUES (6,4,2,"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
INSERT INTO notas_series (idSerie,idUsuario,nota,comentarios) VALUES (6,5,2,"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
INSERT INTO notas_series (idSerie,idUsuario, nota,comentarios) VALUES (1,4,2,"Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.");

CREATE TABLE minhas_series(
  idMinhasSeries int not null AUTO_INCREMENT,
  idUsuario int not null,
  idSerie int not null,
  situacao varchar(200) not null,
  favorita boolean  null,
  PRIMARY KEY(idMinhasSeries),
  FOREIGN KEY (idUsuario) REFERENCES usuarios(idUsuario),
  FOREIGN KEY (idSerie) REFERENCES series(idSerie)
);
CREATE INDEX idx_id_usuario ON minhas_series (idUsuario);

INSERT INTO minhas_series (idUsuario,idSerie,situacao,favorita) VALUES (2,4,"JA_VI",TRUE);
INSERT INTO minhas_series (idUsuario,idSerie,situacao,favorita) VALUES (2,5,"QUERO_VER",null);
INSERT INTO minhas_series (idUsuario,idSerie,situacao,favorita) VALUES (2,6,"ESTOU_VENDO",TRUE);






