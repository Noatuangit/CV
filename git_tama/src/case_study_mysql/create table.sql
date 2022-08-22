create database if not exists casestudy;

use casestudy;

CREATE TABLE trinh_do (
    ma_td INT PRIMARY KEY,
    ten_td VARCHAR(50)
);

CREATE TABLE vi_tri (
    ma_vi_tri INT PRIMARY KEY,
    ten_vi_tri VARCHAR(50)
);

CREATE TABLE bo_phan (
    ma_bo_phan INT PRIMARY KEY,
    ten_bo_phan VARCHAR(50)
);

CREATE TABLE nhanvien (
    ma_nv INT PRIMARY KEY,
    ho_ten VARCHAR(50),
    ngay_sinh DATE,
    cmnd VARCHAR(50),
    luong DOUBLE,
    phone VARCHAR(50),
    email VARCHAR(50),
    address VARCHAR(50),
    ma_vi_tri INT,
    ma_td INT,
    ma_bo_phan INT,
    trang_thai VARCHAR(5) DEFAULT 'on',
    CONSTRAINT fk_nv_vt FOREIGN KEY (ma_vi_tri)
        REFERENCES vi_tri (ma_vi_tri),
    CONSTRAINT fk_nv_bp FOREIGN KEY (ma_bo_phan)
        REFERENCES bo_phan (ma_bo_phan),
    CONSTRAINT fk_nv_td FOREIGN KEY (ma_td)
        REFERENCES trinh_do (ma_td)
);

create table loai_khach(
ma_lk int primary key,
ten_lk varchar(50)
);

CREATE TABLE khach_hang (
    ma_kh INT PRIMARY KEY,
    ma_lk INT,
    ho_ten VARCHAR(50),
    ngay_sinh DATE,
    gioi_tinh BIT(1),
    cmnd VARCHAR(50),
    phone VARCHAR(50),
    email VARCHAR(50),
    address VARCHAR(50),
    trang_thai VARCHAR(5) DEFAULT 'on',
    CONSTRAINT fk_kh_lk FOREIGN KEY (ma_lk)
        REFERENCES loai_khach (ma_lk)
);

CREATE TABLE loai_dv (
    ma_loai_dv INT PRIMARY KEY,
    ten_loai_dv VARCHAR(50)
);

CREATE TABLE kieu_thue (
    ma_kt INT PRIMARY KEY,
    ten_kt VARCHAR(50)
);

CREATE TABLE dich_vu (
    ma_dv INT PRIMARY KEY,
    ten_dv VARCHAR(50),
    dien_tich INT,
    chi_phi_thue DOUBLE,
    max_people INT,
    ma_kt INT,
    ma_loai_dv INT,
    tieu_chuan VARCHAR(50),
    tien_nghi VARCHAR(50),
    dien_tich_pool DOUBLE,
    so_tang INT,
    dich_vu_free_kem TEXT,
    CONSTRAINT fk_dv_kt FOREIGN KEY (ma_kt)
        REFERENCES kieu_thue (ma_kt),
    CONSTRAINT fk_dv_loai_dv FOREIGN KEY (ma_loai_dv)
        REFERENCES loai_dv (ma_loai_dv)
);

CREATE TABLE hop_dong (
    ma_hd INT PRIMARY KEY,
    ngay_begin DATE,
    ngay_end DATE,
    money DOUBLE,
    ma_nv INT,
    ma_kh INT,
    ma_dv INT,
    trang_thai VARCHAR(5) DEFAULT 'on',
    CONSTRAINT fk_hd_dv FOREIGN KEY (ma_dv)
        REFERENCES dich_vu (ma_dv), 
    CONSTRAINT fk_hd_kh FOREIGN KEY (ma_kh)
        REFERENCES khach_hang (ma_kh),
    CONSTRAINT fk_hd_nv FOREIGN KEY (ma_nv)
        REFERENCES nhanvien (ma_nv)
);

CREATE TABLE dich_vu_kem (
    ma_dv_kem INT PRIMARY KEY,
    ten_dv_kem VARCHAR(50),
    price DOUBLE,
    don_vi VARCHAR(50),
    trang_thai VARCHAR(50)
);

CREATE TABLE hd_info (
    ma_hd_info INT PRIMARY KEY,
    ma_hd INT,
    ma_dv_kem INT,
    so_luong INT,
    CONSTRAINT fk_hd_info_hd FOREIGN KEY (ma_hd)
        REFERENCES hop_dong (ma_hd),
    CONSTRAINT fk_hd_info_dich_vu_kem FOREIGN KEY (ma_dv_kem)
        REFERENCES dich_vu_kem (ma_dv_kem)
);

