import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        writeFile("data1.txt", "Example of text for test case #1");
    }

    public static void writeFile(String filename, String text) {

        StringBuilder toBytes = new StringBuilder();
        StringBuilder temp;

        for(int i = 0; i < text.length(); i++) {
            temp = new StringBuilder(Integer.toBinaryString(text.charAt(i)));
            for(int j = temp.length(); j < 7; j++) {
                temp.insert(0, "0");
            }
            toBytes.append(temp);
        }

        try (FileWriter fw = new FileWriter(filename)) {
            fw.write(String.valueOf(toBytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
