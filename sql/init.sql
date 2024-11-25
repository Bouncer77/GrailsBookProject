-- auto-generated definition
create user book_ta;

ALTER USER book_ta WITH PASSWORD 'new_password';


CREATE TABLE books
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    author      VARCHAR(255) NOT NULL,
    year        INT          NOT NULL CHECK (year >= 1000),
    description TEXT
);