create table accounts (
  userid varchar(20) PRIMARY KEY
 ,passwd varchar(20) NOT NULL
 ,usernm varchar(50)
 ,userac char(1)     NOT NULL
 ,menunm varchar(10)
 ,active char(1)     NOT NULL
);


insert into accounts values 
('system','manager','管理者'    ,'1','MASTER','1'),
('user1' ,'user1'  ,'一般利用者','0','IPPAN','1');
