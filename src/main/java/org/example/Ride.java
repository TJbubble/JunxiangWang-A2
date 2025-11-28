package org.example;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;
import org.example.Visitor;
import org.example.Employee;

public class Ride implements RideInterface {
    private String rideName;
    private int capacity;
    private Employee operator; // Employee who operates the ride
    private boolean isOpen;
    private Queue<Visitor> queue; // Queue of visitors waiting for the ride
    private LinkedList<Visitor> history; // History of visitors who have taken the ride
    
    public Ride() {
        this.rideName = "";
        this.capacity = 0;
        this.operator = null;
        this.isOpen = false;
        this.queue = new LinkedList<>();
        this.history = new LinkedList<>();
    }
    
    public Ride(String rideName, int capacity, Employee operator) {
        this.rideName = rideName;
        this.capacity = capacity;
        this.operator = operator;
        this.isOpen = (operator != null); // Ride is open if there's an operator
        this.queue = new LinkedList<>();
        this.history = new LinkedList<>();
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
    
    public LinkedList<Visitor> getHistory() {
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