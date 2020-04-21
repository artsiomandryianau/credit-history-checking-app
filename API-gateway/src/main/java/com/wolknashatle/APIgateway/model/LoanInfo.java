package com.wolknashatle.APIgateway.model;


public class LoanInfo {

    private Integer loan_id;
    private boolean loan_is_payed;
    private String date_loan_take;
    private Integer loan_number_month_back;
    private Integer loan_amount;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String email;
    private String phoneNumber;
    private String address;

    public LoanInfo(Client client, Loan loan) {
        this.loan_id = loan.getLoan_id();
        this.loan_is_payed = loan.isLoan_is_payed();
        this.date_loan_take = loan.getDate_loan_take();
        this.loan_number_month_back = loan.getLoan_number_month_back();
        this.loan_amount = loan.getLoan_amount();
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();
        this.dateOfBirth = client.getDateOfBirth();
        this.email = client.getEmail();
        this.phoneNumber = client.getPhoneNumber();
        this.address = client.getAddress();
    }

    public LoanInfo() {
    }

    public LoanInfo(Integer loan_id, boolean loan_is_payed, String date_loan_take, Integer loan_number_month_back, Integer loan_amount, String firstName, String lastName, String dateOfBirth, String email, String phoneNumber, String address) {
        this.loan_id = loan_id;
        this.loan_is_payed = loan_is_payed;
        this.date_loan_take = date_loan_take;
        this.loan_number_month_back = loan_number_month_back;
        this.loan_amount = loan_amount;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Integer getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(Integer loan_id) {
        this.loan_id = loan_id;
    }

    public boolean isLoan_is_payed() {
        return loan_is_payed;
    }

    public void setLoan_is_payed(boolean loan_is_payed) {
        this.loan_is_payed = loan_is_payed;
    }

    public String getDate_loan_take() {
        return date_loan_take;
    }

    public void setDate_loan_take(String date_loan_take) {
        this.date_loan_take = date_loan_take;
    }

    public Integer getLoan_number_month_back() {
        return loan_number_month_back;
    }

    public void setLoan_number_month_back(Integer loan_number_month_back) {
        this.loan_number_month_back = loan_number_month_back;
    }

    public Integer getLoan_amount() {
        return loan_amount;
    }

    public void setLoan_amount(Integer loan_amount) {
        this.loan_amount = loan_amount;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
