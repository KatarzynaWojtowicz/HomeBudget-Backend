CREATE SCHEMA homebudget;

CREATE TABLE expense(
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	wydatek varchar(256),
    kategoria varchar(256),
    cena float(9,2),
    status varchar(32)
);

CREATE TABLE profit (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nazwa VARCHAR(256) NOT NULL,
  kwota FLOAT(9,2) NOT NULL
 );

 
    
 CREATE TABLE user (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  active boolean NOT NULL,
  email VARCHAR(256) NOT NULL,
  last_name VARCHAR(256) NOT NULL,
  name VARCHAR(256) NOT NULL,
  password VARCHAR(64) NOT NULL
  
  );
  
  
  CREATE TABLE role (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  role VARCHAR(45) NOT NULL
);

		
CREATE TABLE user_role (
  id_user INT NOT NULL PRIMARY KEY,
  id_role INT NOT NULL,
 FOREIGN KEY (id_user) REFERENCES user(id),
 FOREIGN KEY (id_role) REFERENCES role(id)
 );

 
