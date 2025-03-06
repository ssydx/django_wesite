// package com.ssydx.test5.config;

// import org.springframework.boot.web.server.Compression;
// import org.springframework.boot.web.server.WebServerFactoryCustomizer;
// import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
// import org.springframework.stereotype.Component;
// import org.springframework.util.unit.DataSize;
// // 修改ServletWebServerFactory
// @Component
// public class WebServer implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {
//     @Override
//     public void customize(ConfigurableServletWebServerFactory server) {
//         server.setPort(8090);
//         server.setContextPath("/test");
//         Compression compression = new Compression();
//         compression.setMinResponseSize(DataSize.ofBytes(2048));
//         compression.setMimeTypes(new String[]{"text/plain","text/html"});
//         server.setCompression(compression);
//     }
// }
