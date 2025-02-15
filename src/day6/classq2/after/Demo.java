package day6.classq2.after;

// Shared Printer class
class Printer {
    // Synchronized block: Only the critical section is locked
    public  void printLetter(String letter) {
        //
         //
        synchronized (this) {
            System.out.print("[");
            try {
                Thread.sleep(500); // Simulate time taken to print
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(letter + "]");
        }
            //
         //


    }
}

// Client class (Runnable for thread)
class Client extends Thread {
    private String letter;
    private Printer printer;

    public Client(String letter, Printer printer) {
        this.letter = letter;
        this.printer = printer;

    }

    @Override
    public void run() {
        printer.printLetter(letter); // Access the shared printer
    }
}

// Demo class
public class Demo {
    public static void main(String[] args) {
        Printer printer = new Printer(); // Shared Printer resource

        // Multiple clients with their private letters
        Client client1 = new Client("Letter A", printer);
        Client client2 = new Client("Letter B", printer);
        Client client3 = new Client("Letter C", printer);

        client1.start();
        client2.start();
        client3.start();
    }
}
