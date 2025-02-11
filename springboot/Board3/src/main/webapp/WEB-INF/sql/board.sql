-- oarcle 계정 생성 
spring / 1234

CMD > sqlplus /nolog
SQL> conn /as sysdba

SQL> ALTER SESSION SET "_ORACLE_SCRIPT"=true;
세션이 변경되었습니다.

SQL> CREATE USER SPRING IDENTIFIED BY 1234;
사용자가 생성되었습니다.

SQL> GRANT CONNECT, RESOURCE TO SPRING;
권한이 부여되었습니다.

SQL> ALTER USER SPRING DEFAULT TABLESPACE
  2     USERS QUOTA UNLIMITED ON USERS;
사용자가 변경되었습니다.

sqldeveloper spring/1234 로 로그인
-- table 생성
CREATE   TABLE   BOARD
(
      BNO       NUMBER(8)       PRIMARY KEY
    , TITLE     VARCHAR2(240)   NOT NULL
    , CONTENT   VARCHAR2(4000)
    , WRITER    VARCHAR2(12)
    , REGDATE   DATE            DEFAULT SYSDATE 
    , HIT       NUMBER(9)       DEFAULT 0 
)

CREATE  SEQUENCE SEQ_BNO;

INSERT INTO BOARD (BNO, TITLE, CONTENT, WRITER )
 VALUES ( SEQ_BNO.NEXTVAL, '새글',     '방가',   '아이유' );
INSERT INTO BOARD (BNO, TITLE, CONTENT, WRITER )
 VALUES ( SEQ_BNO.NEXTVAL, '두번째글', '잘부탁', '레이' ); 
 
COMMIT; 

SELECT * FROM BOARD
 ORDER BY BNO DESC;









