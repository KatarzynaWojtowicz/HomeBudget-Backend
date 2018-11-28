/* user_data*/
INSERT INTO user (active,name,last_name,login,password,email) VALUES (0,'Kasia','Jurczak','Kasia1','hasloKasi','kasia@gmail.com');
INSERT INTO user (active,name,last_name,login,password,email) VALUES (1,'Iguana','Iza','Iza1','hasloIzy','iguanaiza@gmail.com');
INSERT INTO user (active,name,last_name,login,password,email) VALUES (1,'Benek','Benek','Benek1','hasloBenka','benek@gmail.com');


/*expense_data*/

INSERT INTO expense(wydatek, kategoria, cena, status, data_wydatku, id_user) 
VALUES ('Paliwo', 'Samochod', 300.98, 'WYKONANY', '2018-10-10', (SELECT id FROM user WHERE login = 'Benek1'));

INSERT INTO expense(wydatek, kategoria, cena, status, data_wydatku, id_user) 
VALUES ('Rachunki', 'Dom', 620.00, 'WYKONANY', '2018-10-10', (SELECT id FROM user WHERE login = 'Benek1'));

INSERT INTO expense(wydatek, kategoria, cena, status, data_wydatku, id_user) 
VALUES ('Kredyt', 'Dom', 1200.00, 'WYKONANY', '2018-10-10', (SELECT id FROM user WHERE login = 'Benek1'));

INSERT INTO expense(wydatek, kategoria, cena, status, data_wydatku, id_user) 
VALUES ('Zakupy', 'Dom', 1000.00, 'WYKONANY', '2018-10-10', (SELECT id FROM user WHERE login = 'Benek1'));  


INSERT INTO expense(wydatek, kategoria, cena, status, data_wydatku, id_user) 
VALUES ('Telefon', 'Telefon', 30.00, 'ZAPLANOWANY', '2018-11-24', (SELECT id FROM user WHERE login = 'Benek1'));

INSERT INTO expense(wydatek, kategoria, cena, status, data_wydatku, id_user ) 
VALUES ('Przedszkole', 'Dziecko', 750.00, 'WYKONANY', '2018-01-15', (SELECT id FROM user WHERE login = 'Benek1'));

INSERT INTO expense(wydatek, kategoria, cena, status, data_wydatku, id_user) 
VALUES ('Mleko', 'Dziecko', 19.99, 'WYKONANY', '2018-01-15', (SELECT id FROM user WHERE login = 'Iza1'));

INSERT INTO expense(wydatek, kategoria, cena, status, data_wydatku, id_user) 
VALUES ('Pampersy', 'Dziecko', 100.99, 'WYKONANY', '2018-02-24', (SELECT id FROM user WHERE login = 'Iza1'));

INSERT INTO expense(wydatek, kategoria, cena, status, data_wydatku, id_user) 
VALUES ('Kozaki', 'Ubrania', 119.99, 'WYKONANY', '2018-02-24', (SELECT id FROM user WHERE login = 'Iza1'));

INSERT INTO expense(wydatek, kategoria, cena, status, data_wydatku, id_user) 
VALUES ('Spodnie', 'Ubrania', 50.00, 'WYKONANY', '2018-03-01', (SELECT id FROM user WHERE login = 'Iza1'));

INSERT INTO expense(wydatek, kategoria, cena, status, data_wydatku, id_user) 
VALUES ('Opony', 'Samochód', 500.99, 'WYKONANY', '2018-04-06', (SELECT id FROM user WHERE login = 'Kasia1'));

INSERT INTO expense(wydatek, kategoria, cena, status, data_wydatku, id_user) 
VALUES ('Oczyszczacz powietrza', 'Dom', 600.99, 'WYKONANY', '2018-12-10', (SELECT id FROM user WHERE login = 'Kasia1'));

INSERT INTO expense(wydatek, kategoria, cena, status, data_wydatku, id_user) 
VALUES ('Lampa', 'Dom', 150.00, 'WYKONANY', '2018-06-05', (SELECT id FROM user WHERE login = 'Kasia1'));

