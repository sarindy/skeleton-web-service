DROP TABLE IF EXISTS Greeting;

CREATE TABLE Greeting (
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  text VARCHAR(45) NOT NULL,
  PRIMARY KEY (id));