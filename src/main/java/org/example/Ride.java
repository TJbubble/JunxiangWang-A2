package org.example;

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import org.example.Visitor; // Add this import
import org.example.Employee; // Add this import

public class Ride implements RideInterface {
    private String rideName;
    private int capacity;
    private Employee operator; // Employee who operates the ride
    private boolean isOpen;
    private Queue<Visitor> queue; // Queue of visitors waiting for the ride
    private List<Visitor> history; // History of visitors who have taken the ride
    
    public Ride() {
        this.rideName = "";
        this.capacity = 0;
        this.operator = null;
        this.isOpen = false;
        this.queue = new LinkedList<>();
        this.history = new ArrayList<>();
    }
    
    public Ride(String rideName, int capacity, Employee operator) {
        this.rideName = rideName;
        this.capacity = capacity;
        this.operator = operator;
        this.isOpen = (operator != null); // Ride is open if there's an operator
        this.queue = new LinkedList<>();
        this.history = new ArrayList<>();
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
    
    public Queue<Visitor> getQueue() {
        return queue;
    }
    
    public List<Visitor> getHistory() {
        return history;
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
            List<Visitor> queueList = new ArrayList<>(queue);
            for (int i = 0; i < queueList.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + queueList.get(i).getName());
            }
        }
    }
    
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor != null) {
            history.add(visitor);
        }
    }
    
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (visitor == null) {
            return false;
        }
        return history.contains(visitor);
    }
    
    @Override
    public int numberOfVisitors() {
        return history.size();
    }
    
    @Override
    public void printRideHistory() {
        System.out.println("Ride history for " + rideName + ":");
        if (history.isEmpty()) {
            System.out.println("  No visitors have taken this ride");
        } else {
            for (int i = 0; i < history.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + history.get(i).getName());
            }
        }
    }
    
    @Override
    public void runOneCycle() {
        System.out.println("Running one cycle of " + rideName);
        if (!queue.isEmpty()) {
            int visitorsToTake = Math.min(queue.size(), capacity);
            System.out.println("Taking " + visitorsToTake + " visitors on the ride");
            
            // Move visitors from queue to history
            for (int i = 0; i < visitorsToTake; i++) {
                Visitor visitor = queue.poll(); // FIFO - remove from front of queue
                if (visitor != null) {
                    addVisitorToHistory(visitor);
                }
            }
        } else {
            System.out.println("No visitors in queue to take on the ride");
        }
    }
    
    @Override
    public String toString() {
        return "Ride{" +
                "rideName='" + rideName + "', " +
                "capacity=" + capacity + ", " +
                "operator=" + (operator != null ? operator.getName() : "None") + ", " +
                "isOpen=" + isOpen + ", " +
                "queueSize=" + queue.size() + ", " +
                "historySize=" + history.size() + "}";
    }
}