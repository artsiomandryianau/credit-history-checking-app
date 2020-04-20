package com.wolknashatle.APIgateway.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


public class LoanList {


    private List<Loan> list = new ArrayList<>();

    public LoanList(List<Loan> list) {
        this.list = list;
    }

    public LoanList() {
    }

    public List<Loan> getList() {
        return list;
    }

    public void setList(List<Loan> list) {
        this.list = list;
    }
}
