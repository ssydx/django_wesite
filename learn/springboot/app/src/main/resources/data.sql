INSERT INTO clazz_info
(clazz_name)
VALUES("A"),("B");
INSERT INTO user_info
(user_name,user_pwd,user_register_date,user_last_login_date,user_login_count,clazz_id)
VALUES ("zhangsan","zhangsan",NOW(),NOW(),1,1),
    ("lisi","lisi",NOW(),NOW(),1,1),
    ("wangwu","wangwu",NOW(),NOW(),1,2);