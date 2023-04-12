use casestudy;
-- 2
SELECT 
    *
FROM
    nhanvien
WHERE
    ho_ten REGEXP '^[HTK]'
        AND CHARACTER_LENGTH(ho_ten) <= 15;
-- 3
SELECT 
    *
FROM
    khach_hang
WHERE
    (CALCULATORAGE(ngay_sinh) BETWEEN 18 AND 50)
        AND address RLIKE 'Đà Nẵng'
        OR address RLIKE 'Quảng Trị';
-- 4
SELECT 
    khach_hang.ma_kh,
    khach_hang.ho_ten,
    COUNT(hop_dong.ma_kh) AS count_makh
FROM
    khach_hang
        INNER JOIN
    hop_dong ON hop_dong.ma_kh = khach_hang.ma_kh
        INNER JOIN
    loai_khach ON loai_khach.ma_lk = khach_hang.ma_lk
        AND ten_lk = 'diamond'
GROUP BY khach_hang.ma_kh
ORDER BY count_makh ASC;

-- 5 --
SELECT 
    khach_hang.ma_kh,
    ho_ten,
    ten_lk,
    hop_dong.ma_hd,
    ten_dv,
    ngay_begin,
    ngay_end,
    (chi_phi_thue + sum(IFNULL(so_luong * price, 0))) AS total_all
FROM
    khach_hang
        LEFT JOIN
    hop_dong ON hop_dong.ma_kh = khach_hang.ma_kh
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
GROUP BY hop_dong.ma_hd;

-- 6 --
SELECT 
    dich_vu.ma_dv,
    dich_vu.ten_dv,
    dich_vu.dien_tich,
    dich_vu.chi_phi_thue,
    ten_loai_dv
FROM
    dich_vu
        INNER JOIN
    loai_dv ON loai_dv.ma_loai_dv = dich_vu.ma_loai_dv
        AND dich_vu.ma_dv NOT IN (SELECT 
            dich_vu.ma_dv
        FROM
            dich_vu
                INNER JOIN
            hop_dong ON QUARTER(ngay_begin) = 1
                AND dich_vu.ma_dv = hop_dong.ma_dv
        GROUP BY dich_vu.ma_dv);

-- 7
SELECT 
    hop_dong.ma_dv,
    ten_dv,
    dien_tich,
    max_people,
    chi_phi_thue,
    ten_loai_dv
FROM
    dich_vu
        INNER JOIN
    hop_dong ON YEAR(ngay_begin) = 2020
        AND hop_dong.ma_dv = dich_vu.ma_dv
        AND hop_dong.ma_dv NOT IN (SELECT 
            ma_dv
        FROM
            hop_dong
        WHERE
            YEAR(ngay_begin) = 2021)
        INNER JOIN
    loai_dv ON dich_vu.ma_loai_dv = loai_dv.ma_loai_dv
GROUP BY dich_vu.ma_dv;

-- 3 cach loai ten giong nhau 
-- 8
SELECT 
    *
FROM
    khach_hang
GROUP BY ho_ten;

-- c2
SELECT DISTINCT
    ho_ten
FROM
    khach_hang;
    
-- c3
SELECT 
    ho_ten
FROM
    khach_hang 
UNION DISTINCT
SELECT 
    ho_ten
FROM
    khach_hang;


SELECT 
    COUNT(ma_kh)
FROM
    hop_dong
WHERE
    YEAR(ngay_begin) = 2021;

-- 9
SELECT 
    MONTH(ngay_begin) AS month_begin, COUNT(ma_kh)
FROM
    hop_dong
WHERE
    YEAR(ngay_begin) = 2021
GROUP BY month_begin
order by month_begin;

-- 10
SELECT 
    hop_dong.ma_hd,
    ngay_begin,
    ngay_end,
    money,
    SUM(so_luong) AS sum_so_luong
FROM
    hop_dong
        LEFT JOIN
    hd_info ON hd_info.ma_hd = hop_dong.ma_hd
GROUP BY hop_dong.ma_hd;

SELECT 
    khach_hang.ma_kh, hop_dong.ma_hd, ten_dv_kem
FROM
    khach_hang
        INNER JOIN
    loai_khach ON khach_hang.ma_lk = loai_khach.ma_lk
        AND ten_lk = 'diamond'
        AND (address RLIKE 'Vinh'
        OR address RLIKE 'Quảng Ngãi')
        INNER JOIN
    hop_dong ON hop_dong.ma_kh = khach_hang.ma_kh
        INNER JOIN
    hd_info ON hop_dong.ma_hd = hd_info.ma_hd
        INNER JOIN
    dich_vu_kem ON hd_info.ma_dv_kem = dich_vu_kem.ma_dv_kem
GROUP BY ten_dv_kem;

-- 12
SELECT 
    hop_dong.ma_hd,
    nhanvien.ho_ten,
    khach_hang.ho_ten,
    khach_hang.phone,
    dich_vu.ma_dv,
    ten_dv,
    SUM(so_luong),
    money
