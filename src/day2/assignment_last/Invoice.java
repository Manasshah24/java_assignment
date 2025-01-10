package day2.assignment_last;

class Invoice implements Payable {
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerPart;

    // Constructor to initialize all fields
    public Invoice(String partNumber, String partDescription, int quantity, double pricePerPart) {
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        this.quantity = quantity;
        this.pricePerPart = pricePerPart;
    }

    // Overriding the getPayment method from Payable interface
    @Override
    public void getPayment() {
        double totalPrice = quantity * pricePerPart;
        System.out.println("Invoice Details:");
        System.out.println("Part Number: " + partNumber);
        System.out.println("Part Description: " + partDescription);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price Per Part: " + pricePerPart);
        System.out.println("Total Price: " + totalPrice);
    }
}