INSERT INTO `casestudy`.`bo_phan` (`ma_bo_phan`, `ten_bo_phan`) VALUES 
('1', 'Sale-Marketing'),
('2', 'hanh chinh'),
('3', 'phuc vu'),
('4','quan ly');

INSERT INTO `casestudy`.`trinh_do` (`ma_td`, `ten_td`) VALUES 
('1', 'trung cap'),
('2', 'cao dang'),
('3', 'dai hoc'),
('4','sau dai hoc');

INSERT INTO `casestudy`.`vi_tri` (`ma_vi_tri`, `ten_vi_tri`) VALUES 
('1', 'quan ly'),
('2', 'nhan vien');

INSERT INTO `casestudy`.`nhanvien` (`ma_nv`, `ho_ten`, `ngay_sinh`, `cmnd`, `luong`, `phone`, `email`, `address`, `ma_vi_tri`, `ma_td`, `ma_bo_phan`)
 VALUES ('1', 'Nguyễn Văn An', '1970-11-07', '413131', '123445', '41241244', 'nv1441@gmail.com', '295 Nguyễn Tất Thành, Đà Nẵng', '1', '3', '1'),
 ('2', 'Lê Văn Bình', '1997-04-09', '513131', '233411', '5125125', 'nv5111@gmail.com', '22 Yên Bái, Đà Nẵng', '1', '2', '2'),
 ('3', 'Hồ Thị Yến', '1997-04-09', '515555', '321121', '12313123', 'nv15112@gmail.com', 'K234/11 Điện Biên Phủ, Gia Lai', '1', '3', '2'),
 ('4', 'Võ Công Toản', '1980-04-04', '984567', '125521', '5623244', 'nv15512@gmail.com', '77 Hoàng Diệu, Quảng Trị', '1', '4', '4'),
 ('5', 'Nguyễn Bỉnh Phát', '1999-12-09', '984567', '125521', '5623244', 'nv15512@gmail.com', '43 Yên Bái, Đà Nẵng', '2', '1', '1'),
 ('6', 'Khúc Nguyễn An Nghi', '2000-11-08', '984567', '125521', '5623244', 'nv15512@gmail.com', '294 Nguyễn Tất Thành, Đà Nẵng', '2', '2', '3'),
 ('7', 'Nguyễn Hữu Hà', '1993-01-01', '984567', '125521', '5623244', 'nv15512@gmail.com', '4 Nguyễn Chí Thanh, Huế', '2', '3', '2'),
 ('8', 'Nguyễn Hà Đông', '1989-09-03', '984567', '125521', '5623244', 'nv15512@gmail.com', '111 Hùng Vương, Hà Nội', '2', '4', '4'),
 ('9', 'Tòng Hoang', '1982-09-03', '984567', '125521', '5623244', 'nv15512@gmail.com', '213 Hàm Nghi, Đà Nẵng', '2', '4', '4'),
 ('10', 'Nguyễn Công Đạo', '1994-01-08', '984567', '125521', '5623244', 'nv15512@gmail.com', '6 Hoà Khánh, Đồng Nai', '2', '3', '2');
 
 INSERT INTO `casestudy`.`loai_khach` (`ma_lk`, `ten_lk`) VALUES 
 ('1', 'diamond'),
('2', 'platinum'),
('3', 'gold'),
('4', 'silver'),
('5','member');

