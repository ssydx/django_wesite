// package com.ssydx.elasticsearch;

// import java.io.File;

// import org.springframework.context.ApplicationContext;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// public class ESConfig {
//     static {
//         String storePath = new File(ApplicationContext.class.getResource("/").getFile()).getParentFile().getAbsolutePath() + "\\classes\\elastic.store";
//         System.setProperty("javax.net.ssl.trustStore", storePath);
//         System.setProperty("javax.net.ssl.trustStorePassword", "111111");
//     }
// }
