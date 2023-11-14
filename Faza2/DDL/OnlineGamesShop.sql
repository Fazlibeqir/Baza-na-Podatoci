CREATE SCHEMA onlinegameshop;
--Costumer(id_costumer,Username,email,password)
CREATE TABLE onlinegameshop.Costumer(
    id_costumer serial primary key,
    Username varchar(8) not null ,
    email varchar(255) not null ,
    password varchar(255) not null
);
INSERT INTO onlinegameshop.Costumer (Username, email,password)
VALUES ('user1','user1@example.com','password'),
       ('user2','user2@example.com','secure45'),
       ('user3','user3@example.com','12345abc');

SELECT * FROM onlinegameshop.Costumer;

--Publisher(id_publisher,name,website,country)

CREATE TABLE onlinegameshop.Publisher(

id_publisher serial primary key,
name  varchar(255) not null,
website  varchar(255) not null,
country  varchar(30) not null

);
INSERT INTO onlinegameshop.Publisher (name, website, country) VALUES
('Publisher1', 'http://publisher1.com', 'CountryA'),
('Publisher2', 'http://publisher2.com', 'CountryB'),
('Publisher3', 'http://publisher3.com', 'CountryC');

SELECT * FROM onlinegameshop.Publisher;

CREATE TABLE onlinegameshop.Games(
    id_game serial primary key ,
    title varchar(255),
    genre varchar(255) not null,
    price decimal(10,2) not null ,
    developer varchar(255),
    stock integer not null ,
    release_date date,
    id_publisher integer not null references onlinegameshop.Publisher(id_publisher)
);
INSERT INTO onlinegameshop.Games (title, genre, price, developer, stock, release_date, id_publisher)
VALUES
('Game1', 'Action', 49.99, 'DeveloperX', 100, '2023-01-15', 1),
('Game2', 'Puzzle', 29.99, 'DeveloperY', 75, '2023-02-20', 2),
('Game3', 'Adventure', 39.99, 'DeveloperZ', 50, '2023-03-25', 3);

SELECT * FROM onlinegameshop.Games;

--Review(id_review,rating,comment,id_costumer*(Costumer),id_game*(Games))
CREATE TABLE onlinegameshop.Review(
id_review serial primary key,
rating integer,
comment text,
id_costumer integer not null references onlinegameshop.Costumer(id_costumer),
id_game integer not null references onlinegameshop.Games(id_game)
);
INSERT INTO onlinegameshop.Review (rating, comment, id_costumer, id_game)
VALUES
(5, 'Great game!', 1, 1),
(4, 'Fun to play.', 2, 2),
(3, 'Decent game.', 3, 3);

SELECT * FROM onlinegameshop.Review;

--Payment(id_payment,payment_method,date,amount)

CREATE TABLE onlinegameshop.Payment(

id_payment serial primary key,
payment_method varchar(255) not null,
date date,
amount decimal(10,2)

);
INSERT INTO onlinegameshop.Payment (payment_method, date, amount)
VALUES
('Strip', '2023-01-01', 49.99),
('PayPal', '2023-02-05', 29.99),
('Card', '2023-03-10', 39.99);

SELECT * FROM onlinegameshop.Payment;

--Orders(id_order,status,date,total_amount,id_costumer*(Costumer),id_payment*(Payment))
CREATE TABLE onlinegameshop.Orders(
    id_order serial primary key ,
    status varchar(255),
    order_date date,
    total_amount decimal(10, 2),
    id_costumer integer not null references onlinegameshop.Costumer(id_costumer),
    id_payment integer not null references onlinegameshop.Payment(id_payment)
);
INSERT INTO onlinegameshop.Orders (status, order_date, total_amount, id_costumer, id_payment) VALUES
('Pending', '2023-01-02', 49.99, 1, 1),
('Shipped', '2023-02-06', 29.99, 2, 2),
('Delivered', '2023-03-11', 39.99, 3, 3);

SELECT * FROM onlinegameshop.Orders;

--Promotions(id_promotion,title,start_date,end_date,discount_percentage)

CREATE TABLE onlinegameshop.Promotions(

id_promotion serial primary key,
title varchar(255),
start_date  date not null,
end_date  date not null,
discount_percentage decimal(5,2) not null

);
INSERT INTO onlinegameshop.Promotions (title, start_date, end_date, discount_percentage) VALUES
('Promo1', '2023-01-01', '2023-01-15', 10.0),
('Promo2', '2023-02-10', '2023-02-25', 15.0),
('Promo3', '2023-03-20', '2023-04-05', 20.0);


SELECT * FROM onlinegameshop.Promotions;
--Platform(id_platform,name,manufacturer,release_date)

CREATE TABLE onlinegameshop.Platform(

id_platform serial primary key,
name  varchar(255) not null,
manufacturer  varchar(255) not null,
release_date  date not null

);

INSERT INTO onlinegameshop.Platform (name, manufacturer, release_date) VALUES
('Platform1', 'ManufacturerA', '2023-01-01'),
('Platform2', 'ManufacturerB', '2023-02-10'),
('Platform3', 'ManufacturerC', '2023-03-20');

SELECT * FROM onlinegameshop.Platform;

--Orders_are_related_to_promotions(id_order*(Orders),id_promotion*(Promotions))

CREATE TABLE onlinegameshop.Orders_are_related_to_promotions(
id_order integer not null references onlinegameshop.Orders(id_order),
id_promotion integer not null references onlinegameshop.Promotions(id_promotion),
constraint pk_order_are_related_to_promotions primary key(id_order,id_promotion)

);
INSERT INTO onlinegameshop.Orders_are_related_to_promotions (id_order, id_promotion)
VALUES
(1, 1),
(2, 2),
(3, 3);

SELECT * FROM onlinegameshop.Orders_are_related_to_promotions;


--Orders_contains_games(id_order*(Orders),id_game*(Games))
CREATE TABLE  onlinegameshop.Orders_contains_games(
    id_order integer references onlinegameshop.Orders(id_order),
    id_game integer references onlinegameshop.Games(id_game),
    constraint pk_orders_contains_games primary key (id_order,id_game)
);
INSERT INTO onlinegameshop.Orders_contains_games (id_order, id_game) VALUES
(1, 1),
(2, 2),
(3, 3);

SELECT * FROM onlinegameshop.Orders_contains_games;
--Games_supports_platform(id_game*(Games),id_platform*(Platform))
CREATE TABLE onlinegameshop.Games_supports_platform(
  id_game integer not null references onlinegameshop.Games(id_game),
  id_platform integer not null references onlinegameshop.Platform(id_platform),
  constraint pk_games_supports_platform primary key (id_game,id_platform)

);
INSERT INTO onlinegameshop.Games_supports_platform (id_game, id_platform) VALUES
(1, 1),
(2, 2),
(3, 3);

SELECT * FROM onlinegameshop.Games_supports_platform;