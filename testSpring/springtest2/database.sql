create database springtest2;
go 
use springtest2;
go 
create table building (
id varchar(100) primary key,
name varchar(100));

create table managerBuilding(
id varchar(100) primary key,
idPlate varchar(100),
buildingId varchar(100),
area int, 
name nvarchar(100),
phone varchar(20),
monthjoin date,
numberMonth int, 
dayEnd date, 
total money,
constraint fk_mn_b foreign key (buildingId) references building (id)
);

insert into building values ('TN001','Plaza-1'),('TN002','Plaza-2'),('TN003','Plaza-3'),('TN004','Plaza-4');