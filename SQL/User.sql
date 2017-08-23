CREATE DATABASE User;
USE User;
CREATE TABLE User (id SERIAL PRIMARY KEY UNIQUE Not Null,login_id varchar(255) UNIQUE Not Null, birth_date DATE Not Null, password varchar(255) Not Null,create_date DATETIME Not Null, update_date DATETIME Not Null);
INSERT INTO User VALUES('1','admin','1989-05-02','password',now(),now());
