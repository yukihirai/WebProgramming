CREATE DATABASE User;
USE User;
CREATE TABLE UserList (id SERIAL PRIMARY KEY UNIQUE Not Null,login_id varchar(255) UNIQUE Not Null, birth_date DATE Not Null, password varchar(255) Not Null,create_date DATETIME Not Null, update_date DATETIME Not Null);
INSERT INTO UserList VALUES('1','admin','1989-05-02','5F4DCC3B5AA765D61D8327DEB882CF99',now(),now());
