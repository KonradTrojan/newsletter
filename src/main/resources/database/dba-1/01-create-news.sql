--liquibase formatted sql
--changeset ktrojan:1
CREATE TABLE NEWS (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  title VARCHAR(400) NOT NULL,
  content VARCHAR(2000) NULL,
  created timestamp
);
