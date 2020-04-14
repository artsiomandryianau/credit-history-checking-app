package com.wolknashatle.loandataservice.models;



import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document
public class Loan {

    @Id
    private ObjectId loan_id;
    private String client_id;
    private String loan_is_payed;
    private String date_loan_take;
    private String loan_number_month_back;
    private String loan_amount;


    public Loan() {
    }

    public Loan(ObjectId loan_id, String client_id, String loan_is_payed, String date_loan_take, String loan_number_month_back, String loan_amount) {
        this.loan_id = loan_id;
        this.client_id = client_id;
        this.loan_is_payed = loan_is_payed;
        this.date_loan_take = date_loan_take;
        this.loan_number_month_back = loan_number_month_back;
        this.loan_amount = loan_amount;
    }

    public String getLoan_id() {
        return loan_id.toHexString();
    }

    public void setLoan_id(ObjectId loan_id) {
        this.loan_id = loan_id;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getLoan_is_payed() {
        return loan_is_payed;
    }

    public void setLoan_is_payed(String loan_is_payed) {
        this.loan_is_payed = loan_is_payed;
    }

    public String getDate_loan_take() {
        return date_loan_take;
    }

    public void setDate_loan_take(String date_loan_take) {
        this.date_loan_take = date_loan_take;
    }

    public String getLoan_number_month_back() {
        return loan_number_month_back;
    }

    public void setLoan_number_month_back(String loan_number_month_back) {
        this.loan_number_month_back = loan_number_month_back;
    }

    public String getLoan_amount() {
        return loan_amount;
    }

    public void setLoan_amount(String loan_amount) {
        this.loan_amount = loan_amount;
    }
}
