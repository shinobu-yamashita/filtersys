create table menu (
  menunm varchar(10) NOT NULL
 ,menuix integer     NOT NULL
 ,menunn varchar(20) NOT NULL
 ,menumm varchar(512)
 ,active char(1)     NOT NULL
 ,PRIMARY KEY (menunm , menuix)
);


insert into menu values 
('MASTER','0','管理業務Mタイトル１','','1'),
('MASTER','1','管理業務MENU①','管理者向け業務メニュー１','1'),
('MASTER','2','管理業務MENU②','管理者向け業務メニュー２','1'),
('MASTER','3','管理業務MENU③','管理者向け業務メニュー３','1'),
('MASTER','4','管理業務MENU④','管理者向け業務メニュー４','1'),
('IPPAN','0' ,'一般業務Mタイトル１','','1'),
('IPPAN','1' ,'一般業務MENU①','一般利用者向け業務メニュー１'  ,'1'),
('IPPAN','2' ,'一般業務MENU②','一般利用者向け業務メニュー２'  ,'1'),
('IPPAN','3' ,'一般業務MENU③','一般利用者向け業務メニュー３'  ,'1'),
('IPPAN','4' ,'一般業務MENU④','一般利用者向け業務メニュー４'  ,'1'),
('IPPAN','5' ,'一般業務MENU⑤','一般利用者向け業務メニュー５'  ,'1'),
('IPPAN','6' ,'一般業務MENU⑥','一般利用者向け業務メニュー６'  ,'1'),
('IPPAN','7' ,'一般業務MENU⑦','一般利用者向け業務メニュー７'  ,'1'),
('IPPAN','8' ,'一般業務MENU⑧','一般利用者向け業務メニュー８'  ,'1'),
('IPPAN','9' ,'一般業務MENU⑨','一般利用者向け業務メニュー９'  ,'1'),
('IPPAN','10','一般業務MENU⑩','一般利用者向け業務メニュー１０','1');
