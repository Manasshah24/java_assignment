package spring.spring_project1;

import org.springframework.stereotype.Component;

@Component // Marks this class as a Spring-managed bean
public class Engine {
    public void start() {
        System.out.println("Engine started...");
    }
}
