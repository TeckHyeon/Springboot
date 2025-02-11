CREATE TABLE MEMBER 
(
  NUM NUMBER(8) NOT NULL 
, NAME VARCHAR2(30) NOT NULL 
, TEL VARCHAR2(20) 
, EMAIL VARCHAR2(320) NOT NULL 
, ADDRESS VARCHAR2(320) NOT NULL 
, BIRTH DATE 
, POINT NUMBER(8) DEFAULT 1000 
,CONSTRAINT EMAIL UNIQUE(EMAIL)
, CONSTRAINT MEMBER_PK PRIMARY KEY 
  (
    NUM 
  )
  ENABLE 
);
