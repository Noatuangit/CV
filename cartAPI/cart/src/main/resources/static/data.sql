create database if not exists cartSomething;

use cartSomething;

create table product(
id int auto_increment primary key,
`name` varchar(50),
quantity int,
price double,
avatar varchar(50)
);

insert into product (`name`,quantity,price,avatar) values ('betta halfmon',10,5.5,"betta1.jpg"),('betta 2 tail',4,4,"betta11.jpg"),('betta red fancy',5,4.3,"betta2.jpg"),('betta marble',6,3,"betta10.jpg");

create table customer(
id int auto_increment primary key,
`name` varchar(50),
email varchar(50)
);

insert into customer(`name`,email) values ('tuanLee','tuanlee@gmail.com'),('khangPiu','piupiu@gmail.com');

create table orders(
id int auto_increment primary key,
customer_id int,
foreign key (customer_id) references customer(id)
);

create table shopCart(
id int auto_increment primary key,
orders_id int,
product_id int,
quantity int,
money int,
foreign key (product_id) references product(id),
foreign key (orders_id) references orders(id)
);
USE `cartsomething`;
DROP function IF EXISTS `calculatorMoney`;

USE `cartsomething`;
DROP function IF EXISTS `cartsomething`.`calculatorMoney`;
;

DELIMITER $$
USE `cartsomething`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `calculatorMoney`(product_id_buy int, quantity_buy int) RETURNS double
    DETERMINISTIC
BEGIN
declare total double;
select (quantity_buy * price) into total from shopcart inner join product where product_id = product.id and product.id = product_id_buy;
RETURN total;
END$$

DELIMITER ;
;

