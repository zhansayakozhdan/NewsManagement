--liquibase formatted sql
-- changeset k.zhansaya:1
CREATE TABLE TAGS_BLOGS
(
    BLOG_ID BIGSERIAL,
    TAG_ID BIGSERIAL,
    CONSTRAINT FK_BLOG FOREIGN KEY (BLOG_ID) REFERENCES BLOGS(ID),
    CONSTRAINT FK_TAG FOREIGN KEY (TAG_ID) REFERENCES TAGS(ID)
);

-- changeset k.zhansaya:2
INSERT INTO TAGS_BLOGS(BLOG_ID, TAG_ID)
VALUES (1, 3),
       (1, 4),
       (4, 2),
       (2, 1),
       (3, 3),
       (6, 3),
       (2, 3);