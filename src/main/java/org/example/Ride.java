package org.example;

public class Ride {
    private String rideName;
    private int capacity;
    private Employee operator;
    private boolean isOpen;
    
    public Ride() {
        this.rideName = "";
        this.capacity = 0;
        this.operator = null;
        this.isOpen = false;
    }
    
    public Ride(String rideName, int capacity, Employee operator) {
        this.rideName = rideName;
        this.capacity = capacity;
        this.operator = operator;
        this.isOpen = (operator != null); // Ride is open if there's an operator
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
    
    @Override
    public String toString() {
        return "Ride{" +
                "rideName='" + rideName + "', " +
                "capacity=" + capacity + ", " +
                "operator=" + (operator != null ? operator.getName() : "None") + ", " +
                "isOpen=" + isOpen + "}";
    }
}