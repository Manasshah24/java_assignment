package spring.spring_project1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // Tells Spring this is a configuration class
@ComponentScan("com.example") // Scans for @Component classes in this package
public class AppConfig {

    // Define a custom Car bean and inject the Engine dependency manually
    @Bean
    public Car car(Engine engine) {
        return new Car(engine);
    }
}
