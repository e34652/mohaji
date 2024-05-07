CREATE DATABASE mohaji;
CREATE USER 'mohaji'@'localhost' IDENTIFIED BY 'mysql';
GRANT ALL PRIVILEGES ON mohaji.* TO 'mohaji'@'localhost';
FLUSH PRIVILEGES;