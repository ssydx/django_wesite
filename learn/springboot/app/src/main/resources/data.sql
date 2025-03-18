INSERT INTO clazz_info
(clazz_name)
VALUES("A"),("B");
INSERT INTO user_info
(user_name,user_pwd,user_register_date,user_last_login_date,user_login_count,clazz_id)
VALUES ("zhangsan","zhangsan",NOW(),NOW(),1,1),
    ("lisi","lisi",NOW(),NOW(),1,1),
    ("wangwu","wangwu",NOW(),NOW(),1,2);
INSERT INTO product_info
(product_name,product_desc)
VALUES ("Spring Data JPA","简化了基于Java Persistence API (JPA)的应用程序的开发。它允许开发者通过定义接口继承Spring Data Repository接口来快速创建数据访问层，而不需要手动编写实现代码。"),
("Spring Data JDBC","提供了一种更直接的方式来使用JDBC进行数据库交互，相比JPA，它提供了更为简单的抽象层，适合那些不需要或不想使用完整ORM功能的场景。"),
("Spring Data MongoDB","用于MongoDB文档数据库的集成，支持使用MongoTemplate以及遵循Spring Data通用repository风格的接口来操作MongoDB。"),
("Spring Data Redis","为Redis键值存储提供了一个抽象层，使得在Spring应用中使用Redis变得更加容易，支持诸如字符串、哈希、列表、集合和有序集等数据结构的操作。");