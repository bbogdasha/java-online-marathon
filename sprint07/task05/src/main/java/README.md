# Task05

Let the key of Map is project name and value contains list of participants.

Create a Stream<String> nameList(Map<String, Stream<String>> map) method of the MyUtils class to build sorted stream of all participants without duplication.


Please ignore null or empty strings, extra spaces and case sensitivity.

Throw NullPointerException if map is null.


For example, for a given map:

{"Desktop"=[" iVan", "PeTro ", " Ira "], "Web"=["STepan", "ira ", " Andriy ", "an na"], "Spring"=["Ivan", "Anna"]}

you should get:

["Andriy", "Anna", "Ira", "Ivan", "Petro ", "Stepan"]

---

### Better solution

```java
    public Stream<String> nameList(Map<String, Stream<String>> map) {
        if (map == null) throw new NullPointerException("Invalid parameters");
        return map.values().stream()
                .flatMap(s -> s)
                .filter(s -> (s != null) && (!s.isEmpty()))
                .map(s -> s.trim().replace(" ", "").toLowerCase())
                .filter(s -> !s.isEmpty())
                .map(s -> s.replaceFirst(String.valueOf(s.charAt(0)), String.valueOf(s.charAt(0)).toUpperCase()))
                .distinct()
                .sorted();
    }
```
