package org.example;

public class Visitor extends Person {
    private String ticketId;
    private boolean hasSeasonPass;
    private String membershipLevel;
    
    public Visitor() {
        super();
        this.ticketId = "";
        this.hasSeasonPass = false;
        this.membershipLevel = "Standard";
    }
    
    public Visitor(String name, int age, String address, String ticketId, boolean hasSeasonPass, String membershipLevel) {
        super(name, age, address);
        this.ticketId = ticketId;
        this.hasSeasonPass = hasSeasonPass;
        this.membershipLevel = membershipLevel;
    }
    
    // Getters and setters
    public String getTicketId() {
        return ticketId;
    }
    
    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }
    
    public boolean isHasSeasonPass() {
        return hasSeasonPass;
    }
    
    public void setHasSeasonPass(boolean hasSeasonPass) {
        this.hasSeasonPass = hasSeasonPass;
    }
    
    public String getMembershipLevel() {
        return membershipLevel;
    }
    
    public void setMembershipLevel(String membershipLevel) {
        this.membershipLevel = membershipLevel;
    }
    
    @Override
    public String toString() {
        return "Visitor{" +
                "name='" + getName() + "', " +
                "age=" + getAge() + ", " +
                "address='" + getAddress() + "', " +
                "ticketId='" + ticketId + "', " +
                "hasSeasonPass=" + hasSeasonPass + ", " +
                "membershipLevel='" + membershipLevel + "'}";
    }
}