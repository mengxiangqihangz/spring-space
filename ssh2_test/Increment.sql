
drop table p_user;   
--创建表      
create table p_user(
id int not null,
name varchar2(30) not null,
password varchar2(20),
age int,
primary key (id)
);  
--创建序列      
create sequence seq start with 1 increment by 1;    

--创建触发器      
create or replace trigger book_trigger       
before insert on p_user       
for each row       
begin       
select seq.nextval into :new.id from dual;      
end ;    
  
commit;

--添加数据      
insert into p_user(name,password,age) values ('李四','abc',2);

select * from p_user;
