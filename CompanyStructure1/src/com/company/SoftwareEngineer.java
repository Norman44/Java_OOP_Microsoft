package com.company;

public class SoftwareEngineer extends TechnicalEmployee {
    public boolean accessToCode;
    public double bonus;

    public SoftwareEngineer(String name){
        super(name);
        checkIn = 0;
        accessToCode = false;
    }

    public boolean getCodeAccess(){
        return accessToCode;
    }
    public void setCodeAccess(boolean access){
        accessToCode = access;
    }
    public int getSuccessfulCheckIns(){
        return checkIn;
    }
    public boolean checkInCode(){
        if (((TechnicalLead) this.getManager()).approveCheckIn(this)) {
            checkIn++;
            return true;
        } else {
            accessToCode = false;
            return false;
        }
    }
}