INSERT INTO `casestudy`.`khach_hang` (`ma_kh`, `ma_lk`, `ho_ten`, `ngay_sinh`, `gioi_tinh`, `cmnd`, `phone`, `email`, `address`) VALUES 
('1', '5', 'Nguyễn Thị Hào', '1970-11-07', b'1', '11413', '40959', 'cumeo154@gmail.com','23 Nguyễn Hoàng, Đà Nẵng'),
('2', '3', 'Phạm Xuân Diệu', '1992-08-08', b'1', '99212', '41211', 'piupiu1@gmail.com', 'K77/22 Thái Phiên, Quảng Trị'),
('3', '1', 'Trương Đình Nghệ', '1990-02-27', b'0', '28811', '12431', 'piupiu12@gmail.com', 'K323/12 Ông Ích Khiêm, Vinh'),
('4', '1', 'Dương Văn Quan', '1981-07-08', b'0', '51212', '51221', 'piupiu15@gmail.com', 'K453/12 Lê Lợi, Đà Nẵng'),
('5', '4', 'Hoàng Trần Nhi Nhi', '1995-12-09', b'0', '50019', '09531', 'piupiu11@gmail.com', '224 Lý Thái Tổ, Gia Lai'),
('6', '4', 'Tôn Nữ Mộc Châu', '2005-12-06', b'1', '87122', '99531', 'piupiu95@gmail.com', '37 Yên Thế, Đà Nẵng'),
('7', '1', 'Nguyễn Mỹ Kim', '1984-04-08', b'0', '50979', '78921', 'piupiu1411@gmail.com', 'K123/45 Lê Lợi, Hồ Chí Minh'),
('8', '3', 'Nguyễn Thị Hào', '1999-04-08', b'1', '51111', '98021', 'piupiu189@gmail.com', '55 Nguyễn Văn Linh, Kon Tum'),
('9', '1', 'Trần Đại Danh', '1994-07-01', b'1', '09785', '97811', 'piupiu1902@gmail.com', '24 Lý Thường Kiệt, Quảng Ngãi'),
('10', '2', 'Nguyễn Tâm Đắc', '1989-07-01', b'0', '88592', '72158', 'thuytien@gmail.com', '22 Ngô Quyền, Đà Nẵng');

INSERT INTO `casestudy`.`kieu_thue` (`ma_kt`, `ten_kt`) VALUES ('1', 'year'),
('2', 'month'),
('3', 'day'), 
('4', 'hour');

INSERT INTO `casestudy`.`dich_vu_kem` (`ma_dv_kem`, `ten_dv_kem`, `price`, `don_vi`, `trang_thai`) 
VALUES ('1', 'karaoke', '10000', 'gio', 'tiện nghi, hiện tại'),
('2', 'Thuê xe máy', '10000', 'chiec', 'hỏng 1 xe'),
('3', 'Thuê xe đạp', '20000', 'chiec', 'tốt'),
('4', 'Buffet buổi sáng', '15000', 'suat', 'đầy đủ đồ ăn, tráng miệng'),
('5', 'Buffet buổi trưa', '90000', 'suat', 'đầy đủ đồ ăn, tráng miệng'),
('6', 'Buffet buổi tối', '16000', 'suat', 'đầy đủ đồ ăn, tráng miệng');

INSERT INTO `casestudy`.`loai_dv` (`ma_loai_dv`, `ten_loai_dv`) VALUES 
('1', 'villa'),
('2', 'room'),
('3', 'house');

INSERT INTO `casestudy`.`dich_vu` (`ma_dv`, `ten_dv`, `dien_tich`, `chi_phi_thue`, `max_people`, `ma_kt`, `ma_loai_dv`, `tieu_chuan`, `tien_nghi`, `dien_tich_pool`, `so_tang`, `dich_vu_free_kem`) VALUES 
('1', 'Villa Beach Front', '25000', '1000000', '10', '3', '1', 'VIP', 'Có hồ bơi', '500', '3', 'car'),
('2', 'House Princess 01', '14000', '5000000', '7', '2', '2', 'VIP', 'Có thêm bếp nướng', '0', '2', '0'),
('3', 'Room Twin 01', '5000', '1000000', '2', '4', '3', 'Normal', 'Có tivi', '0', '0', '1 Xe máy, 1 Xe đạp'),
('4', 'Villa No Beach Front', '22000', '9000000', '8', '3', '1', 'Normal', 'Có hồ bơi', '300', '3', '0'),
('5', 'House Princess 02', '10000', '4000000', '5', '3', '2', 'Normal', 'Có thêm bếp nướng', '0', '2', '0'),
('6', 'Room Twin 02', '3000', '900000', '2', '4', '3', 'Normal', 'Có tivi', '0', '0', '1 xe máy');

