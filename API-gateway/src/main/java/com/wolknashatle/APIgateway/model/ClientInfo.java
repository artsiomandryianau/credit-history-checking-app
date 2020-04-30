package com.wolknashatle.APIgateway.model;

public class ClientInfo {

    private Client client;

    private LoanList loanList;

    public ClientInfo() {
    }

    public ClientInfo(Client client, LoanList loanList) {
        this.client = client;
        this.loanList = loanList;
    }

    public LoanList getLoanList() {
        return loanList;
    }

    public void setLoanList(LoanList loanList) {
        this.loanList = loanList;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


}