INSERT INTO expense(wydatek, kategoria, cena, status, data_wydatku, id_user) 
VALUES ('Bielizna', 'Ubrania', 119.99, 'WYKONANY', '2018-06-09', (SELECT id FROM user WHERE login = 'Kasia1'));


/*profit_data*/

INSERT INTO profit(nazwa, kwota, data_przychodu, id_user)
VALUES ('Prezent od mamy', '200.00', '2018-10-12',(SELECT id FROM user WHERE login = 'Benek1'));

INSERT INTO profit(nazwa, kwota, data_przychodu, id_user)
VALUES ('Wyplata', '6500.00', '2018-12-12',(SELECT id FROM user WHERE login = 'Benek1'));


INSERT INTO profit(nazwa, kwota, data_przychodu, id_user)
VALUES ('Premia', '100.00', '2018-09-02',(SELECT id FROM user WHERE login = 'Benek1'));

INSERT INTO profit(nazwa, kwota, data_przychodu, id_user)
VALUES ('Prezent od taty', '200.00', '2018-01-19',(SELECT id FROM user WHERE login = 'Benek1'));

INSERT INTO profit(nazwa, kwota, data_przychodu, id_user)
VALUES ('Nagroda pracownika roku', '10000.00', '2018-08-20',(SELECT id FROM user WHERE login = 'Iza1'));

INSERT INTO profit(nazwa, kwota, data_przychodu, id_user)
VALUES ('Wyplata', '5500.00', '2018-09-30',(SELECT id FROM user WHERE login = 'Iza1'));

INSERT INTO profit(nazwa, kwota, data_przychodu, id_user)
VALUES ('Prezent od mamy', '500.00', '2018-10-20',(SELECT id FROM user WHERE login = 'Iza1'));

INSERT INTO profit(nazwa, kwota, data_przychodu, id_user)
VALUES ('Prezent od taty', '500.00', '2018-02-10',(SELECT id FROM user WHERE login = 'Iza1'));

INSERT INTO profit(nazwa, kwota, data_przychodu, id_user)
VALUES ('Sprzedaz niepotrezbnych ubran', '100.00', '2018-03-11',(SELECT id FROM user WHERE login = 'Iza1'));

INSERT INTO profit(nazwa, kwota, data_przychodu, id_user)
VALUES ('Sprzedaz niepotrezbnych zabawek', '120.00', '2018-03-23',(SELECT id FROM user WHERE login = 'Kasia1'));

INSERT INTO profit(nazwa, kwota, data_przychodu, id_user)
VALUES ('Nagroda pracownika roku', '100.00', '018-03-28',(SELECT id FROM user WHERE login = 'Kasia1'));

INSERT INTO profit(nazwa, kwota, data_przychodu, id_user)
VALUES ('Prezent od mamy', '50.00', '2018-04-18',(SELECT id FROM user WHERE login = 'Kasia1'));

INSERT INTO profit(nazwa, kwota, data_przychodu, id_user)
VALUES ('Prezent od taty', '100.00', '2018-11-10',(SELECT id FROM user WHERE login = 'Kasia1'));

INSERT INTO profit(nazwa, kwota, data_przychodu, id_user)
VALUES ('Wyplata', '2100.00', '2018-11-28',(SELECT id FROM user WHERE login = 'Kasia1'));


/*user-role-data*/

INSERT INTO user_role (id_user, id_role) VALUES ((SELECT id FROM user WHERE login = 'Benek1'), (SELECT id FROM role WHERE role = 'ADMIN'));
INSERT INTO user_role (id_user, id_role) VALUES ((SELECT id FROM user WHERE login = 'Iza1'), (SELECT id FROM role WHERE role = 'USER'));
INSERT INTO user_role (id_user, id_role) VALUES ((SELECT id FROM user WHERE login = 'Kasia1'), (SELECT id FROM role WHERE role = 'USER'));