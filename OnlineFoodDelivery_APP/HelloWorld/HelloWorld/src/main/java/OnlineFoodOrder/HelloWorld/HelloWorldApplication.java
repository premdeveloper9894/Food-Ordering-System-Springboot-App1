package OnlineFoodOrder.HelloWorld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;

@EnableJms

@SpringBootApplication

@ComponentScan(basePackages = "OnlineFoodOrder")

@EnableJpaRepositories(basePackages = "OnlineFoodOrder.HelloWorldRepository")

@EntityScan(basePackages = "OnlineFoodOrder.HelloWorldEntity")

public class HelloWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class, args);
    }
}