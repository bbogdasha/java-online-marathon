class Child extends Person {

    String childIDNumber;

    public Child(int age, String healthInfo, String name, String childIDNumber) {
        super(age, healthInfo, name);
        this.childIDNumber = childIDNumber;
    }

    String getHealthStatus() {
        return name +" " + healthInfo;
    }
}
