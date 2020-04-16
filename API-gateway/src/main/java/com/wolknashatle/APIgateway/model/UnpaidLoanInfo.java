package com.wolknashatle.APIgateway.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "unpaidLoanInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class UnpaidLoanInfo {

    @XmlElement(name = "loanInfo")
    private Loan loan;
    @XmlElement(name = "clientInfo")
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
