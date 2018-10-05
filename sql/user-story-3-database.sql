
ALTER TABLE users AUTO_INCREMENT = 1;

CREATE TABLE users (
    user_id INTEGER NOT NULL,
    password CHAR(20),
    name VARCHAR(30),
    phone VARCHAR(20),
    email VARCHAR(50),
    CONSTRAINT user_pk PRIMARY KEY (user_id)
);

INSERT INTO users
VALUES ('1', 'martin', 'Martin Liljenstrøm', '+4790219341', 'marliljen@hotmail.com');
INSERT INTO users
VALUES ('2', 'jan', 'Jan Heldal', '12345678', 'jan@hotmail.com');
INSERT INTO users
VALUES ('3', 'erik', 'Erik Erikson', '+4687654321', 'erik@hotmail.com');
INSERT INTO users
VALUES ('45', 'tom', 'Tom Johnsen', '+119166611', 'tom@hotmail.com');