INSERT INTO department (title, address) VALUES ('Лукоил', 'Москва, ул. Ленина 55');
INSERT INTO department (title, address) VALUES ('Газпром', 'Санкт-Петербург, Никольского 2');

INSERT INTO person (name, email, department_id) VALUES ('Alex', 'alex@gmail.com', (SELECT id FROM department WHERE title LIKE 'Лукоил'));
INSERT INTO person (name, email, department_id) VALUES ('Bob', 'bob@gmail.com', (SELECT id FROM department WHERE title LIKE 'Лукоил'));
INSERT INTO person (name, email, department_id) VALUES ('Helen', 'helen@gmail.com', (SELECT id FROM department WHERE title LIKE 'Газпром'));

INSERT INTO phone (number, person_id) VALUES ('+74951741992', (SELECT id FROM person WHERE name LIKE 'Alex'));
INSERT INTO phone (number, person_id) VALUES ('+74950383594', (SELECT id FROM person WHERE name LIKE 'Alex'));
INSERT INTO phone (number, person_id) VALUES ('+74958105679', (SELECT id FROM person WHERE name LIKE 'Alex'));
INSERT INTO phone (number, person_id) VALUES ('+74951894886', (SELECT id FROM person WHERE name LIKE 'Bob'));
INSERT INTO phone (number, person_id) VALUES ('+74955015935', (SELECT id FROM person WHERE name LIKE 'Bob'));
INSERT INTO phone (number, person_id) VALUES ('+74957332277', (SELECT id FROM person WHERE name LIKE 'Bob'));
INSERT INTO phone (number, person_id) VALUES ('+74959875664', (SELECT id FROM person WHERE name LIKE 'Bob'));
INSERT INTO phone (number, person_id) VALUES ('+74955323282', (SELECT id FROM person WHERE name LIKE 'Helen'));
INSERT INTO phone (number, person_id) VALUES ('+74958438889', (SELECT id FROM person WHERE name LIKE 'Helen'));