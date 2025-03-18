DROP TABLE IF EXISTS user_info;
DROP TABLE IF EXISTS clazz_info;
DROP TABLE IF EXISTS product_info;
CREATE TABLE clazz_info
(
    clazz_id INT PRIMARY KEY AUTO_INCREMENT,
    clazz_name VARCHAR(20) NOT NULL
);
CREATE TABLE user_info
(
    user_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(20) NOT NULL UNIQUE,
    user_pwd VARCHAR(20) NOT NULL,
    user_register_date DATETIME,
    user_last_login_date DATETIME,
    user_login_count INT,
    clazz_id INT,
    FOREIGN KEY(clazz_id) REFERENCES clazz_info(clazz_id)
);
CREATE TABLE product_info
(
    product_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(50) NOT NULL UNIQUE,
    product_desc VARCHAR(255)
)
