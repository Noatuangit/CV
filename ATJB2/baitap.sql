create database ATJB2;
go
use ATJB2;
go

create table customer(
id varchar(20) primary key,
[name] nvarchar(100),
[address] nvarchar(100),
phone varchar(20),
email varchar(100),
[status] varchar(10) default 'on'
 );

create table computer(
id varchar(20) primary key,
position varchar(100),
[status] varchar(10)
);

create table [service](
id varchar(20) primary key,
[name] nvarchar(100),
unit nvarchar(100),
price money
);

create table computer_detail(
customer_id varchar(20),
computer_id varchar(20),
date_begin date,
time_begin time(7),
time_use int,
primary key (customer_id, computer_id,date_begin,time_begin),
constraint fk_customer_computer foreign key (customer_id) references customer(id),
constraint fk_computer_customer foreign key (computer_id) references computer(id)
);

create table service_detail(
customer_id varchar(20),
service_id varchar(20),
date_use date,
time_begin time(7), 
amount int,
primary key (customer_id ,service_id,date_use,time_begin),
constraint fk_customer_service foreign key (customer_id) references customer(id),
constraint fk_service_customer foreign key (service_id) references [service](id)
);

insert into customer (id, name, address, phone, email) values ('KH00001', 'Hughie Myhill', '009 Lunder Pass', '0906981110', 'hmyhill0@about.com');
insert into customer (id, name, address, phone, email) values ('KH00002', 'Chryste Polglase', '2780 Holmberg Pass', '0908456577', 'cpolglase1@gov.uk');
insert into customer (id, name, address, phone, email) values ('KH00003', 'Dorine Meiklejohn', '22759 Cherokee Crossing', '0926572089', 'dmeiklejohn2@dailymail.co.uk');
insert into customer (id, name, address, phone, email) values ('KH00004', 'Hobey Spearett', '4 Colorado Street', '0202373745', 'hspearett3@github.io');
insert into customer (id, name, address, phone, email) values ('KH00005', 'Kristin Sleney', '4219 Warrior Trail', '0862107305', 'ksleney4@marriott.com');
insert into customer (id, name, address, phone, email) values ('KH00006', 'Tracey Mineghelli', '61365 Parkside Parkway', '0923981175', 'tmineghelli5@howstuffworks.com');
insert into customer (id, name, address, phone, email) values ('KH00007', 'Ruth Gurr', '579 Kenwood Street', '0395182742', 'rgurr6@bizjournals.com');
insert into customer (id, name, address, phone, email) values ('KH00008', 'Barri Gumary', '81 Orin Crossing', '0597632508', 'bgumary7@digg.com');
insert into customer (id, name, address, phone, email) values ('KH00009', 'Don Sinclar', '599 Ronald Regan Plaza', '0209503539', 'dsinclar8@php.net');
insert into customer (id, name, address, phone, email) values ('KH00010', 'Juditha Groves', '45904 Annamark Street', '0834983040', 'jgroves9@etsy.com');


insert into computer values ('MT00001','Stage 1','on'),('MT00002','Stage 2','waiting'),('MT00005','Stage 4','pending'),('MT00004','Stage 3','on'),('MT00003','Stage 2','pending'),('MT00006','Stage 2','waiting'); 
insert into [service] values ('SV00001','COMPUTER 1','Unit',100),('SV00221','LAPTOP 11','Unit',110),('SV40002','PEPSI','Unit', 50),('SV00002','COMPUTER 2','Unit', 120),('SV00005','COMPUTER 4','Plate', 80),('SV00004','COMPUTER 3','Plate',110),('SV00003','Rice','Unit',40),('SV00006','Water','Bottle',10); 
insert into computer_detail values('KH00003','MT00005','2023-01-01','11:30:12',4);
insert into computer_detail values('KH00002','MT00006','2023-01-01','11:30:11',4);