package database_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test1 {
    public static void main(String[] args) {
                // 数据库URL、用户名和密码
        String jdbcUrl = "jdbc:mysql://localhost:3306/javadb";
        String username = "ssydx";
        String password = "";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            // 加载MySQL JDBC驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 建立与数据库的连接
            connection = DriverManager.getConnection(jdbcUrl, username, password);

            // 创建Statement对象
            statement = connection.createStatement();

            // 执行查询
            String sql = "SELECT id, name FROM tb1";
            resultSet = statement.executeQuery(sql);
            // 处理结果集
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try { if (resultSet != null) resultSet.close(); } catch (Exception e) { /* 忽略 */ }
            try { if (statement != null) statement.close(); } catch (Exception e) { /* 忽略 */ }
            try { if (connection != null) connection.close(); } catch (Exception e) { /* 忽略 */ }
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            preparedStatement = connection.prepareStatement("SELECT * FROM tb1 WHERE id = ?");
            for (int i = 1; i < 4; i++) {
                preparedStatement.setInt(1, i);
                resultSet = preparedStatement.executeQuery();
                System.out.println(resultSet.getRow());
                while (resultSet.next()) {
                    System.out.println(
                        resultSet.getInt(1) + " " +
                        resultSet.getString("name") + " " +
                        resultSet.getInt(3)
                    );
                }
            }
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM tb1 WHERE name = 'ls'");
            System.out.println(resultSet.getFetchDirection());
            System.out.println(resultSet.getFetchSize());
            System.out.println(resultSet.getType());
            while (resultSet.next()) {
                resultSet.updateInt("age", 20);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (resultSet != null) resultSet.close(); } catch (Exception e) { /* 忽略 */ }
            try { if (statement != null) statement.close(); } catch (Exception e) { /* 忽略 */ }
            try { if (preparedStatement != null) preparedStatement.close(); } catch (Exception e) { /* 忽略 */ }
            try { if (connection != null) connection.close(); } catch (Exception e) { /* 忽略 */ }
        }
    }
}
