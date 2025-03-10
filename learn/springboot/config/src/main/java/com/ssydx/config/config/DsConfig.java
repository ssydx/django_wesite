// package com.ssydx.config.config;

// import javax.sql.DataSource;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.jdbc.datasource.DriverManagerDataSource;

// @Configuration
// public class DsConfig {
//     @Bean
//     public DataSource dataSource() {
//         DriverManagerDataSource dataSource = new DriverManagerDataSource();
//         dataSource.setUrl("jdbc:mysql://localhost:3306/javadb");
//         dataSource.setUsername("ssydx");
//         dataSource.setPassword("");
//         return dataSource;
//     }
//     @Bean
//     public JdbcTemplate jdbcTemplate(DataSource dataSource) {
//         return new JdbcTemplate(dataSource);
//     }
// }
