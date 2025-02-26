package spring.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class App {
    @Bean
    public HelloWorld HelloWorld() {
        return new HelloWorld();
    }
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        HelloWorld hw = context.getBean(HelloWorld.class);
        hw.setName("ssydx");
        hw.print();
    }
}
