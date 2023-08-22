# JavaWeb20230803
JavaWeb20230803

# 建立資料表
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
