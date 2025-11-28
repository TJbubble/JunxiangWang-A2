package org.example;

import java.util.ArrayList;
import java.util.List;

public class Ride implements RideInterface {
    private String rideName;
    private int capacity;
    private Employee operator; // Employee who operates the ride
    private boolean isOpen;
    private List<Visitor> queue; // Queue of visitors waiting for the ride
    private List<Visitor> history; // History of visitors who have taken the ride
    
    public Ride() {
        this.rideName = "";
        this.capacity = 0;
        this.operator = null;
        this.isOpen = false;
        this.queue = new ArrayList<>();
        this.history = new ArrayList<>();
    }
    
    public Ride(String rideName, int capacity, Employee operator) {
        this.rideName = rideName;
        this.capacity = capacity;
        this.operator = operator;
        this.isOpen = (operator != null); // Ride is open if there's an operator
        this.queue = new ArrayList<>();
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
    
    public List<Visitor> getQueue() {
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
        }
    }
    
    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (visitor != null) {
            queue.remove(visitor);
        }
    }
    
    @Override
    public void printQueue() {
        System.out.println("Queue for " + rideName + ":");
        if (queue.isEmpty()) {
            System.out.println("  No visitors in queue");
        } else {
            for (int i = 0; i < queue.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + queue.get(i).getName());
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
                Visitor visitor = queue.get(0);
                addVisitorToHistory(visitor);
                queue.remove(0);
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