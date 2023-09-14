# JavaWeb20230803
JavaWeb20230803

# 建立 users 資料表
<pre>
create table if not exists users (
    id int not null auto_increment,
    username varchar(50) not null unique,
    password varchar(255),
    birth date,
    primary key (id)
);
</pre>

# 建立資料列
<pre>
insert into users(username, password, birth) values('john', '1234', '1954-12-8');
insert into users(username, password, birth) values('mary', '5678', '1973-12-18');
insert into users(username, password, birth) values('jack', '1111', '1982-10-10');
insert into users(username, password, birth) values('rose', '2222', '1990-8-8');
insert into users(username, password, birth) values('anna', '3333', '2002-5-3');
</pre>

# 資料查詢
select * from users;

# 建立 exams 資料表
<pre>
create table if not exists exams (
    id int not null auto_increment,
    username varchar(50) not null unique,
    password varchar(50),
    exam_no varchar(50) not null,
    exam_fee int not null,
    paid boolean default false,
    exam_date date not null,
    exam_period_1 boolean default false,
    exam_period_2 boolean default false,
    exam_period_3 boolean default false,
    memo varchar(1000),
    primary key (id)
);
</pre>

# 建立資料列
<pre>
insert into exams(username, password, exam_no, exam_fee, paid, exam_date, 
		  exam_period_1, exam_period_2, exam_period_3, memo) 
	   values('john', '1234', '1z0-819', 8000, true, '2023-08-24',
		  true, false, true, 'Test');


# 資料查詢
select * from exams;

# sales_data 資料表加入 id 欄位
ALTER TABLE sales_data
ADD id INT NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST;
</pre>

# 購物車系統
<pre>	
-- 刪除舊有資料表
drop table if exists orders;
drop table if exists products;

-- 新增資料表
create table if not exists products(
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_code VARCHAR(255) NOT NULL,
    product_name VARCHAR(255) NOT NULL,
    product_qty INT NOT NULL,
    product_price INT
);
	
CREATE TABLE orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT NOT NULL,
    FOREIGN KEY (product_id) REFERENCES Products(id),
    user_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(id),
    order_qty INT NOT NULL,
    order_status INT default 0 NOT NULL,
    order_ts timestamp default current_timestamp
);

-- 新增預設資料
insert into products(product_code, product_name, product_qty, product_price) values ('P01', '宮保雞丁', 10, 200);
insert into products(product_code, product_name, product_qty, product_price) values ('P02', '番茄炒蛋', 20, 100);
insert into products(product_code, product_name, product_qty, product_price) values ('P03', '麻油腰子', 30, 150);

insert into orders(product_id, user_id, order_qty, order_status) values(1, 1, 1, 1);
insert into orders(product_id, user_id, order_qty, order_status) values(2, 2, 2, 1);
insert into orders(product_id, user_id, order_qty, order_status) values(1, 3, 3, 0);

</pre>
