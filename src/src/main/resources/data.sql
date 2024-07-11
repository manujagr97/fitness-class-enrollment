-- Create tables
CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS roles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

-- Insert data into tables
INSERT INTO users (username, password) VALUES ('user1', 'password1'), ('user2', 'password2');
INSERT INTO roles (name) VALUES ('ROLE_USER'), ('ROLE_ADMIN');
