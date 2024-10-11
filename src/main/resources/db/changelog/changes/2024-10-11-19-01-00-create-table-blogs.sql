--liquibase formatted sql
-- changeset k.zhansaya:1

CREATE TABLE IF NOT EXISTS BLOGS(
    ID BIGSERIAL PRIMARY KEY NOT NULL,
    TITLE VARCHAR(255) NOT NULL,
    CONTENT TEXT,
    CREATED_AT TIMESTAMP,
    UPDATED_AT TIMESTAMP,
    AUTHOR_ID BIGSERIAL NOT NULL,
    CONSTRAINT FK_AUTHOR FOREIGN KEY (AUTHOR_ID) REFERENCES AUTHORS(ID)
);

-- changeset k.zhansaya:2
INSERT INTO BLOGS(TITLE, CONTENT, AUTHOR_ID)
VALUES ('IITU University', 'IT Университет', 1),
       ('Трассу Астана - Кокшетау закрыли из-за погодных условий', 'В Акмолинской области перекрыли трассу республиканского значения из-за погодных условий, передает Tengri Auto.', 4),
       ('Даты осенних каникул у школьников Казахстана: календарь', 'Первая четверть длится восемь учебных недель. ', 3),
       ('Казахстанцы “порвали“ всех на чемпионате мира по карате: как это было', 'Сборная Казахстана стала победителем чемпионата мира по карате "КиокушинРю" в Тянцзине (Китай) среди детей, юниоров и ветеранов.', 2)