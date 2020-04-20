package com.wolknashatle.datacollectionservice.model;


public class OverdueLoanInfo {


    private Loan loan;

    private Client client;

    public OverdueLoanInfo() {

    }

    public OverdueLoanInfo(Loan loan, Client client) {
        this.loan = loan;
        this.client = client;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
