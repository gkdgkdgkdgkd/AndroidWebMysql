CREATE DATABASE userinfo;
USE userinfo;
CREATE TABLE user
(
    id          INT     NOT NULL    PRIMARY KEY   AUTO_INCREMENT,
    name        VARCHAR(30)    NULL,
    password    VARCHAR(30)    NULL
);
