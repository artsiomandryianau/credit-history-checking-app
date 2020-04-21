package com.wolknashatle.datacollectionservice.model.reports;


import com.wolknashatle.datacollectionservice.model.LoanInfo;

import java.util.List;


public class UnpaidLoansReport {


    private List<LoanInfo> overdueLoanInfos;

    public UnpaidLoansReport(List<LoanInfo> overdueLoanInfos) {
        this.overdueLoanInfos = overdueLoanInfos;
    }

    public UnpaidLoansReport() {

    }

    public List<LoanInfo> getOverdueLoanInfos() {
        return overdueLoanInfos;
    }

    public void setOverdueLoanInfos(List<LoanInfo> overdueLoanInfos) {
        this.overdueLoanInfos = overdueLoanInfos;
    }
}
