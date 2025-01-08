package day1.q3;

import java.util.Arrays;

class Arrayop {
    public static int[] copy(int[] array) {
        return Arrays.copyOf(array, 3);
    }
}

public class copyof {
    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 67};
        int copy[] = Arrayop.copy(arr);

        // Print the copied array
        System.out.println("Original Array: " + Arrays.toString(arr));
        System.out.println("Copied Array: " + Arrays.toString(copy));
    }
}