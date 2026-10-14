import java.util.Scanner;

/**
 * RecursiveProduct.java
 * Divine Chamoh
 * Reads five numbers from the user and displays their product,
 * which is calculated with a recursive method.
 */
public class RecursiveProduct {

    private static final int COUNT = 5;

    /**
     * Returns the product of all numbers in the array.
     * Public entry point that hides the recursion index from the caller.
     */
    public static double product(double[] numbers) {
        return product(numbers, 0);
    }

    /**
     * Recursive method: the product of the numbers from index onward is
     * the number at index times the product of the rest.
     * Base case: past the last number, the product is 1 (the identity).
     */
    private static double product(double[] numbers, int index) {
        if (index == numbers.length) {
            return 1.0;
        }
        return numbers[index] * product(numbers, index + 1);
    }

    /** Prompts for COUNT numbers, asking again until each entry is valid. */
    private static double[] readNumbers(Scanner input) {
        double[] numbers = new double[COUNT];
        for (int i = 0; i < COUNT; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            while (!input.hasNextDouble()) {
                System.out.print("Invalid input. Enter a number: ");
                input.next();
            }
            numbers[i] = input.nextDouble();
        }
        return numbers;
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            double[] numbers = readNumbers(input);
            System.out.printf("The product of the five numbers is: %.2f%n", product(numbers));
        }
    }
}
