create database if not exists case_study_m3;

use case_study_m3;

CREATE TABLE education_degree (
    id INT PRIMARY KEY,
    `name` VARCHAR(50)
);

CREATE TABLE positions (
    id INT PRIMARY KEY,
    `name` VARCHAR(50)
);

CREATE TABLE division (
    id INT PRIMARY KEY,
    `name` VARCHAR(50)
);

CREATE TABLE employee (
    id INT PRIMARY KEY,
    `name` VARCHAR(50),
    birthday DATE,
    id_card VARCHAR(50),
    salary DOUBLE,
    phone VARCHAR(50),
    email VARCHAR(50),
    address VARCHAR(50),
    position_id INT,
    education_degree_id INT,
    division_id INT,
    CONSTRAINT fk_e_p FOREIGN KEY (position_id)
        REFERENCES positions (id),
    CONSTRAINT fk_e_e_d FOREIGN KEY (education_degree_id)
        REFERENCES education_degree (id),
    CONSTRAINT fk_e_d FOREIGN KEY (division_id)
        REFERENCES division (id)
);

CREATE TABLE type_customer (
    id INT PRIMARY KEY,
    `name` VARCHAR(50)
);

CREATE TABLE customer (
    id INT PRIMARY KEY,
    type_customer_id INT,
    `name` VARCHAR(50),
    birthday DATE,
    id_card VARCHAR(50),
    gender BIT,
    phone VARCHAR(50),
    email VARCHAR(50),
    address VARCHAR(50),
    constraint fk_c_type foreign key (type_customer_id) references type_customer(id)
);

CREATE TABLE service_type (
    id INT PRIMARY KEY,
    `name` VARCHAR(50)
);

CREATE TABLE rent_type (
    id INT PRIMARY KEY,
    `name` VARCHAR(50),
    rent_type_cost DOUBLE
);

create table service(
id int primary key,
`name` varchar(50),
area int,
service_cost double,
max_people int,
standard_room varchar(50),
description_other_convenience varchar(50),
pool_area double,
number_of_floors int,
facility_text text(200),
rent_type_id int,
service_type_id int,
constraint fk_ser_type_rent foreign key (rent_type_id) references rent_type(id),
constraint fk_ser_type_facility foreign key (service_type_id) references service_type(id)
);

create table attach_service(
id int primary key,
`name` varchar(50),
attach_service_cost double,
attach_service_unit int,
attach_service_status varchar(50)
);

create table contract(
id int auto_increment primary key,
start_date datetime,
end_date datetime,
deposit double,
total_money double,
total_money double,
employee_id int,
customer_id int,
service_id int,
constraint fk_c_e foreign key (employee_id) references employee(id),
constraint fk_c_c foreign key (customer_id) references customer(id),
constraint fk_c_s foreign key (service_id) references service(id)
);

create table contract_details(
id int primary key,
contract_id int,
attach_service_id int,
quantity int,
constraint fk_cd_as foreign key (attach_service_id) references attach_service(id),
constraint fk_cd_c foreign key (contract_id) references contract(id)
);

DELIMITER $$
create trigger delete_contract
before delete on contract
for each row 
begin 
delete from contract_details where contract_details.contract_id = old.id;
end$$

DELIMITER ;

DELIMITER $$
create trigger delete_customer
before delete on customer
for each row 
begin 
delete from contract where contract.customer_id = old.id;
end$$

DELIMITER ;

DELIMITER $$
create trigger delete_employee
before delete on employee
for each row 
begin 
delete from contract where contract.customer_id = old.id;
end$$

DELIMITER ;
DELIMITER $$
create trigger delete_service
before delete on service
for each row 
begin 
delete from contract where contract.service_id = old.id;
end$$

DELIMITER ;
DROP procedure IF EXISTS `delete_table`;

DROP procedure IF EXISTS `case_study_m3`.`delete_table`;
;

