INSERT INTO shops (name) VALUES
('Test auto create Shop'),
('Test2 auto create Shop'),
('Test3 auto create Shop');

INSERT INTO persons (age, first_name, last_name, phone, shop_id) VALUES
 (19, 'John', 'Smith', '00000000000', 1),
 (30, 'Maria', 'Movchhan', '380952378309', 2),
 (15, 'Ivan', 'Kalenev', '380998956798', 3);

INSERT INTO carts (all_price) VALUES
(0),
(0),
(0);

INSERT INTO persons_carts (person_person_id, carts_cart_id) VALUES
(1, 1),
(2, 2),
(3, 3);

INSERT INTO products (name, price, products) VALUES
('TestAuto', 444, 1),
('TestAuto2', 555, 2),
('TestAuto3', 666, 3);