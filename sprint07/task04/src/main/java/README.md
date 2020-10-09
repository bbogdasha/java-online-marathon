# Task04

Create the method readFile(String filename) that read from file a sequence of bytes in binary format from previous task and return ridable string.

For example, the sequence of 7-bit bytes:

*1000101111100011000011101101111000011*

should be represented as text fragment:

*Hello!*

---

### Better solution

```java
    public static String readFile(String filename) {
        StringBuilder sb = new StringBuilder();
        char[] symbols;
        try (FileReader fileReader = new FileReader(filename)){
            symbols = new char[7];
            int offset = 0;
            while (fileReader.read(symbols, offset, 7) != -1) {
                sb.append((char) Integer.parseInt(String.valueOf(symbols), 2));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
```
