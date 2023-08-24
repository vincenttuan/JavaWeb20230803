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
</pre>

# 資料查詢
select * from exams;


