DROP TABLE TB_MEMBER;

--��ȣ, �̸�, ����, ����, �ּ�, ����, ��ȭ��ȣ, �̸���
CREATE TABLE TB_MEMBER(
NO NUMBER PRIMARY KEY,
NAME VARCHAR2(100) NOT NULL,
AGE NUMBER NOT NULL,
GENDER VARCHAR2(2) CHECK(GENDER IN('M','F')) NOT NULL,
LOCATION VARCHAR2(500),
JOB VARCHAR2(300),
TEL VARCHAR2(20),
EMAIL VARCHAR2(100)
);

INSERT INTO TB_MEMBER
VALUES(1, '����', 100, 'M', '����� ������','������', '010-1234-5678', 'TEACHER@TEACHER.COM');

SELECT NO, NAME, AGE, GENDER, LOCATION, JOB, TEL, EMAIL
FROM TB_MEMBER;