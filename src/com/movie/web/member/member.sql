SELECT * FROM Member;

DROP TABLE Member CASCADE CONSTRAINT;

CREATE TABLE Member(
	id VARCHAR2(30) PRIMARY KEY,
	name VARCHAR2(30) NOT NULL,
	password VARCHAR2(30) NOT NULL,
	addr VARCHAR2(100),
	birth NUMBER
);
INSERT INTO Member(id,name,password,addr,birth)
VALUES ('hong','홍길동','1','서울',800101);
INSERT INTO Member(id,name,password,addr,birth)
VALUES ('kim','김유신','1','경기',900203);
INSERT INTO Member(id,name,password,addr,birth)
VALUES ('lee','이순신','1','부산',000909);
INSERT INTO Member(id,name,password,addr,birth)
VALUES ('song','송준기','1','대전',041001);
INSERT INTO Member
VALUES ('yoon','윤손하','1','인천',060201);
INSERT INTO Member(id,name,password,addr,birth)
VALUES ('kim2','김유신','1','LA',850501);
INSERT INTO Member(id,name,password,addr,birth)
VALUES ('you','유아인','1','강릉',861020);

SELECT * FROM Member;

SELECT * FROM Member
WHERE id = 'kim';

SELECT * FROM Member
WHERE id = 'kim' and password = '1';

INSERT INTO Member(id,name,password,addr,birth)
VALUES ('choi','최지우','1','강릉',831125);

delete from MEMBER where id = 'kim'



select* from MEMBER where id = "choi";

update member
set password = '2', addr = '도쿄'
where id = "choi"

delete from MEMBER where id = 'choi';