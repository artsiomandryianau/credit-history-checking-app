package com.wolknashatle.dataanalizeservice.model.reports;


import com.wolknashatle.dataanalizeservice.model.LoanInfo;

import java.util.List;


public class OverdueLoansReport {


    private List<LoanInfo> overdueLoanInfos;

    public OverdueLoansReport(List<LoanInfo> overdueLoanInfos) {
        this.overdueLoanInfos = overdueLoanInfos;
    }

    public OverdueLoansReport() {

    }

    public List<LoanInfo> getOverdueLoanInfos() {
        return overdueLoanInfos;
    }

    public void setOverdueLoanInfos(List<LoanInfo> overdueLoanInfos) {
        this.overdueLoanInfos = overdueLoanInfos;
    }
}