Servlet 과 JSP를 연동하는 방명록 프로그램
==================================

MVC Model2 아키텍처에 대하여 배우기 전에, Servlet의 장점 (Java코드를 입력하기 쉽다.), JSP의 장점 HTML코드를 입력하기 쉽다 라는 장점을 융합한 예제이다.

프레임워크를 배우기 전에 forward, redirect 에 대한 개념을 학습할 목적으로 만들어졌다.


Servlet , JSP, DAO 로 구성된 간단한 웹 어플리케이션이다.

관리자는 암호 1234를 입력하여 로그인 한다.

해당 예제를 실행하기 위하여는 127.0.0.1 (로컬컴퓨터)에 mysql 데이터 베이스가 설치되어 있어야 한다.

context root 는 / 로 설정한 후 실행한다.

------------------------------------------------------------


mysql download 및 설치 

http://dev.mysql.com/downloads/mysql/ 

32bit or 64bit 설치 

mysql-installer-community-5.6.21.1.msi 를 다운로드 (64bit 기준) 

설치. root아이디와 암호를 설정한다. 

추가 사용자로 본인은 urstory 암호는 mysql을 추가하였다. %에서 접근가능 (어디에서도) 

-------------------------------------------------------------- 

설치후 아래와 같이 사용자, db를 만들고 권한 부여. 암호를 설정한다. 

mysql -uurstory -p암호 mysql [enter] 

guestbook사용자 생성 
guestbook 데이터베이스 생성 
localhost, 127.0.0.1, %(모든) 에서 접속하는 uestbook 사용자에게 guestbook디비의 모든 권한(guestbook.*)을 부여. 
guestbook사용자에게 암호 설정. 암호는 guestbook 
모든 내용을 적용 

create user guestbook; 
create database guestbook; 

grant all privileges on guestbook.* to 'guestbook'@'%'; 

set password for 'guestbook'@'%' = password('guestbook'); 

flush privileges; 

-----------------------------------------------------


다음과 같은 SQL을 사용하는 방명록 Application을 만든다. 관리자 암호는 1234이다. servlet 클래스에 하드코딩 되어 있다.

CREATE TABLE guestbook( 
id int(11) unsigned NOT NULL auto_increment, 
name varchar(20) NULL, 
content text, 
create_date datetime NULL, 
ip varchar(16) NULL, 
PRIMARY KEY (id) 
); 


insert into guestbook (name, content, create_date, ip) 
values ('kim', 'hello', now(), '127.0.0.1'); 

select id, name, content, create_date, ip from guestbook 
order by id desc; 

delete from guestbook where id = 1; 
