CREATE SCHEMA IF NOT EXISTS `user_app` DEFAULT CHARACTER SET utf8;
USE `user_app`;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS user_roles;

CREATE TABLE users (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

INSERT INTO users (id, email, password)
VALUES (1, 'danadiadius@gmail.com', 'Q4570810');

CREATE TABLE roles (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    role_name ENUM('ADMIN', 'USER') NOT NULL
);

INSERT INTO roles (id, role_name)
VALUES (1, 'ADMIN');

CREATE TABLE users_roles (
    user_id BIGINT UNSIGNED NOT NULL,
    role_id BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (role_id) REFERENCES roles(id)
);

INSERT INTO users_roles (user_id, role_id)
VALUES (1, 1);