INSERT INTO `casestudy`.`hop_dong` (`ma_hd`, `ngay_begin`, `ngay_end`, `money`, `ma_nv`, `ma_kh`, `ma_dv`) VALUES 
('1', '2020-12-08', '2020-12-08', '0', '3', '1', '3'),
('2', '2020-07-14', '2020-07-21', '200000', '7', '3', '1'),
('3', '2021-03-15', '2021-03-17', '50000', '3', '4', '2'),
('4', '2021-01-14', '2021-01-18', '100000', '7', '5', '5'),
('5', '2021-07-14', '2021-07-15', '0', '7', '2', '6'),
('6', '2021-06-01', '2021-06-03', '0', '7', '7', '6'),
('7', '2021-09-02', '2021-09-05', '100000', '7', '4', '4'),
('8', '2021-06-17', '2021-06-18', '150000', '3', '4', '1'),
('9', '2020-11-19', '2020-11-19', '0', '3', '4', '3'),
('10', '2021-04-12', '2021-04-14', '0', '10', '3', '5'),
('11', '2021-04-25', '2021-04-25', '0', '2', '2', '1'),
('12', '2021-05-25', '2021-05-27', '0', '7', '10', '1');

INSERT INTO `casestudy`.`hd_info` (`ma_hd_info`, `ma_hd`, `ma_dv_kem`, `so_luong`) VALUES 
('1', '2', '4', '5'),
('2', '2', '5', '8'),
('3', '2', '6', '15'),
('4', '3', '1', '1'),
('5', '3', '2', '11'),
('6', '1', '3', '1'),
('7', '1', '2', '2'),
('8', '12', '2', '2');

USE `casestudy`;
DROP function IF EXISTS `calculatorAge`;

DELIMITER $$
USE `casestudy`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `calculatorAge`(birthday date) RETURNS int
    DETERMINISTIC
BEGIN
RETURN TIMESTAMPDIFF(year,birthday,now());
END$$

DELIMITER ;

USE `casestudy`;
DROP function IF EXISTS `findkhachhangbyYearAndSumMoneyPay`;

DELIMITER $$
USE `casestudy`$$
CREATE FUNCTION `findkhachhangbyYearAndSumMoneyPay` (year_begin int, money_choice int )
RETURNS INTEGER deterministic
BEGIN
declare result int;
SELECT 
            hop_dong.ma_kh into result
        FROM
            khach_hang
                LEFT JOIN
            hop_dong ON hop_dong.ma_kh = khach_hang.ma_kh
                AND YEAR(ngay_begin) = year_begin
                LEFT JOIN
            loai_khach ON khach_hang.ma_lk = loai_khach.ma_lk
                LEFT JOIN
            dich_vu ON dich_vu.ma_dv = hop_dong.ma_dv
                LEFT JOIN
            loai_dv ON loai_dv.ma_loai_dv = dich_vu.ma_loai_dv
                LEFT JOIN
            hd_info ON hd_info.ma_hd = hop_dong.ma_hd
                LEFT JOIN
            dich_vu_kem ON dich_vu_kem.ma_dv_kem = hd_info.ma_dv_kem
        GROUP BY hop_dong.ma_hd
        HAVING SUM(CALCULATORTOTAL(price, so_luong, chi_phi_thue)) > money_choice;
RETURN result;
END$$

DELIMITER ;

USE `casestudy`;
DROP function IF EXISTS `count_so_hd_con_lai`;

DELIMITER $$
USE `casestudy`$$
CREATE FUNCTION `count_so_hd_con_lai` ()
RETURNS INTEGER deterministic
BEGIN
declare result int;
select count(ma_hd) into result from hop_dong where trang_thai = "on";
RETURN result;
END$$

DELIMITER ;


USE `casestudy`;
DROP function IF EXISTS `casestudy`.`calculatorTotal`;
;

DELIMITER $$
USE `casestudy`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `calculatorTotal`(price double, so_luong int, money double ) RETURNS int
    DETERMINISTIC
BEGIN
if(price is null or so_luong is null) then return money;
end if;
RETURN money + (price * so_luong);
END$$

DELIMITER ;
;


-- tim ma khach hang co thoi gian dat dai nhat
USE `casestudy`;
DROP function IF EXISTS `calculatorDayDiffMax`;

DELIMITER $$
USE `casestudy`$$
CREATE FUNCTION `calculatorDayDiffMax` (ma_kh int)
RETURNS INTEGER deterministic
BEGIN
declare result int;
select timestampdiff(day,ngay_begin, ngay_end) as diff_day into result from hop_dong 
inner join khach_hang on khach_hang.ma_kh = hop_dong.ma_kh and hop_dong.ma_kh = ma_kh
group by ma_hd
order by diff_day desc limit 1;
RETURN result;
END$$

DELIMITER ;

USE `casestudy`;
DROP function IF EXISTS `isCorrectData`;

