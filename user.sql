CREATE DATABASE userinfo;
USE userinfo;
CREATE TABLE user
(
    id          INT     NOT NULL    PRIMARY KEY   AUTO_INCREMENT,
    name        CHAR(30)    NULL,
    password    CHAR(30)    NULL
);