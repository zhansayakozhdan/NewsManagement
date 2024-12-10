--liquibase formatted sql
-- changeset k.zhansaya:1

CREATE TABLE IF NOT EXISTS COMMENTS(
                                    ID BIGSERIAL PRIMARY KEY NOT NULL,
                                    CONTENT TEXT NOT NULL,
                                    CREATED_AT TIMESTAMP,
                                    UPDATED_AT TIMESTAMP,
                                    BLOG_ID BIGSERIAL NOT NULL,
                                    CONSTRAINT FK_BLOG FOREIGN KEY (BLOG_ID) REFERENCES BLOGS(ID)
);

-- changeset k.zhansaya:2
INSERT INTO COMMENTS(CONTENT, BLOG_ID)
VALUES ('Good University', 1),
       ('Oh, nooo', 2),
       ('Wow', 3),
       ('I study at this university', 1)