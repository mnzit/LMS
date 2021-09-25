CREATE DATABASE LMS;

USE LMS;

CREATE TABLE TBL_ADMINS
(
    id       SERIAL PRIMARY KEY,
    name     VARCHAR(100) NOT NULL,
    email    VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(120) NOT NULL
);

CREATE TABLE TBL_BOOKS
(
    id      SERIAL PRIMARY KEY,
    name    VARCHAR(100) NOT NULL,
    isbn    BIGINT(100)  NOT NULL,
    edition BIGINT(100)  NOT NULL,
    price   DECIMAL(19, 2),
    pages   BIGINT(100)
);

CREATE TABLE TBL_STUDENTS
(
    id       SERIAL PRIMARY KEY,
    name     VARCHAR(100) NOT NULL,
    course   VARCHAR(100) NOT NULL,
    branch   VARCHAR(100) NOT NULL,
    year     BIGINT(4)    NOT NULL,
    semester BIGINT(1)    NOT NULL
);

CREATE TABLE TBL_BORROW_HISTORIES
(
    id          SERIAL PRIMARY KEY,
    student_id  BIGINT UNSIGNED,
    book_id     BIGINT UNSIGNED,
    issue_date  DATETIME,
    return_date DATETIME
);

ALTER TABLE TBL_BORROW_HISTORIES
    ADD FOREIGN KEY (book_id) REFERENCES tbl_books (id);

ALTER TABLE TBL_BORROW_HISTORIES
    ADD FOREIGN KEY (student_id) REFERENCES tbl_students (id);

INSERT INTO TBL_ADMINS (name, email, password)
VALUES ("Allena Maharjan", "allenamhrzn@gmail.com", "allena123");

INSERT INTO TBL_ADMINS (name, email, password)
VALUES ("Allena Maharjan", "allenamhrzn@gmail.com", "allena123");