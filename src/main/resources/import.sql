-- 1. В базе данных необходимо реализовать возможность хранить информацию
-- о покупателях (id, имя) и товарах (id, название, стоимость). У каждого покупателя свой набор купленных товаров;

DROP TABLE costumers IF EXISTS;
CREATE TABLE IF NOT EXISTS costumers (id bigserial, fio VARCHAR(255), PRIMARY KEY (id));
INSERT INTO costumers (fio) VALUES ('Bob'), ('Jack'), ('John');

DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial, title VARCHAR(255), price int, costumers_id bigint REFERENCES costumers(id), PRIMARY KEY (id));
INSERT INTO products (title, price, costumers_id) VALUES ('Car', 8000, 1), ('House', 100000, 1), ('Boat', 5000, 2), ('Boll', 5000, 3), ('Bag', 7000, 2) ;



DROP TABLE  items IF EXISTS;
CREATE TABLE IF NOT EXISTS items (id bigserial, title VARCHAR(255), PRIMARY KEY (id));
INSERT INTO items (title) VALUES ('BOX'), ('MILK'), ('BRED');


