package com.wolknashatle.dataanalizeservice.model.statistics;


public class UnpaidLoansStatistic {

    private int allClientsTotalDept;
    private int numberOfDebts;
    private int averageDept;
    private int amountOfLoansPayedBack;
    private int numberOfDebtors;




    public UnpaidLoansStatistic() {
    }

    public UnpaidLoansStatistic(int allClientsTotalDept, int numberOfDebtors, int numberOfDebts, int averageDept, int amountOfLoansPayedBack) {
        this.allClientsTotalDept = allClientsTotalDept;
        this.numberOfDebtors = numberOfDebtors;
        this.numberOfDebts = numberOfDebts;
        this.averageDept = averageDept;
        this.amountOfLoansPayedBack = amountOfLoansPayedBack;
    }

    public int getAllClientsTotalDept() {
        return allClientsTotalDept;
    }

    public void setAllClientsTotalDept(int allClientsTotalDept) {
        this.allClientsTotalDept = allClientsTotalDept;
    }

    public int getNumberOfDebtors() {
        return numberOfDebtors;
    }

    public void setNumberOfDebtors(int numberOfDebtors) {
        this.numberOfDebtors = numberOfDebtors;
    }

    public int getNumberOfDebts() {
        return numberOfDebts;
    }

    public void setNumberOfDebts(int numberOfDebts) {
        this.numberOfDebts = numberOfDebts;
    }

    public int getAverageDept() {
        return averageDept;
    }

    public void setAverageDept(int averageDept) {
        this.averageDept = averageDept;
    }

    public int getAmountOfLoansPayedBack() {
        return amountOfLoansPayedBack;
    }

    public void setAmountOfLoansPayedBack(int amountOfLoansPayedBack) {
        this.amountOfLoansPayedBack = amountOfLoansPayedBack;
    }
}