FROM
    khach_hang
        INNER JOIN
    hop_dong ON khach_hang.ma_kh = hop_dong.ma_kh
        AND QUARTER(ngay_begin) = 4
        AND ma_dv NOT IN (SELECT 
            ma_dv
        FROM
            hop_dong
        WHERE
            QUARTER(ngay_begin) BETWEEN 1 AND 2)
        INNER JOIN
    nhanvien ON hop_dong.ma_nv = nhanvien.ma_nv
        INNER JOIN
    dich_vu ON hop_dong.ma_dv = dich_vu.ma_dv
        LEFT JOIN
    hd_info ON hd_info.ma_hd = hop_dong.ma_hd
GROUP BY hop_dong.ma_hd;

-- 13
SELECT 
    dich_vu_kem.ma_dv_kem ten_dv_kem,
    SUM(so_luong) AS tong_sl,
    ten_dv,
    dich_vu_free_kem
FROM
    dich_vu
        INNER JOIN
    hop_dong ON hop_dong.ma_dv = dich_vu.ma_dv
        INNER JOIN
    hd_info ON hd_info.ma_hd = hop_dong.ma_hd
        INNER JOIN
    dich_vu_kem ON dich_vu_kem.ma_dv_kem = hd_info.ma_dv_kem
GROUP BY ten_dv_kem
HAVING tong_sl >= (SELECT 
        SUM(so_luong)
    FROM
        hd_info
    GROUP BY ma_dv_kem
    ORDER BY SUM(so_luong) DESC
    LIMIT 1)
ORDER BY tong_sl DESC;

select sum(so_luong) from hd_info  group by ma_dv_kem;

-- 14
SELECT 
    hd_info.ma_hd,
    hop_dong.ma_dv,
    ten_loai_dv,
    ten_dv_kem,
    COUNT(hd_info.ma_dv_kem)
FROM
    hd_info
        INNER JOIN
    dich_vu_kem ON hd_info.ma_dv_kem = dich_vu_kem.ma_dv_kem
        INNER JOIN
    hop_dong ON hop_dong.ma_hd = hd_info.ma_hd
        INNER JOIN
    dich_vu ON hop_dong.ma_dv = dich_vu.ma_dv
        INNER JOIN
    loai_dv ON dich_vu.ma_loai_dv = loai_dv.ma_loai_dv
GROUP BY hd_info.ma_dv_kem
HAVING COUNT(hd_info.ma_dv_kem) = 1
;

-- 15
SELECT 
    hop_dong.ma_nv,
    ho_ten,
    ten_td,
    ten_vi_tri,
    ten_bo_phan,
    phone
FROM
    hop_dong
        INNER JOIN
    nhanvien ON hop_dong.ma_nv = nhanvien.ma_nv
        INNER JOIN
    trinh_do ON nhanvien.ma_td = trinh_do.ma_td
        INNER JOIN
    vi_tri ON nhanvien.ma_vi_tri = vi_tri.ma_vi_tri
        INNER JOIN
    bo_phan ON nhanvien.ma_bo_phan = bo_phan.ma_bo_phan
        AND YEAR(ngay_begin) BETWEEN 2020 AND 2021
GROUP BY hop_dong.ma_nv
HAVING COUNT(hop_dong.ma_nv) <= 3;

-- 16
UPDATE nhanvien 
SET 
    nhanvien.trang_thai = 'off'
WHERE
    ma_nv NOT IN (SELECT DISTINCT
            ma_nv
        FROM
            hop_dong
        WHERE
            YEAR(ngay_begin) BETWEEN 2019 AND 2021);

-- 17 
UPDATE khach_hang 
SET 
    ma_lk = 1
WHERE
    ma_kh = findkhachhangbyYearAndSumMoneyPay(2021, 10000000);
      
-- 18

UPDATE khach_hang 
SET 
    khach_hang.trang_thai = 'off'
WHERE
    khach_hang.ma_kh IN (SELECT 
            ma_kh
        FROM
            hop_dong
        WHERE
            YEAR(ngay_begin) < 2021);
            
        -- delete data 
set foreign_key_checks  = 0;
DELETE FROM khach_hang 
WHERE
    ma_kh IN (SELECT 
        ma_kh
    FROM
        hop_dong
    
    WHERE
        YEAR(ngay_begin) < 2021);
set foreign_key_checks  = 1;

-- 19
UPDATE dich_vu_kem 
SET 
    price = price * 2
WHERE
    ma_dv_kem = (SELECT 
            ma_dv_kem
        FROM
            hd_info
                INNER JOIN
            hop_dong ON hd_info.ma_hd = hop_dong.ma_hd
                AND YEAR(ngay_begin) = 2020
        GROUP BY ma_dv_kem
        HAVING SUM(so_luong) > 10);
        
-- 20 --
SELECT 
    ma_kh, ho_ten, ngay_sinh, cmnd, phone, email, address
FROM
    khach_hang
WHERE
    khach_hang.trang_thai = 'on' 
UNION SELECT 
    ma_nv, ho_ten, ngay_sinh, cmnd, phone, email, address
FROM
    nhanvien
WHERE
    nhanvien.trang_thai = 'on';