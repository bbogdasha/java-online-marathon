import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        writeFile("data1.txt", "Example of text for test case #1");
    }

    public static void writeFile(String filename, String text) {
        byte[] bytes = text.getBytes();
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%7s", Integer.toBinaryString(b)));
        }
        String str = sb.toString().replace(" ", "0");
        try (FileOutputStream writer = new FileOutputStream(filename)) {
            writer.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
