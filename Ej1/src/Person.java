public class Person {
    private String name;
    private float weightInKg;
    private float heightInCm;

    public Person(String name, float weightInKg, float heightInCm) {
        this.name = name;
        this.weightInKg = weightInKg;
        this.heightInCm = heightInCm;
    }

    public String getName() {
    return this.name;
    }

    public void setName(String name) {
    this.name = name;
    }
    
}


