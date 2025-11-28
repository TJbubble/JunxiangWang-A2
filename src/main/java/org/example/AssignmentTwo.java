package org.example;

public class AssignmentTwo {
    public static void main(String[] args) {

        // Create instances of each class to demonstrate functionality
        // Person person = new Person("John Doe", 30, "123 Main St"); // Cannot instantiate abstract class
        // System.out.println(person);
        
        Employee employee = new Employee("Jane Smith", 25, "456 Oak Ave", "E12345", "Ride Operator", 50000.0);
        System.out.println(employee);
        
        Visitor visitor = new Visitor("Bob Johnson", 20, "789 Pine Rd", "V98765", true, "Gold");
        System.out.println(visitor);
        
        Ride ride = new Ride("Roller Coaster", 24, employee);
        System.out.println(ride);
    }
    
    public void partThree() {}
    
    public void partFourA() {}
    
    public void partFourB() {}
    
    public void partFive() {}
    
    public void partSix() {}
    
    public void partSeven() {}
}