CREATE TABLE Student (
	ID VARCHAR(100) NOT NULL,
	NAME VARCHAR(100),
	AGE VARCHAR(100),
	SEX VARCHAR(100),
	MOBILE INT,
	PRIMARY KEY (ID)
);

-- 注意设置 utf-8 的支持，否则不能存储中文
-- utf8
-- utf8_general_ci