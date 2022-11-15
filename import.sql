BEGIN;

DROP TABLE IF EXISTS costumers CASCADE;
CREATE TABLE IF NOT EXISTS costumers
(
    id bigserial PRIMARY KEY,
    name_cust VARCHAR(255)
);
INSERT INTO costumers (name_cust) VALUES ('Bob'), ('Jack'), ('John');

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE IF NOT EXISTS  products
(
    id bigserial PRIMARY KEY,
    title VARCHAR(255),
    cost bigint,
    costumers_id bigint REFERENCES costumers(id)
    );

INSERT INTO products (title, cost, costumers_id)
VALUES ('Video game',50, 1),
       ('Music Qwin',25, 1),
       ('Music Beatels',28, 1),
       ('Poster V',14, 2),
       ('Poster W',17, 3);

DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE IF NOT EXISTS users (id bigserial, score int, name VARCHAR(255), PRIMARY KEY (id));
INSERT INTO users (name, score) VALUES ('Bob', 80), ('Jack', 80), ('John', 80);

COMMIT;