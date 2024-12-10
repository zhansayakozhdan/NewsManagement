--liquibase formatted sql
-- changeset k.zhansaya:1

CREATE TABLE IF NOT EXISTS TAGS(
                                    ID BIGSERIAL PRIMARY KEY NOT NULL,
                                    NAME VARCHAR(255) NOT NULL

);

-- changeset k.zhansaya:2
INSERT INTO TAGS(NAME)
VALUES ('Sport'),
    ('Culture'),
    ('Knowledge'),
    ('IT'),
    ('International'),
    ('Entertainment'),
    ('Business')