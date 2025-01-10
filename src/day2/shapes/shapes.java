package day2.shapes;

import java.util.ArrayList;

// Interface for shapes
public interface shapes {
    int getarea(); // Abstract method to calculate area
}

// Rectangle class implementing shapes
class rectangle implements shapes {
    private int l;
    private int b;

    public rectangle(int l, int b) {
        this.l = l;
        this.b = b;
    }

    @Override
    public int getarea() {
        return l * b;
    }
}

// Circle class implementing shapes
class circle implements shapes {
    private int r;

    public circle(int r) {
        this.r = r;
    }

    @Override
    public int getarea() {
        return (int) (3.14 * r * r);
    }
}

// Triangle class implementing shapes
class triangle implements shapes {
    private int b;
    private int h;

    public triangle(int b, int h) {
        this.b = b;
        this.h = h;
    }

    @Override
    public int getarea() {
        return b * h / 2;
    }
}

// ArrayList to hold shapes
class array {
    private ArrayList<shapes> shapes; // List to store shapes

    public array() {
        shapes = new ArrayList<>();
    }

    // Method to add shapes to the list
    public void addshape(shapes s) {
        shapes.add(s);
    }

    // Method to display areas of all shapes
    public void displayAreas() {
        for (shapes s : shapes) {
            System.out.println("Area: " + s.getarea());
        }
    }
}

// Main class to test functionality
class Main {
    public static void main(String[] args) {
        array a = new array();

        // Adding shapes to the array
        a.addshape(new rectangle(10, 20));
        a.addshape(new circle(10));
        a.addshape(new triangle(10, 20));

        // Displaying the areas of all shapes
        a.displayAreas();
    }
}
