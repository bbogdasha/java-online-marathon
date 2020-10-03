import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        System.out.println(readFile("data1.txt"));
    }

    public static String readFile(String filename) {

        StringBuilder binaryString = new StringBuilder();

        try (FileReader fr = new FileReader(filename)) {
            int singleCharInt;
            char singleChar;
            while((singleCharInt = fr.read()) != -1) {
                singleChar = (char) singleCharInt;
                binaryString.append(singleChar);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] binarySymbols = binaryString.toString().split("(?<=\\G.{7})");
        StringBuilder word = new StringBuilder();
        for (String s : binarySymbols) {
            word.append((char) Integer.parseInt(s, 2));
        }
        return word.toString();
    }
}
