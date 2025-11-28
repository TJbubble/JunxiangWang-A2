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
        
        Ride ride = new Ride("Roller Coaster", 24, employee, 5); // Added maxRider parameter
        System.out.println(ride);
    }
    
    public void partThree() {
        // Create a new Ride object
        Employee operator = new Employee("John Operator", 30, "123 Work St", "E001", "Ride Operator", 45000.0);
        Ride ride = new Ride("Ferris Wheel", 10, operator, 3); // Added maxRider parameter
        
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
        Ride ride = new Ride("Carousel", 15, operator, 4); // Added maxRider parameter
        
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
    
    public void partFourB() {
        // Create a new Ride object
        Employee operator = new Employee("Sam Operator", 32, "789 Work Blvd", "E003", "Senior Ride Operator", 52000.0);
        Ride ride = new Ride("Bumper Cars", 20, operator, 6); // Added maxRider parameter
        
        // Add a minimum of 5 Visitors to the collection in a specific order
        Visitor visitor1 = new Visitor("Charlie", 22, "300 Park Ave", "V003", false, "Silver");
        Visitor visitor2 = new Visitor("Alice", 25, "100 Park Ave", "V001", false, "Standard");
        Visitor visitor3 = new Visitor("Eve", 35, "500 Park Ave", "V005", false, "Standard");
        Visitor visitor4 = new Visitor("Bob", 30, "200 Park Ave", "V002", true, "Gold");
        Visitor visitor5 = new Visitor("Diana", 28, "400 Park Ave", "V004", true, "Platinum");
        
        System.out.println("\n--- Adding 5 visitors to the ride history (in random order) ---");
        ride.addVisitorToHistory(visitor1); // Charlie
        ride.addVisitorToHistory(visitor2); // Alice
        ride.addVisitorToHistory(visitor3); // Eve
        ride.addVisitorToHistory(visitor4); // Bob
        ride.addVisitorToHistory(visitor5); // Diana
        
        // Print all Visitors in the collection (before sorting)
        System.out.println("\n--- Printing all visitors in history (before sorting) ---");
        ride.printRideHistory();
        
        // Sort the collection
        System.out.println("\n--- Sorting the history ---");
        ride.sortHistory();
        
        // Print all Visitors in the collection (after sorting)
        System.out.println("\n--- Printing all visitors in history (after sorting) ---");
        ride.printRideHistory();
    }
    
    public void partFive() {
        // Create a new Ride object
        Employee operator = new Employee("Tom Operator", 29, "321 Work Lane", "E004", "Ride Operator", 47000.0);
        Ride ride = new Ride("Tea Cups", 12, operator, 4); // Max 4 riders per cycle
        
        // Add a minimum of 10 Visitors to the Queue
        Visitor visitor1 = new Visitor("Alice", 25, "100 Park Ave", "V001", false, "Standard");
        Visitor visitor2 = new Visitor("Bob", 30, "200 Park Ave", "V002", true, "Gold");
        Visitor visitor3 = new Visitor("Charlie", 22, "300 Park Ave", "V003", false, "Silver");
        Visitor visitor4 = new Visitor("Diana", 28, "400 Park Ave", "V004", true, "Platinum");
        Visitor visitor5 = new Visitor("Eve", 35, "500 Park Ave", "V005", false, "Standard");
        Visitor visitor6 = new Visitor("Frank", 40, "600 Park Ave", "V006", false, "Standard");
        Visitor visitor7 = new Visitor("Grace", 27, "700 Park Ave", "V007", true, "Gold");
        Visitor visitor8 = new Visitor("Henry", 33, "800 Park Ave", "V008", false, "Silver");
        Visitor visitor9 = new Visitor("Ivy", 24, "900 Park Ave", "V009", true, "Platinum");
        Visitor visitor10 = new Visitor("Jack", 29, "1000 Park Ave", "V010", false, "Standard");
        
        System.out.println("\n--- Adding 10 visitors to the queue ---");
        ride.addVisitorToQueue(visitor1);
        ride.addVisitorToQueue(visitor2);
        ride.addVisitorToQueue(visitor3);
        ride.addVisitorToQueue(visitor4);
        ride.addVisitorToQueue(visitor5);
        ride.addVisitorToQueue(visitor6);
        ride.addVisitorToQueue(visitor7);
        ride.addVisitorToQueue(visitor8);
        ride.addVisitorToQueue(visitor9);
        ride.addVisitorToQueue(visitor10);
        
        // Print all Visitors in the queue
        System.out.println("\n--- Printing all visitors in the queue (before running cycle) ---");
        ride.printQueue();
        
        // Run one cycle
        System.out.println("\n--- Running one cycle ---");
        ride.runOneCycle();
        
        // Print all Visitors in the queue after one cycle is run
        System.out.println("\n--- Printing all visitors in the queue (after running cycle) ---");
        ride.printQueue();
        
        // Print all Visitors in the collection
        System.out.println("\n--- Printing all visitors in the ride history ---");
        ride.printRideHistory();
    }
    
    public void partSix() {}
    
    public void partSeven() {}
}