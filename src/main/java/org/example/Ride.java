package org.example;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Collections;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import org.example.Visitor;
import org.example.Employee;
import org.example.VisitorComparator;

public class Ride implements RideInterface {
    private String rideName;
    private int capacity;
    private Employee operator; // Employee who operates the ride
    private boolean isOpen;
    private Queue<Visitor> queue; // Queue of visitors waiting for the ride
    private LinkedList<Visitor> history; // History of visitors who have taken the ride
    private int maxRider; // Maximum number of visitors the ride can take in one cycle
    private int numOfCycles; // Number of times the ride has been run
    
    public Ride() {
        this.rideName = "";
        this.capacity = 0;
        this.operator = null;
        this.isOpen = false;
        this.queue = new LinkedList<>();
        this.history = new LinkedList<>();
        this.maxRider = 1; // At least 1 visitor required
        this.numOfCycles = 0;
    }
    
    public Ride(String rideName, int capacity, Employee operator, int maxRider) {
        this.rideName = rideName;
        this.capacity = capacity;
        this.operator = operator;
        this.isOpen = (operator != null); // Ride is open if there's an operator
        this.queue = new LinkedList<>();
        this.history = new LinkedList<>();
        this.maxRider = Math.max(1, maxRider); // Ensure at least 1
        this.numOfCycles = 0;
    }
    
    // Getters and setters
    public String getRideName() {
        return rideName;
    }
    
    public void setRideName(String rideName) {
        this.rideName = rideName;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public Employee getOperator() {
        return operator;
    }
    
    public void setOperator(Employee operator) {
        this.operator = operator;
        // Ride is open if there's an operator assigned
        this.isOpen = (operator != null);
    }
    
    public boolean isOpen() {
        return isOpen;
    }
    
    public void setOpen(boolean open) {
        this.isOpen = open;
    }
    
    public int getMaxRider() {
        return maxRider;
    }
    
    public void setMaxRider(int maxRider) {
        this.maxRider = Math.max(1, maxRider); // Ensure at least 1
    }
    
    public int getNumOfCycles() {
        return numOfCycles;
    }
    
    public void setNumOfCycles(int numOfCycles) {
        this.numOfCycles = numOfCycles;
    }
    
    public Queue<Visitor> getQueue() {
        return queue;
    }
    
    public LinkedList<Visitor> getHistory() {
        return history;
    }
    
    // Method to sort the history collection
    public void sortHistory() {
        Collections.sort(history, new VisitorComparator());
        System.out.println("History sorted for " + rideName);
    }
    
    // Method to export ride history to a CSV file
    public void exportRideHistory(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Write header
            writer.write("name,age,address,ticketId,hasSeasonPass,membershipLevel");
            writer.newLine();
            
            // Write each visitor's data
            for (Visitor visitor : history) {
                writer.write(
                    visitor.getName() + "," +
                    visitor.getAge() + "," +
                    visitor.getAddress() + "," +
                    visitor.getTicketId() + "," +
                    visitor.isHasSeasonPass() + "," +
                    visitor.getMembershipLevel()
                );
                writer.newLine();
            }
            
            System.out.println("Ride history exported successfully to " + filename);
        } catch (IOException e) {
            System.err.println("Error exporting ride history to " + filename + ": " + e.getMessage());
        }
    }
    
    // Method to import ride history from a CSV file
    public void importRideHistory(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean isFirstLine = true;
            
            while ((line = reader.readLine()) != null) {
                // Skip the header line
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                
                // Parse the line
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    String name = parts[0];
                    int age = Integer.parseInt(parts[1]);
                    String address = parts[2];
                    String ticketId = parts[3];
                    boolean hasSeasonPass = Boolean.parseBoolean(parts[4]);
                    String membershipLevel = parts[5];
                    
                    // Create a new Visitor and add to history
                    Visitor visitor = new Visitor(name, age, address, ticketId, hasSeasonPass, membershipLevel);
                    history.add(visitor);
                } else {
                    System.err.println("Invalid line format: " + line);
                }
            }
            