DELIMITER $$
USE `case_study_m3`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_table`(in id_delete int)
BEGIN
delete from customer where customer.id  = id_delete;
END$$

DELIMITER ;


DROP function IF EXISTS `total_money_service`;

DELIMITER $$
USE `case_study_m3`$$
CREATE FUNCTION `total_money_service` (id_service int)
RETURNS INTEGER deterministic
BEGIN
declare total int;
select (service_cost + rent_type_cost) into total from service inner join rent_type on service.rent_type_id =  rent_type.id and service.id = id_service;
RETURN total;
END$$
DELIMITER ;


insert into education_degree values
(1,"Intermediate"),
(2,"Degree Of Associate"),
(3,"Undergraduate"),
(4,"Post graduate");

insert into positions values 
(1,"Receptionist "),
(2,"Expert"),
(3,"Supervisor"),
(4,"Manager"),
(5,"President");

insert into division values
(1,"Sale – Marketing"),
(2,"Administration"),
(3,"Service"),
(4,"Manager");

insert into type_customer values 
(1,"Diamond"),
(2,"Platinum"),
(3,"Gold"),
(4,"Silver"),
(5,"Member");

insert into rent_type values (1,"year",1000),(2,"month",700),(3,"day",300),(4,"hour",100);

insert into service_type values (1,"room"),(2,"house"),(3,"villa");

INSERT INTO `case_study_m3`.`customer` (`id`, `type_customer_id`, `name`, `birthday`, `id_card`, `gender`, `phone`, `email`, `address`) VALUES 
('1', '1', 'Le Thai Viet', '1992-04-11', 'CT-1221', b'1', '0999988221', 'cumeo154@gmail.com', 'Da Nang'),
('2', '4', 'Thai Khang', '2019-07-18', 'CT-1289', b'1', '0488111201', 'piukhang11@gmail.com', 'Da Nang'),
('3', '3', 'Le Thai Phuong', '1992-12-11', 'CT-1992', b'1', '0918288577', 'Phuong@gmail.com', 'Da Nang'),
('4', '5', 'Pham Thi Thuy Tien', '1989-12-27', 'CT-1983', b'0', '0917728158', 'Atien@gmail.com', 'Hoi An'),
('5', '2', 'Le Thai Anh', '1990-07-11', 'CT-2881', b'1', '0977481279', 'AnhPro@gmail.com', 'Vinh'),
('6', '3', 'Pham Thao Uyen', '1992-04-14', 'CT-8921', b'0', '0977281098', 'UyenXiTRum@gmail.com', 'Nghe An'),
('7', '1', 'Le Thi Min', '2022-01-24', 'CT-1982', b'0', '0762819280', 'MinmIN@gmail.com', 'Hoi An'),
('8', '1', 'Pham Ngoc', '1992-11-11', 'CT-2981', b'0', '0762732281','MinmIN2@gmail.com', 'Vinh'),
('9', '4', 'Nguyen Anh Quang', '1990-01-12', 'CT-1992', b'1', '0762817675', 'MinmIN3@gmail.com', 'Vinh'),
('10', '2', 'Ngoc Tuan A', '1990-09-22','CT-2911', b'0', '0762812222', 'MinmIN4@gmail.com', 'Sai Gon'),
('11', '3', 'Tran Van Chat', '1990-07-25', 'CT-2991', b'1', '0762876542', 'MinmIN5@gmail.com', 'Da Nang'),
('12', '4', 'Tuan Anh', '1990-11-12', 'CT-2991', b'0', '0762817125', 'MinmIN6@gmail.com', 'Da Nang');

INSERT INTO `case_study_m3`.`employee` (`id`, `name`, `birthday`, `id_card`, `salary`, `phone`, `email`, `address`, `position_id`, `education_degree_id`, `division_id`) VALUES 
('3', 'Nguyen THuy', '1990-02-11', 'NV-992', '1300', '0882781816', 'thuyMin@gmail.com', 'Vinh', '2', '3', '1'),
('4', 'Thai Viet', '1990-12-11', 'NV-848', '1200', '0987271877', 'Thayanw@gmail.com', 'Da Nang', '2', '1', '3'),
('5', 'Van Binh', '1990-10-09', 'NV-288', '1700', '0782168862', 'VanBinh@gmail.com', 'Hoi An', '1', '3', '4'),
('1', 'Thi Min', '2022-01-24', 'NV-112', '1500', '0913449922', 'minYeu@gmail.com', 'Da Nang', '5', '2', '3'),
('2', 'Thai Phuong', '1994-08-19', 'NV-190', '2000', '0947721122', 'lanKute@gmail.com', 'Hoi An', '4', '2', '2'),
('6', 'Van An', '1990-11-21', 'NV-192', '500', '0981028819', 'VanAn@gmail.com', 'Vinh', '1', '4', '2'),
('7', 'Thuy Tien', '1989-12-21', 'NV-190', '1000', '0491283193', 'ThuyTien@gmail.com', 'Sai Gon', '3', '4', '4'),
('8', 'Anh Quang', '2022-01-07', 'NV-911', '800', '0938727171', 'anhQuannAn@gmail.com', 'Vinh', '2', '4', '3'),
('9', 'Anh Quang', '1990-02-19', 'NV-128', '700', '0934899271', 'ThayanhQuang@gmail.com', 'Da Nang', '1', '1', '2'),
('10', 'Anh Quang', '1990-12-07', 'NV-941', '800', '0933193771', 'anhQuangKute@gmail.com', 'Da Nang', '5', '1', '4');

INSERT INTO `case_study_m3`.`service` (`id`, `name`, `area`, `service_cost`, `max_people`, `standard_room`, `description_other_convenience`, `pool_area`, `number_of_floors`, `facility_text`, `rent_type_id`, `service_type_id`) VALUES 
('1', 'PG', '100', '200', '6', 'normal', 'wifi', '0', '3', 'good', '3', '3'),
('2', 'BG', '300', '500', '10', 'vip', 'car', '50', '1', 'amazing', '2', '1'),
('3', 'MB', '200', '350', '4', 'normal', 'bicyle', '10', '0', 'normal', '1', '2'),
('4', 'BB', '300', '550', '8', 'vip', 'helicopter', '10', '0', 'gob', '1', '3');



INSERT INTO `case_study_m3`.`attach_service` (`id`, `name`, `attach_service_cost`, `attach_service_unit`, `attach_service_status`) VALUES ('1', 'Yoga', '100', '4', 'on');
INSERT INTO `case_study_m3`.`attach_service` (`id`, `name`, `attach_service_cost`, `attach_service_unit`, `attach_service_status`) VALUES ('2', 'Football', '200', '2', 'on');
INSERT INTO `case_study_m3`.`attach_service` (`id`, `name`, `attach_service_cost`, `attach_service_unit`, `attach_service_status`) VALUES ('3', 'Bar', '300', '3', 'on');
INSERT INTO `case_study_m3`.`attach_service` (`id`, `name`, `attach_service_cost`, `attach_service_unit`, `attach_service_status`) VALUES ('4', 'Massage', '400', '4', 'on');
INSERT INTO `case_study_m3`.`attach_service` (`id`, `name`, `attach_service_cost`, `attach_service_unit`, `attach_service_status`) VALUES ('5', 'Golf', '500', '5', 'on');
INSERT INTO `case_study_m3`.`contract` (`id`, `start_date`, `end_date`, `deposit`, `employee_id`, `customer_id`, `service_id`) VALUES ('1', '2022-04-11 11:11:00', '2022-12-12 23:11:00', '1000', '1', '1', '3');
INSERT INTO `case_study_m3`.`contract` (`id`, `start_date`, `end_date`, `deposit`, `employee_id`, `customer_id`, `service_id`) VALUES ('2', '2022-08-11 11:11:00', '2022-10-12 23:11:00', '400', '2', '2', '2');
INSERT INTO `case_study_m3`.`contract` (`id`, `start_date`, `end_date`, `deposit`, `employee_id`, `customer_id`, `service_id`) VALUES ('5', '2022-08-11 11:11:00', '2022-09-12 23:11:00', '1000', '4', '5', '1');
insert into contract (start_date, end_date, deposit, total_money, employee_id, customer_id, service_id) values 
("2022-01-12","2022-02-12",100,total_money_service(1),1,2,1),
('2022-02-12','2022-02-17',200,total_money_service(3),1,2,3);
INSERT INTO `case_study_m3`.`contract_details` (`id`, `contract_id`, `attach_service_id`, `quantity`) VALUES ('1', '1', '2', '2');
INSERT INTO `case_study_m3`.`contract_details` (`id`, `contract_id`, `attach_service_id`, `quantity`) VALUES ('2', '1', '3', '1');
INSERT INTO `case_study_m3`.`contract_details` (`id`, `contract_id`, `attach_service_id`, `quantity`) VALUES ('3', '2', '1', '3');
INSERT INTO `case_study_m3`.`contract_details` (`id`, `contract_id`, `attach_service_id`, `quantity`) VALUES ('4', '5', '3', '1');
INSERT INTO `case_study_m3`.`contract_details` (`id`, `contract_id`, `attach_service_id`, `quantity`) VALUES ('5', '1', '2', '2');

