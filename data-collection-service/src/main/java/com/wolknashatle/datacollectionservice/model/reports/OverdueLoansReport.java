package com.wolknashatle.datacollectionservice.model.reports;


import com.wolknashatle.datacollectionservice.model.OverdueLoanInfo;

import java.util.List;


public class OverdueLoansReport {


    private List<OverdueLoanInfo> overdueLoanInfos;

    public OverdueLoansReport(List<OverdueLoanInfo> overdueLoanInfos) {
        this.overdueLoanInfos = overdueLoanInfos;
    }

    public OverdueLoansReport() {

    }

    public List<OverdueLoanInfo> getOverdueLoanInfos() {
        return overdueLoanInfos;
    }

    public void setOverdueLoanInfos(List<OverdueLoanInfo> overdueLoanInfos) {
        this.overdueLoanInfos = overdueLoanInfos;
    }
}
