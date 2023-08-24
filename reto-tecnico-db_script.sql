-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-08-23 21:23:47.137

-- tables
-- Table: States
CREATE TABLE States (
    id int AUTO_INCREMENT NOT NULL,
    state varchar(15)  NOT NULL,
    CONSTRAINT States_pk PRIMARY KEY (id)
);

-- Table: Users
CREATE TABLE Users (
    id int AUTO_INCREMENT  NOT NULL,
    nombres varchar(50)  NOT NULL,
    apellidos varchar(50)  NOT NULL,
    login varchar(16)  NOT NULL,
    created datetime  NULL,
    lastUpdate datetime  NULL,
    email varchar(50)  NOT NULL,
    password varchar(32)  NOT NULL,
    states_id int  NOT NULL,
    CONSTRAINT Users_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: Users_States (table: Users)
ALTER TABLE Users ADD CONSTRAINT Users_States FOREIGN KEY Users_States (states_id)
    REFERENCES States (id);

INSERT INTO STATES (id, state) VALUES (1, 'ACTIVO');
INSERT INTO STATES (id, state) VALUES (2, 'BLOQUEADO');
INSERT INTO STATES (id, state) VALUES (3, 'ELIMINADO');

-- End of file.

