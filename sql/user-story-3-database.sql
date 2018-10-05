
ALTER TABLE users AUTO_INCREMENT = 1;

CREATE TABLE users (
    user_id INTEGER NOT NULL,
    fname VARCHAR(30),
    lname VARCHAR(50) NOT NULL,
    phone INTEGER(10),
    email VARCHAR(50),
    CONSTRAINT user_pk PRIMARY KEY (user_id)
);

INSERT INTO users
VALUES ('1', 'Martin', 'Liljenstrøm', '90219341', 'marliljen@hotmail.com');
INSERT INTO users
VALUES ('2', 'Jan', 'Heldal', '12345678', 'jan@hotmail.com');
INSERT INTO users
VALUES ('3', 'Erik', 'Eriksen', '87654321', 'erik@hotmail.com');
INSERT INTO users
VALUES ('45', 'Tom', 'Johnsen', '9166611', 'tom@hotmail.com');