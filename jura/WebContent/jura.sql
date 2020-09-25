drop table Orders;
drop table order_list;
drop table shop;
drop table normal_type;
drop table jura_type;
drop table menu;
drop table customer;
drop table address;
ALTER TABLE menu MODIFY (m_img varchar2(40));
select * from menu;
update Shop set s_img='백숙' where s_id='test'
ALTER TABLE menu MODIFY(m_name varchar2(40));
ALTER TABLE shop MODIFY(s_name varchar2(40));
select * from menu where s_id='test';
select * from address;
select * from customer;
select * from menu;
desc menu;
insert into Menu values(1,'test','백숙',10000,'y','test-백숙');
insert into Menu values(2,'test','비싼백숙',50000,'n','test-비싼백숙');
insert into address values(1,'kim');
insert into address values(2,'lee');
insert into address values(3,'park');
insert into customer values('master')
create table address (
add_num NUMBER(3) PRIMARY key,
add_loc VARCHAR2(30) not null
);

create table customer(
c_id varchar2(10) primary key, 
c_pass varchar2(15) not null, 
c_name varchar2(10) not null, 
add_num number(3 )REFERENCES address (add_num),
c_address varchar2(20) not null, 
c_tel varchar2(20) not null,
del char(1) default 'n', 
joindate date default sysdate
);


create table Menu (
  m_num NUMBER(15) primary key,
  s_id VARCHAR2(10) REFERENCES Shop(s_id),
  m_name VARCHAR2(10) not null,
  m_price NUMBER(7) not null,
  rec_menu char(1) not null,
  m_img varchar2(15) not null
  );
 
insert into JURA_TYPE values('브런치');
ALTER TABLE JURA_TYPE MODIFY(j_type varchar2(20));
create table JURA_TYPE(
j_type varchar2(7) PRIMARY KEY
);
ALTER TABLE NORMAL_TYPE MODIFY(n_type varchar2(20));
insert into NORMAL_TYPE values('한식');
insert into NORMAL_TYPE values('양식');
select * from shop;
create table NORMAL_TYPE(
n_type varchar2(7) PRIMARY key
);
insert into Shop values('test','백숙',1,'이대로','010-1111-1111','백숙','브런치','한식');
insert into Shop values('test2','햄버거',1,'이대로','010-1111-1111','햄버거','브런치','양식');
insert into Shop values('test3','찌개마을',1,'이대로','010-1111-1111','찌개','브런치','한식');
ALTER TABLE shop MODIFY(n_type varchar2(20));
commit;
create table Shop(
  s_id varchar2(15) primary key,
  s_name varchar2(10) not null,
  add_num number(3) REFERENCES address (add_num),
  s_add varchar2(30) not null,
  s_tel varchar2(15) not null,
  s_img varchar2(15) not null,
  j_type varchar2(20) REFERENCES JURA_TYPE (j_type),
  n_type varchar2(20) REFERENCES  NORMAL_TYPE (n_type)
);

create table Orders(
  o_num number(4) primary key,
  c_id varchar2(10) REFERENCES customer (c_id),
  o_add varchar2(15) not null,
  o_how char(1) not null,
  o_date Date default sysdate,
  o_price NUMBER(7),
  o_sta char(1) default 'n'
);

create table order_list(
ol_num number(4) PRIMARY key,
o_num number(4) REFERENCES Orders(o_num),
s_id varchar2(15) REFERENCES Shop(s_id), 
m_num NUMBER(15) REFERENCES Menu(m_num),
olm_name VARCHAR2(10) not null,
count number(10) not null,
ol_price NUMBER(7)
 );

