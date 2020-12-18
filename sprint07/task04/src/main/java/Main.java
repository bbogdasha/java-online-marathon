import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        System.out.println(readFile("data1.txt"));
    }

    public static String readFile(String filename) {
        StringBuilder sb = new StringBuilder();
        char[] symbols;
        try (FileReader fileReader = new FileReader(filename)) {
            symbols = new char[7];
            while (fileReader.read(symbols, 0, 7) != -1) {
                sb.append((char) Integer.parseInt(String.valueOf(symbols), 2));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
