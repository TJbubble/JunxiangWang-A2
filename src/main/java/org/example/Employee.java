package org.example;

public class Employee extends Person {
    private String employeeId;
    private String position; // Position/role of the employee
    private double salary;
    
    public Employee() {
        super();
        this.employeeId = "";
        this.position = "";
        this.salary = 0.0;
    }
    
    public Employee(String name, int age, String address, String employeeId, String position, double salary) {
        super(name, age, address);
        this.employeeId = employeeId;
        this.position = position;
        this.salary = salary;
    }
    
    // Getters and setters
    public String getEmployeeId() {
        return employeeId;
    }
    
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    
    public String getPosition() {
        return position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + getName() + "', " +
                "age=" + getAge() + ", " +
                "address='" + getAddress() + "', " +
                "employeeId='" + employeeId + "', " +
                "position='" + position + "', " +
                "salary=" + salary + "}";
    }
}