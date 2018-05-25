package com.company;

public class Accountant extends BusinessEmployee {
    public TechnicalLead teamSupport;

    public Accountant(String name) {
        super(name);
        bonusBudget = 0;
        teamSupport = null;
    }
    public TechnicalLead getTeamSupported(){
        return teamSupport;
    }
    public void supportTeam(TechnicalLead lead){
        teamSupport = lead;
        double sum = 0;
        for (int x = 0; x< teamSupport.reports.size() ; x++){
            sum += teamSupport.reports.get(x).getBaseSalary();
        }
        bonusBudget = sum * 1.1;
    }
    public boolean approveBonus(double bonus) {
        return teamSupport != null && bonus<bonusBudget;
    }
    public String employeeStatus(){
        return super.employeeStatus() + " is supporting " + teamSupport;
    }
}
