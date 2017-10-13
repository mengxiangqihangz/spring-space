
drop table p_user;   
--������      
create table p_user(
id int not null,
name varchar2(30) not null,
password varchar2(20),
age int,
primary key (id)
);  
--��������      
create sequence seq start with 1 increment by 1;    

--����������      
create or replace trigger book_trigger       
before insert on p_user       
for each row       
begin       
select seq.nextval into :new.id from dual;      
end ;    
  
commit;

--�������      
insert into p_user(name,password,age) values ('����','abc',2);

select * from p_user;
