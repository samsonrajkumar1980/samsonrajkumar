package java;

public class constructorOverloading {
    private String name;
    private int age;
    
    // Default constructor
    public constructorOverloading() {
        this.name = "Unknown";
        this.age = 0;
    }
    
    // Constructor with one parameter
    public constructorOverloading(String name) {
        this.name = name;
        this.age = 0;
    }
    
    // Constructor with two parameters
    public constructorOverloading(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Method to display person details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
    
    public static void main(String[] args) {
        constructorOverloading person1 = new constructorOverloading();
        constructorOverloading person2 = new constructorOverloading("Alice");
        constructorOverloading person3 = new constructorOverloading("Bob", 25);
        
        person1.displayDetails();
        person2.displayDetails();
        person3.displayDetails();
    }
}
