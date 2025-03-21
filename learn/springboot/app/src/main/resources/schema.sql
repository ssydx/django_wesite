DROP TABLE IF EXISTS miaoshaorder_info;
DROP TABLE IF EXISTS order_info;
DROP TABLE IF EXISTS user_info;
DROP TABLE IF EXISTS clazz_info;
DROP TABLE IF EXISTS miaoshaproduct_info;
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
    product_desc VARCHAR(255),
    product_detail TEXT,
    product_price DOUBLE,
    product_stocknum INTEGER
);
CREATE TABLE miaoshaproduct_info
(
    miaoshaproduct_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    product_id BIGINT,
    miaoshaproduct_price DOUBLE,
    miaoshaproduct_stocknum INTEGER,
    start_date DATETIME,
    end_date DATETIME,
    FOREIGN KEY(product_id) REFERENCES product_info(product_id)
);

CREATE TABLE order_info
(
  order_id bigint primary key auto_increment,
  user_id bigint comment '用户ID',
  product_id bigint comment '商品ID',
  product_name varchar(255) comment '冗余的商品名称，用于避免多表连接',
  order_num int comment '购买的商品数量',
  order_price decimal(10,2) comment '购买价格',
  order_channel tinyint comment '渠道：1、PC, 2、Android, 3、iOS',
  order_status tinyint comment '订单状态,0新建未支付, 1已支付,2已发货, 3已收货, 4已退款,5已完成',
  create_date datetime comment '订单的创建时间',
  pay_date datetime comment '支付时间',
  foreign key(user_id) references user_info(user_id),
  foreign key(product_id) references product_info(product_id)
);

create table miaoshaorder_info
(
  miaoshaorder_id bigint primary key auto_increment,
  user_id bigint comment '用户ID',
  order_id bigint comment '订单ID',
  product_id bigint comment '商品ID',
  unique key(user_id, product_id),
  foreign key(user_id) references user_info(user_id),
  foreign key(order_id) references order_info(order_id),
  foreign key(product_id) references product_info(product_id)
);
