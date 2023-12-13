--liquibase formatted sql
--changeset ktrojan:2

CREATE TABLE COMMENT (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     news_id BIGINT NOT NULL,
     content VARCHAR(2000) NULL,
     created timestamp
);
ALTER TABLE COMMENT
    ADD CONSTRAINT comment_news_id
        FOREIGN KEY (news_id) REFERENCES news(id)