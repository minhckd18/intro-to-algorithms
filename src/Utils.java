import java.util.Scanner;

public class Utils {

    public static int getInputInt(Scanner scanner, int a, int b) {
        while (true) {
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice >= a && choice <= b) {
                    return choice;
                }
            } else {
                scanner.next();
            }
            System.out.print("Please enter from " + a + " to " + b + ": ");
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static void exitSystem() {
        System.out.println("Goodbye!!!");
        System.exit(0);
    }
}
