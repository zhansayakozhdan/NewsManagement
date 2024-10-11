--liquibase formatted sql
-- changeset k.zhansaya:1
CREATE TABLE IF NOT EXISTS AUTHORS
(
    ID BIGSERIAL PRIMARY KEY NOT NULL,
    FULL_NAME VARCHAR(255) NOT NULL
);

INSERT INTO AUTHORS(FULL_NAME)
VALUES ('Kozhdan Zhansaya'),
       ('Kozhdan Madina'),
       ('Kozhdan Kamilya'),
       ('Duisemuratova Aigul');