CREATE TABLE adresa
(
    id            SERIAL PRIMARY KEY,
    tara          VARCHAR(200),
    oras          VARCHAR(200),
    strada        VARCHAR(200),
    numar         VARCHAR(200)

);

CREATE TABLE angajat
(
    id               SERIAL PRIMARY KEY,
    nume             VARCHAR(200),
    email            VARCHAR(200),
    telefon          VARCHAR(200),
    dataAngajarii    VARCHAR(200),
    pozitie          VARCHAR(200)
);

CREATE TABLE biblioteca
(
    id               SERIAL PRIMARY KEY,
    nume             VARCHAR(200),
    adresa           VARCHAR(200),
    carti            VARCHAR(200)
);

CREATE TABLE carte
(
    id               SERIAL PRIMARY KEY,
    titlu            VARCHAR(200),
    autor            VARCHAR(200),
    editura          VARCHAR(200)
);

CREATE TABLE cititor
(
    id              SERIAL PRIMARY KEY,
    nume            VARCHAR(200),
    email           VARCHAR(200),
    telefon         VARCHAR(200),
    elev            VARCHAR(200)
);

CREATE TABLE imprumut
(
    id              SERIAL PRIMARY KEY,
    carte            VARCHAR(200),
    cititor           VARCHAR(200)
);