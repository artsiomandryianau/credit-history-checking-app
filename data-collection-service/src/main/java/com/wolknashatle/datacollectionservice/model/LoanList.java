package com.wolknashatle.datacollectionservice.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name = "loans")
@XmlAccessorType(XmlAccessType.FIELD)
public class LoanList {

    @XmlElement(name = "loan")
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
