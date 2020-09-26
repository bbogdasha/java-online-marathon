public class Plant {
    private String name;
    private Color color;
    private Type type;

    public Plant(String type, String color, String name) throws TypeException, ColorException {
        try {
            this.type = Type.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            tryCreatePlant(type, color, name);
        }
        try {
            this.color = Color.valueOf(color.toUpperCase());
        } catch (IllegalArgumentException e) {
            tryCreatePlant(type, color, name);
        }
        this.name = name;
    }

    static Plant tryCreatePlant(String type, String color, String name) throws ColorException, TypeException {
        try {
            new Plant(type, color, name);
        } catch (TypeException e) {
            type = "Ordinary";
        } catch (ColorException e) {
            color = "Red";
        }
        try {
            new Plant(type, color, name);
        } catch (TypeException | ColorException e) {
            type = "Ordinary";
            color = "Red";
        }
        return new Plant(type, color, name);
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "{type: " + type + ", color: " + color + ", name: " + name + "}";
    }
}