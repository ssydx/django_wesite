// package com.ssydx.test5.config;

// import java.time.Duration;

// import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
// import org.springframework.boot.web.server.ErrorPage;
// import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
// import org.springframework.boot.web.servlet.server.Session;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpStatus;
// // 创建ServletWebServerFactory
// @Configuration
// public class WebServer2 {
//     @Bean
//     public ConfigurableServletWebServerFactory webServerFactory() {
//         TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
//         factory.setPort(8090);
//         Session session = new Session();
//         session.setTimeout(Duration.ofMinutes(10));
//         factory.setSession(session);
//         factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/test.html"));
//         return factory;
//     }
// }
