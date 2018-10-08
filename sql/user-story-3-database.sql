
ALTER TABLE users AUTO_INCREMENT = 1;
SET GLOBAL time_zone = '+8:00';

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
VALUES ('4', 'tom', 'Tom Johnsen', '+119166611', 'tom@hotmail.com');

create table progress (
    prog_ID int,
    prog_total int,
    prog_finished int,
    user_id int not null,
    primary key (prog_id),
    foreign key (user_id) references users(user_id)
);

INSERT INTO progress
VALUES ('1', '10', '3', '1');
INSERT INTO progress
VALUES ('2', '10', '4', '2');
INSERT INTO progress
VALUES ('3', '10', '5', '3');
INSERT INTO progress
VALUES ('4', '10', '6', '4');

select progress.prog_total, progress.prog_finished
from progress
where user_id = 2;

