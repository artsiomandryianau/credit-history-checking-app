package com.wolknashatle.loandataservice.models;



import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document
public class Loan {

    @Id
    private Integer loan_id;
    private Integer client_id;
    private boolean loan_is_payed;
    private String date_loan_take;
    private Integer loan_number_month_back;
    private Integer loan_amount;


    public Loan() {
    }

    public Loan(Integer loan_id, Integer client_id, boolean loan_is_payed, String date_loan_take, Integer loan_number_month_back, Integer loan_amount) {
        this.loan_id = loan_id;
        this.client_id = client_id;
        this.loan_is_payed = loan_is_payed;
        this.date_loan_take = date_loan_take;
        this.loan_number_month_back = loan_number_month_back;
        this.loan_amount = loan_amount;
    }

    public Integer getLoan_id() {
        return loan_id;
    }

    public Integer getClient_id() {
        return client_id;
    }

    public boolean isLoan_is_payed() {
        return loan_is_payed;
    }

    public String getDate_loan_take() {
        return date_loan_take;
    }

    public Integer getLoan_number_month_back() {
        return loan_number_month_back;
    }

    public Integer getLoan_amount() {
        return loan_amount;
    }
}
