package com.wolknashatle.datacollectionservice.model;


public class UnpaidLoanInfo {


    private Loan loan;

    private Client client;

    public UnpaidLoanInfo() {

    }

    public UnpaidLoanInfo(Loan loan, Client client) {
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