DELIMITER $$
USE `casestudy`$$
CREATE FUNCTION `isCorrectData` (ma_hd_new int, ma_nv_new int, ma_kh_new int, ma_dv_new int)
RETURNS boolean deterministic
BEGIN
if(select ma_hd_new in (select ma_hd from hop_dong) = 1) then
return false;
else if(select ma_nv_new in (select ma_nv from nhanvien) = 0) then
return false;
else if(select ma_kh_new in (select ma_kh from khach_hang) = 0) then
return false;
else if(select ma_dv_new in (select ma_dv from dich_vu) = 0) then
return false;
end if;
end if;
end if;
end if;
RETURN true;
END$$

DELIMITER ;
USE `casestudy`;
DROP procedure IF EXISTS `delete_khach_hang`;

DELIMITER $$
USE `casestudy`$$
CREATE PROCEDURE `delete_khach_hang` (ma_k_h int)
BEGIN
delete from khach_hang where khach_hang.ma_kh = ma_k_h;
END$$

DELIMITER ;

USE `casestudy`;
DROP procedure IF EXISTS `find_khach_hang`;

DELIMITER $$
USE `casestudy`$$
CREATE PROCEDURE `find_khach_hang` (ma_k_h int)
BEGIN
select * from khach_hang where khach_hang.ma_kh = ma_k_h;
END$$

DELIMITER ;

USE `casestudy`;
DROP procedure IF EXISTS `create_new_hd`;

DELIMITER $$
USE `casestudy`$$
CREATE PROCEDURE `create_new_hd` (ma_hd_new int, ma_nv_new int, ma_kh_new int, ma_dv_new int)
BEGIN
if(select isCorrectData(ma_hd_new,ma_nv_new,ma_kh_new,ma_dv_new) = 1) then
insert into hop_dong(ma_hd,ma_nv,ma_kh,ma_dv) values(ma_hd_new,ma_nv_new,ma_kh_new,ma_dv_new);
end if;
END$$

DELIMITER ;

use casestudy;

CREATE TABLE trigger_data (
    so_luong_hd_con INT PRIMARY KEY,
    ngay_action datetime,
    ngay_begin datetime,
    ngay_end_new DATE,
    ngay_end_old DATE,
    actions VARCHAR(40)
);
use casestudy;
-- 25
CREATE 
    TRIGGER  count_sl_hd_after_update
 AFTER update ON hop_dong FOR EACH ROW 
    INSERT INTO trigger_data SET actions = 'delete' , ngay_action = NOW() , ngay_end_new = old.ngay_end , ngay_end_old = old.ngay_end , so_luong_hd_con = COUNT_SO_HD_CON_LAI();

drop table trigger_data;
drop trigger count_sl_hd_after_delete;
DROP TRIGGER IF EXISTS update_ngay_end;
DELIMITER $$

-- 26
create trigger update_ngay_end
before update on hop_dong 
for each row 
begin 
if new.ngay_end < ADDDATE(old.ngay_begin,INTERVAL 2 DAY) then
signal sqlstate '45000' set message_text = 'new day must bigger old day 2 days';
else insert into trigger_data
set actions = "update",
ngay_action = now(),
ngay_begin = old.ngay_begin,
ngay_end_new = new.ngay_end,
ngay_end_old = old.ngay_end,
so_luong_hd_con = old.ma_hd;
end if;
end$$

DELIMITER ;

DROP procedure IF EXISTS `searchMaHopDongInYear`;

DELIMITER $$
USE `casestudy`$$
CREATE PROCEDURE `searchMaHopDongInYear` (year_check int)
BEGIN
select ma_hd from hop_dong where year(ngay_begin) = year_check;
END$$

DELIMITER ;

DROP function IF EXISTS func_dem_dich_vu;
 -- 27 a
delimiter $$
create function func_dem_dich_vu (money int)
returns int
deterministic
begin
	declare result int;
	select count(*) into result from
	(
		select
			dich_vu.ma_dv
		from dich_vu
			join hop_dong on hop_dong.ma_dv = dich_vu.ma_dv
			left join hd_info on hop_dong.ma_hd = hd_info.ma_hd
			left join dich_vu_kem on hd_info.ma_dv_kem= dich_vu_kem.ma_dv_kem
		group by dich_vu.ma_dv
		having SUM(chi_phi_thue + ifnull( so_luong * price,0)) >= money
    ) as tmp;
return result;
end $$
delimiter ;