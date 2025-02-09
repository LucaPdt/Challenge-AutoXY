CREATE DATABASE concessionaria;

CREATE TYPE StatoAuto AS ENUM ('disponibile', 'venduta');

CREATE TABLE Automobile (
    id SERIAL PRIMARY KEY,
    marca VARCHAR(50) NOT NULL,
    modello VARCHAR(50) NOT NULL,
    motorizzazione VARCHAR(50) NOT NULL,
    anno INT NOT NULL,
    prezzo NUMERIC(10,2) NOT NULL CHECK (prezzo >= 0),
    stato StatoAuto NOT NULL DEFAULT 'disponibile'
);