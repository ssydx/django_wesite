DROP TABLE IF EXISTS miaosha_order;
DROP TABLE IF EXISTS order_info;
DROP TABLE IF EXISTS miaosha_item;
DROP TABLE IF EXISTS item_info;
DROP TABLE IF EXISTS user_info;
-- 秒杀用户表
CREATE TABLE user_info
(
    user_id BIGINT PRIMARY KEY COMMENT '手机号码作为用户ID',
    nickname VARCHAR(255) NOT NULL,
    password VARCHAR(32) COMMENT '保存加盐后的密码，MD5(密码，salt)',
    salt VARCHAR(128),
    head VARCHAR(128) COMMENT '头像地址',
    register_date DATETIME COMMENT '注册时间',
    last_login_date DATETIME COMMENT '上次登录时间',
    login_count INT COMMENT '登录次数'
) COMMENT='秒杀用户表';
-- 商品表

CREATE TABLE item_info
(
    item_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '商品ID',
    item_name VARCHAR(255) COMMENT '商品名称',
    title VARCHAR(64) COMMENT '商品标题',
    item_img VARCHAR(64) COMMENT '商品图片',
    item_detail LONGTEXT COMMENT '商品详情',
    item_price DECIMAL(10,2) COMMENT '商品单价',
    stock_num INT COMMENT '商品库存，-1表示无限制'
) COMMENT='商品表';
-- 秒杀商品表

CREATE TABLE miaosha_item
(
    miaosha_item_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '秒杀的商品表',
    item_id BIGINT COMMENT '商品ID',
    miaosha_price DECIMAL(10,2) COMMENT '秒杀价格',
    stock_count INT COMMENT '库存数量',
    start_date DATETIME COMMENT '秒杀开始时间',
    end_date DATETIME COMMENT '秒杀结束时间',
    FOREIGN KEY(item_id) REFERENCES item_info(item_id)
) COMMENT='秒杀商品表';
-- 订单表

CREATE TABLE order_info
(
    order_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT COMMENT '用户ID',
    item_id BIGINT COMMENT '商品ID',
    item_name VARCHAR(255) COMMENT '冗余的商品名称列，避免多表连接',
    order_num INT COMMENT '购买数量',
    order_price DECIMAL(10,2) COMMENT '购买价格',
    order_channel TINYINT COMMENT '购买渠道：1 PC，2 Android，3 IOS',
    order_status TINYINT COMMENT '订单状态：0 新建未支付，1 已支付，3 已发货，4 已退款，5 已完成',
    create_date DATETIME COMMENT '订单的创建时间',
    pay_date DATETIME COMMENT '支付时间',
    FOREIGN KEY(user_id) REFERENCES user_info(user_id),
    FOREIGN KEY(item_id) REFERENCES item_info(item_id)
) COMMENT='订单表';
-- 秒杀订单表

CREATE TABLE miaosha_order
(
    miaosha_order_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT COMMENT '用户ID',
    order_id BIGINT COMMENT '订单ID',
    item_id BIGINT COMMENT '商品ID',
    UNIQUE KEY(user_id,item_id),
    FOREIGN KEY(user_id) REFERENCES user_info(user_id),
    FOREIGN KEY(order_id) REFERENCES order_info(order_id),
    FOREIGN KEY(item_id) REFERENCES item_info(item_id)
) COMMENT='秒杀订单表';