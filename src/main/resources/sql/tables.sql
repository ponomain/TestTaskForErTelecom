DROP TABLE IF EXISTS customer;
CREATE TABLE customer(
    id SERIAL PRIMARY KEY,
    name varchar(25),
    balance integer
);

DROP TABLE IF EXISTS product;
CREATE TABLE product(
    id SERIAL PRIMARY KEY,
    title varchar(50),
    price integer
);

DROP TABLE IF EXISTS order_product;
CREATE TABLE order_product(
    id SERIAL PRIMARY KEY,
    product_id integer,
    customer_id integer,
    order_date timestamp,
    foreign key (product_id) references product(id),
    foreign key (customer_id) references customer(id)
);

