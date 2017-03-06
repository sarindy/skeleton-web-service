DROP TABLE Greeting IF EXISTS;

CREATE TABLE Greeting (
	id BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1,INCREAMENT BY 1) PRIMARY KEY,
	text VARCHAR(100) NOT NULL
);
