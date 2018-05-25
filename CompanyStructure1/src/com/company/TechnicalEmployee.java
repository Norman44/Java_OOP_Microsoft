package com.company;

public abstract class TechnicalEmployee extends Employee {
    public int checkIn;
    public TechnicalEmployee(String name){
        super(name, 75000);
    }

    public String employeeStatus(){
        return  getEmployeeID() + " " + getName() + " has " + checkIn + " successful check ins.";
    }
}
