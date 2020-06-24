-- Customer Table

DROP TABLE CUSTOMER IF EXISTS;

CREATE TABLE CUSTOMER (
	id INT PRIMARY KEY AUTO_INCREMENT,
	FIRST_NAME VARCHAR(50) NOT NULL,
	MIDDLE_NAME VARCHAR(50) NOT NULL,
	LAST_NAME VARCHAR(50) NOT NULL,
	CITY VARCHAR(50) NOT NULL,
	RANK INT NOT NULL
);