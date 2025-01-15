package day3;

interface manas {
    static void getarea() {
        System.out.println("hi");
    }
}

class a implements manas {
    public void display() {
        System.out.println("hello");
    }
}

class Main {
    public static void main(String[] args) {
        manas.getarea();

        a obj = new a();
        obj.display();
    }
}