            System.out.println("Ride history imported successfully from " + filename);
        } catch (IOException e) {
            System.err.println("Error importing ride history from " + filename + ": " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing numeric values from file: " + e.getMessage());
        }
    }
    
    // Interface methods implementation
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            queue.add(visitor);
            System.out.println("Visitor " + visitor.getName() + " added to the queue for " + rideName);
        } else {
            System.out.println("Failed to add visitor to queue: visitor is null");
        }
    }
    
    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (visitor != null && queue.remove(visitor)) {
            System.out.println("Visitor " + visitor.getName() + " removed from the queue for " + rideName);
        } else {
            System.out.println("Failed to remove visitor from queue: visitor not found or is null");
        }
    }
    
    @Override
    public void printQueue() {
        System.out.println("Queue for " + rideName + ":");
        if (queue.isEmpty()) {
            System.out.println("  No visitors in queue");
        } else {
            // Convert queue to list to maintain order for printing
            LinkedList<Visitor> queueList = new LinkedList<>(queue);
            for (int i = 0; i < queueList.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + queueList.get(i).getName());
            }
        }
    }
    
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor != null) {
            history.add(visitor);
            System.out.println("Visitor " + visitor.getName() + " added to history for " + rideName);
        } else {
            System.out.println("Failed to add visitor to history: visitor is null");
        }
    }
    
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (visitor == null) {
            System.out.println("Failed to check visitor in history: visitor is null");
            return false;
        }
        
        boolean found = history.contains(visitor);
        System.out.println("Visitor " + visitor.getName() + (found ? " is" : " is not") + " in history for " + rideName);
        return found;
    }
    
    @Override
    public int numberOfVisitors() {
        int count = history.size();
        System.out.println("Number of visitors in history for " + rideName + ": " + count);
        return count;
    }
    
    @Override
    public void printRideHistory() {
        System.out.println("Ride history for " + rideName + ":");
        if (history.isEmpty()) {
            System.out.println("  No visitors have taken this ride");
        } else {
            // Using Iterator as required
            Iterator<Visitor> iterator = history.iterator();
            int index = 1;
            while (iterator.hasNext()) {
                Visitor visitor = iterator.next();
                System.out.println("  " + index + ". " + visitor.getName());
                index++;
            }
        }
    }
    
    @Override
    public void runOneCycle() {
        // Check if there is a ride operator
        if (operator == null) {
            System.out.println("Cannot run " + rideName + ": No ride operator assigned");
            return;
        }
        
        // Check if there are visitors in the queue
        if (queue.isEmpty()) {
            System.out.println("Cannot run " + rideName + ": No visitors in queue");
            return;
        }
        
        // Run the ride cycle
        System.out.println("Running cycle #" + (numOfCycles + 1) + " of " + rideName);
        
        // Take up to maxRider visitors from the queue
        int visitorsToTake = Math.min(queue.size(), maxRider);
        System.out.println("Taking " + visitorsToTake + " visitors on the ride");
        
        // Move visitors from queue to history
        for (int i = 0; i < visitorsToTake; i++) {
            Visitor visitor = queue.poll(); // FIFO - remove from front of queue
            if (visitor != null) {
                addVisitorToHistory(visitor);
            }
        }
        
        // Increment the cycle counter
        numOfCycles++;
        System.out.println("Cycle #" + numOfCycles + " completed for " + rideName);
    }
    
    @Override
    public String toString() {
        return "Ride{" +
                "rideName='" + rideName + "', " +
                "capacity=" + capacity + ", " +
                "operator=" + (operator != null ? operator.getName() : "None") + ", " +
                "isOpen=" + isOpen + ", " +
                "maxRider=" + maxRider + ", " +
                "numOfCycles=" + numOfCycles + ", " +
                "queueSize=" + queue.size() + ", " +
                "historySize=" + history.size() + "}";
    }
}