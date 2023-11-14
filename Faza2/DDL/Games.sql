
--Costumer(id_costumer,Username,email,password)
CREATE TABLE Consumer(
    id_consumer serial primary key,
    Username varchar(8) not null ,
    password varchar(8) not null
);
ALTER TABLE Consumer RENAME TO Costumer;
ALTER TABLE Costumer RENAME COLUMN id_consumer TO id_costumer;
ALTER TABLE Costumer ADD COLUMN email varchar(255);

INSERT INTO Costumer (Username, email,password)
VALUES ('user1','user1@example.com','password'),
       ('user2','user2@example.com','secure45'),
       ('user3','user3@example.com','12345abc');

SELECT * FROM Costumer;

--Publisher(id_publisher,name,website,country)

CREATE TABLE Publisher(

id_publisher serial primary key,
name  varchar(255) not null,
website  varchar(255) not null,
country  varchar(30) not null

);
INSERT INTO Publisher (name, website, country) VALUES
('Publisher1', 'http://publisher1.com', 'CountryA'),
('Publisher2', 'http://publisher2.com', 'CountryB'),
('Publisher3', 'http://publisher3.com', 'CountryC');

SELECT * FROM Publisher;

CREATE TABLE Games(
    id_game serial primary key ,
    title varchar(255),
    genre varchar(10) not null,
    price decimal not null ,
    developer varchar(255),
    stock integer not null ,
    release_date date,
    id_publisher integer references Publisher(id_publisher)
);
INSERT INTO Games (title, genre, price, developer, stock, release_date, id_publisher) VALUES
('Game1', 'Action', 49.99, 'DeveloperX', 100, '2023-01-15', 1),
('Game2', 'Puzzle', 29.99, 'DeveloperY', 75, '2023-02-20', 2),
('Game3', 'Adventure', 39.99, 'DeveloperZ', 50, '2023-03-25', 3);

SELECT * FROM Games;

--Review(id_review,rating,comment,id_costumer*(Costumer),id_game*(Games))
CREATE TABLE Review(
id_review serial primary key,
rating integer,
comment text,
id_costumer integer references Costumer(id_consumer),
id_game integer references Games(id_game)
);
INSERT INTO Review (rating, comment, id_costumer, id_game) VALUES
(5, 'Great game!', 1, 1),
(4, 'Fun to play.', 2, 2),
(3, 'Decent game.', 3, 3);

SELECT * FROM Review;

--Payment(id_payment,payment_method,date,amount)

CREATE TABLE Payment(

id_payment serial primary key,
payment_method char(2) not null,
date date,
amount decimal

);
INSERT INTO Payment (payment_method, date, amount) VALUES
('SQ', '2023-01-01', 49.99),
('PP', '2023-02-05', 29.99),
('ST', '2023-03-10', 39.99);

SELECT * FROM Payment;

--Orders(id_order,status,date,total_amount,id_costumer*(Costumer),id_payment*(Payment))
CREATE TABLE Orders(
    id_order serial primary key ,
    status varchar(255),
    order_date date,
    total_amount decimal,
    id_consumer integer references Costumer(id_consumer),
    id_payment integer references Payment(id_payment)
);
ALTER TABLE Orders RENAME COLUMN id_consumer TO id_costumer;
INSERT INTO Orders (status, order_date, total_amount, id_costumer, id_payment) VALUES
('Pending', '2023-01-02', 49.99, 1, 1),
('Shipped', '2023-02-06', 29.99, 2, 2),
('Delivered', '2023-03-11', 39.99, 3, 3);

SELECT * FROM Orders;

--Promotions(id_promotion,title,start_date,end_date,discount_percentage)

CREATE TABLE Promotions(

id_promotion serial primary key,
title varchar(255),
start_date  date not null,
end_date  date not null,
discount_percentage decimal not null

);
INSERT INTO Promotions (title, start_date, end_date, discount_percentage) VALUES
('Promo1', '2023-01-01', '2023-01-15', 10.0),
('Promo2', '2023-02-10', '2023-02-25', 15.0),
('Promo3', '2023-03-20', '2023-04-05', 20.0);


SELECT * FROM Promotions;
--Platform(id_platform,name,manufacturer,release_date)

CREATE TABLE Platform(

id_publisher serial primary key,
name  varchar(255) not null,
manufacturer  varchar(255) not null,
release_date  date not null

);

ALTER TABLE Platform RENAME COLUMN id_publisher TO id_platform;

INSERT INTO Platform (name, manufacturer, release_date) VALUES
('Platform1', 'ManufacturerA', '2023-01-01'),
('Platform2', 'ManufacturerB', '2023-02-10'),
('Platform3', 'ManufacturerC', '2023-03-20');

SELECT * FROM Platform;

--Orders_are_related_to_promotions(id_order*(Orders),id_promotion*(Promotions))

CREATE TABLE Orders_are_related_to_promotions(
id_order integer references Orders(id_order),
id_promotion integer references Promotions(id_promotion),
primary key(id_order,id_promotion)

);
INSERT INTO Orders_are_related_to_promotions (id_order, id_promotion) VALUES
(1, 1),
(2, 2),
(3, 3);

SELECT * FROM Orders_are_related_to_promotions;


--Orders_contains_games(id_order*(Orders),id_game*(Games))
CREATE TABLE  Orders_contains_games(
    id_order integer references Orders(id_order),
    id_game integer references Games(id_game),
    primary key (id_order,id_game)
);
INSERT INTO Orders_contains_games (id_order, id_game) VALUES
(1, 1),
(2, 2),
(3, 3);

SELECT * FROM Orders_contains_games;
--Games_supports_platform(id_game*(Games),id_platform*(Platform))
CREATE TABLE Games_supports_platform(
  id_game integer references Games(id_game),
  id_platform integer references Platform(id_platform)
);
INSERT INTO Games_supports_platform (id_game, id_platform) VALUES
(1, 1),
(2, 2),
(3, 3);

SELECT * FROM Games_supports_platform;