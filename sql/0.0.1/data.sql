/* user_data*/

INSERT INTO user (active,email,last_name,name,password) VALUES (0,'kasia@gmail.com','Jurczak','Kasia','hasloKasi');
INSERT INTO user (active,email,last_name,name,password) VALUES (1,'iguanaiza@gmail.com','Iguana','Iza','hasloIzy');
INSERT INTO user (active,email,last_name,name,password) VALUES (1,'benek@gmail.com','Benek','Benek','hasloBenka');


/*expense_data*/

INSERT INTO expense(wydatek, kategoria, cena, status) 
VALUES ('Paliwo', 'Samochód', 49.98, 'WYKONANY');

INSERT INTO expense(wydatek, kategoria, cena, status) 
VALUES ('Biurko', 'Mieszkanie', 320.00, 'WYKONANY');

INSERT INTO expense(wydatek, kategoria, cena, status) 
VALUES ('Trociny', 'Zwierzatko', 4.60, 'ZAPLANOWANY');

INSERT INTO expense(wydatek, kategoria, cena, status) 
VALUES ('Nakladka na toalete', 'Dziecko', 19.99, 'WYKONANY');


/*profit_data*/

INSERT INTO profit(nazwa, kwota)
VALUES ('Prezent od mamy', '200.00');

INSERT INTO profit(nazwa, kwota)
VALUES ('Wyplata', '1500.00');


INSERT INTO profit(nazwa, kwota)
VALUES ('Wplata za sprzedaz auta', '4500.00');


/*role_data*/

INSERT INTO role (role) VALUES ('Admin');


/*user-role-data*/

INSERT INTO user_role (id_user, id_role) VALUES ((SELECT id FROM user WHERE name = 'Benek'), (SELECT id FROM role WHERE role = 'Admin'));