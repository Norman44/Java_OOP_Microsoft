package com.company;

public abstract class Employee {
    private String name;
    private double baseSalary;
    public int employeeID;
    public int IDcount;
    private Employee employeeManager;

    public Employee(String name, double baseSalary){
        IDcount++;
        this.name = name;
        this.baseSalary = baseSalary;
        employeeID = IDcount;
        System.out.println("UPDATE EMPLOYasdadasEE ID");
    }
    public double getBaseSalary(){
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeID(){
        return employeeID;
    }

    public Employee getManager() {
        return employeeManager;
    }

    public boolean equals(Employee other){
        return this.employeeID == other.employeeID;
    }

    public String toString(){
        return getEmployeeID() + " " + getName();
    }

    public abstract String employeeStatus();
}
