
use testOrder
go

create table customer(
id varchar(10) primary key ,
[name] varchar(100),
gender varchar(10),
phone varchar(100)
);

create table orders(
id varchar(10) primary key ,
customerId varchar(10),
dateOrder date,
statusCheckOut varchar(100),
dateEnd date, 
statusOrder varchar(100),
datePay date, 
constraint fk_order_customer foreign key (customerId) references customer(id)
);

create table details (
id varchar(10) primary key ,
orderId varchar (10),
name varchar(100),
total money,
note varchar(100),
constraint fk_order_details foreign key (orderId) references details(id)
);