import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static int[] array;
    public static void main(String[] args) {
        // Program starts
        while (true) {
            displayMenu();
            int inputInt = Utils.getInputInt(scanner, 0, 7);
            switch (inputInt) {
                case 0:
                    Utils.exitSystem();
                case 1:
                    manualInput();
                    break;
                case 2:
                    array = readFile();
                    break;
                case 3:
                    bubbleSort(array);
                    break;
                case 4:
                    selectionSort(array);
                    break;
                case 5:
                    insertSort(array);
                    break;
                case 6:
                    linearSearch(array);
                    break;
                case 7:
                    binarySearch(array);
                    break;
                default:
                    System.out.println("Something went wrong.");
                    System.out.print("Enter 1 to return to Menu: ");
                    Utils.getInputInt(scanner, 1, 1);
            }
        }
    }

    private static void displayMenu() {
        System.out.println("+------------------------------+");
        System.out.println("| 1. Manual Input              |");
        System.out.println("| 2. File Input                |");
        System.out.println("| 3. Bubble sort               |");
        System.out.println("| 4. Selection sort            |");
        System.out.println("| 5. Insertion sort            |");
        System.out.println("| 6. Search > value            |");
        System.out.println("| 7. Search = value            |");
        System.out.println("| 0. Exit                      |");
        System.out.println("+------------------------------+");
        System.out.print("Enter your choice: ");
    }

    // Function 1: write to file
    public static void manualInput() {
        System.out.print("Please enter input number of elements: ");
        int n = scanner.nextInt();
        System.out.println("Please enter input elements: ");
        int[] inputArray = new int[n];
        for (int i = 0; i < n; i++) {
            inputArray[i] = scanner.nextInt();
        }

        try {
            TextFileService.writeFile(inputArray, "INPUT.txt", false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print("Enter 1 to return to Menu: ");
        Utils.getInputInt(scanner, 1, 1);
    }

    // Function 2: Read from file
    public static int[] readFile() {
        System.out.println("PLease enter the file path: ");
        String filePath = scanner.next();

        int[] readData;
        try {
            readData = TextFileService.readFile(filePath);
            System.out.print("Input array: ");
            for (int num : readData) {
                System.out.print(num + " ");
            }
            System.out.println();

            System.out.print("Enter 1 to return to Menu: ");
            Utils.getInputInt(scanner, 1, 1);

            return readData;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Something went wrong");
        System.out.print("Enter 1 to return to Menu: ");
        Utils.getInputInt(scanner, 1, 1);
        return null;
    }

    // Function 3: Bubble Sort
    public static void bubbleSort(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            System.out.println("Array is empty, return to Menu");
            return;
        }

        int[] intArray = Arrays.copyOf(inputArray, inputArray.length);

        Utils.printArray(intArray);
        boolean isDone = false;
        while (!isDone) {
            isDone = true;
            for (int i = 0; i < intArray.length - 1; i++) {
                if (intArray[i] > intArray[i + 1]) {
                    Utils.swap(intArray, i, i + 1);
                    Utils.printArray(intArray);

                    isDone = false;
                }
            }
        }
        try {
            TextFileService.writeFile(intArray, "OUTPUT1.txt", false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print("Enter 1 to return to Menu: ");
        Utils.getInputInt(scanner, 1, 1);
    }

    // Function 4: Selection Sort
    public static void selectionSort(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            System.out.println("Array is empty, return to Menu");
            return;
        }

        int[] intArray = Arrays.copyOf(inputArray, inputArray.length);

        Utils.printArray(intArray);
        int left = 0, right = intArray.length - 1;
        while (left < right) {
            int min = intArray[left];
            int minIndex = left;

            for (int i = left; i <= right; i++) {
                if (intArray[i] <= min) {
                    min = intArray[i];
                    minIndex = i;
                }
            }

            Utils.swap(intArray, left, minIndex);
            Utils.printArray(intArray);
            left++;
        }

        try {
            TextFileService.writeFile(intArray, "OUTPUT2.txt", false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print("Enter 1 to return to Menu: ");
        Utils.getInputInt(scanner, 1, 1);
    }

    // Function 5: Insert Sort
    public static void insertSort(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            System.out.println("Array is empty, return to Menu");
            return;
        }

        int[] array = Arrays.copyOf(inputArray, inputArray.length);

        Utils.printArray(array);
        for (int i = 1; i < array.length; i++) {
            int valueToInsert = array[i];
            int position = i;

            while (array[position - 1] > valueToInsert) {
                array[position] = array[position - 1];
                position = position - 1;
                if (position == 0) break;
            }

            array[position] = valueToInsert;
            Utils.printArray(array);
        }

        try {
            TextFileService.writeFile(array, "OUTPUT3.txt", false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print("Enter 1 to return to Menu: ");
        Utils.getInputInt(scanner, 1, 1);
    }

    // Function 6: Linear Search
    public static void linearSearch(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            System.out.println("Array is empty, return to Menu");
            return;
        }

        System.out.print("PLease enter searched input value: ");
        int value = scanner.nextInt();
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] > value) {
                indices.add(i);
            }
        }

        System.out.print("Positions that values are larger: ");
        for (Integer index : indices) {
            System.out.print(index + " ");
        }

        int[] array = indices
                .stream()
                .mapToInt(i -> i)
                .toArray();
        try {
            TextFileService.writeFile(array, "OUTPUT4.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.print("Enter 1 to return to Menu: ");
        Utils.getInputInt(scanner, 1, 1);
    }

    // Function 7: Linear Search
    public static void binarySearch(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            System.out.println("Array is empty, return to Menu");
            return;
        }

        int[] array = Arrays.copyOf(inputArray, inputArray.length);
        Arrays.sort(array);
        System.out.print("PLease enter searched input value: ");
        int value = scanner.nextInt();

        int left = 0, right = array.length - 1;
        int mid = (left + right) / 2;
        while (true) {
            if (left > right) {
                System.out.println("Found nothing");
                break;
            }

            if (array[mid] == value) {
                System.out.println("The right position: " + mid);
                break;
            }

            if (array[mid] < value) {
                left = mid + 1;
                mid = (left + right) / 2;
            } else if (array[mid] > value) {
                right = mid - 1;
                mid = (left + right) / 2;
            }
        }

        System.out.print("Enter 1 to return to Menu: ");
        Utils.getInputInt(scanner, 1, 1);
    }
}
