package spring.spring_project1;

import org.springframework.stereotype.Component;

@Component // Marks this class as a Spring-managed bean
public class Car {
    private Engine engine;

    // Constructor-based Dependency Injection
    public Car(Engine engine) {
        this.engine = engine;
    }

    public void drive() {
        System.out.println("Car is driving...");
        engine.start(); // Call the start method of Engine
    }
}
