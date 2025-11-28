package org.example;

import org.example.Employee;
import org.example.Visitor;
import org.example.Ride;

public class AssignmentTwo {
    public static void main(String[] args) {

        
        Employee employee = new Employee("Jane Smith", 25, "456 Oak Ave", "E12345", "Ride Operator", 50000.0);
        System.out.println(employee);
        
        Visitor visitor = new Visitor("Bob Johnson", 20, "789 Pine Rd", "V98765", true, "Gold");
        System.out.println(visitor);
        
        Ride ride = new Ride("Roller Coaster", 24, employee);
        System.out.println(ride);
    }
    
    public void partThree() {
        // Create a new Ride object
        Employee operator = new Employee("John Operator", 30, "123 Work St", "E001", "Ride Operator", 45000.0);
        Ride ride = new Ride("Ferris Wheel", 10, operator);
        
        // Add a minimum of 5 Visitors to the Queue
        Visitor visitor1 = new Visitor("Alice", 25, "100 Park Ave", "V001", false, "Standard");
        Visitor visitor2 = new Visitor("Bob", 30, "200 Park Ave", "V002", true, "Gold");
        Visitor visitor3 = new Visitor("Charlie", 22, "300 Park Ave", "V003", false, "Silver");
        Visitor visitor4 = new Visitor("Diana", 28, "400 Park Ave", "V004", true, "Platinum");
        Visitor visitor5 = new Visitor("Eve", 35, "500 Park Ave", "V005", false, "Standard");
        
        System.out.println("\n--- Adding 5 visitors to the queue ---");
        ride.addVisitorToQueue(visitor1);
        ride.addVisitorToQueue(visitor2);
        ride.addVisitorToQueue(visitor3);
        ride.addVisitorToQueue(visitor4);
        ride.addVisitorToQueue(visitor5);
        
        // Print all Visitors in the Queue
        System.out.println("\n--- Printing queue after adding 5 visitors ---");
        ride.printQueue();
        
        // Remove a Visitor from the Queue
        System.out.println("\n--- Removing a visitor from the queue ---");
        ride.removeVisitorFromQueue(visitor3); // Remove Charlie
        
        // Print all Visitors in the Queue
        System.out.println("\n--- Printing queue after removing a visitor ---");
        ride.printQueue();
    }
    
    public void partFourA() {
        // Create a new Ride object
        Employee operator = new Employee("Jane Operator", 28, "456 Work Ave", "E002", "Ride Operator", 48000.0);
        Ride ride = new Ride("Carousel", 15, operator);
        
        // Add a minimum of 5 Visitors to the collection
        Visitor visitor1 = new Visitor("Alice", 25, "100 Park Ave", "V001", false, "Standard");
        Visitor visitor2 = new Visitor("Bob", 30, "200 Park Ave", "V002", true, "Gold");
        Visitor visitor3 = new Visitor("Charlie", 22, "300 Park Ave", "V003", false, "Silver");
        Visitor visitor4 = new Visitor("Diana", 28, "400 Park Ave", "V004", true, "Platinum");
        Visitor visitor5 = new Visitor("Eve", 35, "500 Park Ave", "V005", false, "Standard");
        
        System.out.println("\n--- Adding 5 visitors to the ride history ---");
        ride.addVisitorToHistory(visitor1);
        ride.addVisitorToHistory(visitor2);
        ride.addVisitorToHistory(visitor3);
        ride.addVisitorToHistory(visitor4);
        ride.addVisitorToHistory(visitor5);
        
        // Check if a Visitor is in the collection
        System.out.println("\n--- Checking if a visitor is in the history ---");
        ride.checkVisitorFromHistory(visitor3); // Check Charlie
        ride.checkVisitorFromHistory(new Visitor("Frank", 40, "600 Park Ave", "V006", false, "Standard")); // Check Frank (not in history)
        
        // Print the number of Visitors in the collection
        System.out.println("\n--- Printing the number of visitors in history ---");
        ride.numberOfVisitors();
        
        // Print all Visitors in the collection
        System.out.println("\n--- Printing all visitors in history ---");
        ride.printRideHistory();
    }
    
    public void partFourB() {}
    
    public void partFive() {}
    
    public void partSix() {}
    
    public void partSeven() {}
}