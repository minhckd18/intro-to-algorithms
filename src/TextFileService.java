import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextFileService {
    public static int[] readFile(String fileName) throws FileNotFoundException {
        List<Integer> data;
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)))) {
            data = new ArrayList<>();
            while (scanner.hasNextLine() && scanner.hasNextInt()) {
                int num = scanner.nextInt();
                scanner.skip(" ");
                data.add(num);
            }
        }
        return data
                .stream()
                .mapToInt(i -> i)
                .toArray();
    }

    public static void writeFile(int[] array, String fileName, boolean isAppend) throws IOException {
        try (BufferedWriter file = new BufferedWriter(new FileWriter(fileName, isAppend))) {
            for (int i = 0; i < array.length; i++) {
                file.write(array[i] + " ");
            }
            file.write("\n");
        }
    }
}
