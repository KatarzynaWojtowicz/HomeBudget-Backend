CREATE SCHEMA homebudget;

CREATE TABLE expense(
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	wydatek varchar(256),
    kategoria varchar(256),
    cena float(9,2),
    status varchar(32)
    );
    
    
    
		