---- �ø��� (olympic) ���̺�
DROP TABLE olympic cascade constraint;
--
---- �޴� (medal)
DROP TABLE medal cascade constraint;
--
---- ����(sport)
DROP TABLE sport cascade constraint;
--
---- ���� (player)
DROP TABLE player cascade constraint;
--
DROP SEQUENCE olympic_id_seq;

--������ Ư�� ������ ȹ���� �޴�.  (���� ����) A������ �� �� �� �޴�     �޼ҵ�(������ ȹ���� �޴� ��)  ���� ȹ���� �޴� ��?
--1 �ѱ� ��� A���� 5
--3 �ѱ� ��� C���� 4
--2 �ѱ� ��� B���� 0

CREATE TABLE olympic (
	 olympic_id       NUMBER(5) PRIMARY KEY,
       country          	VARCHAR2(20)  NOT NULL,
       sportName               	VARCHAR2(20) NOT NULL,
       playerNum         	NUMBER(20) NOT NULL,
	   medal_id				VARCHAR2(20)  NOT NULL
);

CREATE TABLE medal (
		medal_id		VARCHAR2(20) PRIMARY KEY,
		country         VARCHAR2(20)  NOT NULL,
		sportname         VARCHAR2(20)  NOT NULL,
       GMedal          	NUMBER(20) NOT NULL,
       SMedal           NUMBER(20) NOT NULL,
       BMedal          	NUMBER(20) NOT NULL
);

CREATE TABLE sport (
       sportname	VARCHAR2(20) PRIMARY KEY,
       country	VARCHAR2(20)  NOT NULL,
       totalmedal	NUMBER(5) NOT NULL
);


CREATE TABLE player (
       playerNum          	NUMBER(20) PRIMARY KEY,
       name      VARCHAR2(20) NOT NULL,
       age  	NUMBER(20) NOT NULL,
	   country  	VARCHAR2(20) NOT NULL,
	   sportname  	VARCHAR2(20) NOT NULL
);

CREATE SEQUENCE olympic_id_seq;


ALTER TABLE olympic  ADD FOREIGN KEY (sportName) REFERENCES sport  (sportname);
ALTER TABLE olympic ADD FOREIGN KEY (playerNum)  REFERENCES player  (playerNum);
ALTER TABLE olympic ADD FOREIGN KEY (medal_id) REFERENCES medal  (medal_id);