CREATE TABLE students (
    student_id    BIGINT PRIMARY KEY,
    major      VARCHAR(64) NOT NULL,
    name      VARCHAR(64) NOT NULL,
    age       INTEGER     NOT NULL
);

CREATE SEQUENCE student_id_sequence
AS BIGINT
INCREMENT BY 50
START WITH 1
OWNED BY students.student_id;
