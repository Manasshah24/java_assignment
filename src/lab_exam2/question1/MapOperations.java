package lab_exam2.question1;


import java.util.*;
import java.util.stream.*;

class Student {
    private int id;
    private String name;
    private int marks;

    // Constructors
    public Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

 /*   // Override equals and hashCode
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return id == student.id &&
                marks == student.marks &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, marks);
    }
*/
    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', marks=" + marks + '}';
    }
}

public class MapOperations {
    public static void main(String[] args) {
        // Part 1: Map with String keys
        Map<String, Integer> map = new HashMap<>();
        map.put("raj", 95);
        map.put("ekta", 75);
        map.put("rajiv", 85);
        map.put("sunita", 66);
        map.put("gunika", 99);

        System.out.println("------Printing Map------");
        map.entrySet().stream()
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));

        System.out.println("\n------Records with 'raj' in Key------");
        map.entrySet().stream()
                .filter(entry -> entry.getKey().contains("raj"))
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));

        System.out.println("\n------Map Sorted by Key------");
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));

        System.out.println("\n------Map Sorted by Values------");
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));

        System.out.println("\n------Map Reverse Sorted by Key------");
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByKey().reversed())
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));

        // Part 2: Map with Student keys
        Map<Student, Integer> studentMap = new HashMap<>();
        studentMap.put(new Student(109, "raj", 95), 95);
        studentMap.put(new Student(61, "keta", 78), 78);
        studentMap.put(new Student(11, "gunika", 98), 98);
        studentMap.put(new Student(19, "keshav", 97), 97);

        System.out.println("\n------Records Sorted by Student Name------");
        studentMap.entrySet().stream()
                .sorted((e1, e2) -> e1.getKey().getName().compareTo(e2.getKey().getName()))
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));

        System.out.println("\n------Records Sorted by Student ID------");
        studentMap.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e1.getKey().getId(), e2.getKey().getId()))
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
    }
}
