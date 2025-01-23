package day7;

import java.io.Serializable;

public class Singleton implements Serializable, Cloneable {

    // Volatile instance for lazy initialization and thread safety
    private static volatile Singleton instance;

    // Private constructor to prevent instantiation
    private Singleton() {
        // Prevent instantiation via reflection
        if (instance != null) {
            throw new IllegalStateException("Instance already created!");
        }
    }

    // Public method to provide global access to the instance
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) { // Thread-safe block
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    // Handle Serialization issue (readResolve method)
    protected Object readResolve() {
        return getInstance();
    }

    // Handle Cloning issue (override clone)
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning is not allowed for Singleton!");
    }

    // Example business method
    public void doSomething() {
        System.out.println("Singleton is working!");
    }

    // Inner enum to demonstrate Enum Singleton
    public enum EnumSingleton {
        INSTANCE;

        public void doSomething() {
            System.out.println("Enum Singleton is working!");
        }
    }

    // Main method to demonstrate usage
    public static void main(String[] args) {
        // Test the standard Singleton
        Singleton singleton = Singleton.getInstance();
        singleton.doSomething();

        // Test the Enum Singleton
        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
        enumSingleton.doSomething();

        // Test Reflection Protection
        try {
            Class<Singleton> clazz = Singleton.class;
            var constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            Singleton reflectionInstance = constructor.newInstance();
            System.out.println("Reflection Instance: " + reflectionInstance);
        } catch (Exception e) {
            System.out.println("Reflection failed: " + e.getMessage());
        }

        // Test Cloning Protection
        try {
            Singleton cloneInstance = (Singleton) singleton.clone();
            System.out.println("Cloned Instance: " + cloneInstance);
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning failed: " + e.getMessage());
        }

        // Test Serialization Protection
        try (var fileOut = new java.io.ObjectOutputStream(new java.io.FileOutputStream("singleton.ser"))) {
            fileOut.writeObject(singleton);
        } catch (Exception e) {
            System.out.println("Serialization failed: " + e.getMessage());
        }

        try (var fileIn = new java.io.ObjectInputStream(new java.io.FileInputStream("singleton.ser"))) {
            Singleton deserializedInstance = (Singleton) fileIn.readObject();
            System.out.println("Deserialized Instance: " + deserializedInstance);
            System.out.println("Same instance? " + (singleton == deserializedInstance));
        } catch (Exception e) {
            System.out.println("Deserialization failed: " + e.getMessage());
        }
    }
}

