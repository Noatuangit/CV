use casestudy;
-- 21
CREATE VIEW view_nhan_vien AS
    SELECT 
        nhanvien.ma_nv,
        ho_ten,
        ngay_sinh,
        cmnd,
        luong,
        phone,
        email,
        address,
        ma_vi_tri,
        ma_td,
        ma_bo_phan
    FROM
        nhanvienview_nhan_vien
            INNER JOIN
        hop_dong ON ngay_begin = '2021-04-25'
            AND nhanvien.ma_nv = hop_dong.ma_nv
            AND address regexp 'Đà Nẵng';

drop view view_nhan_vien;

select * from view_nhan_vien; 

-- 22
UPDATE view_nhan_vien 
SET 
    address = 'change Đà Nẵng to Huế'
WHERE
    address regexp 'Đà Nẵng';

-- 23
call find_khach_hang(2);

-- 24
call create_new_hd(9,1,5,2); -- false because 9 is duplicate

call create_new_hd(19,2,5,2); -- true because 19 is correct create_new_hd

-- 27a
select func_dem_dich_vu(4000000);

-- 27b
-- thu nghiem tinh ngay dai nhat theo ma khach hang
SELECT CALCULATORDAYDIFFMAX(4);

