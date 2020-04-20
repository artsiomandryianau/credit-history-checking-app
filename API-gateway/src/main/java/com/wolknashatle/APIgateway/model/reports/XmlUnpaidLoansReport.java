package com.wolknashatle.APIgateway.model.reports;


import com.wolknashatle.APIgateway.model.OverdueLoanInfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


public class XmlUnpaidLoansReport {


    private List<OverdueLoanInfo> overdueLoanInfos;

    public XmlUnpaidLoansReport(List<OverdueLoanInfo> overdueLoanInfos) {
        this.overdueLoanInfos = overdueLoanInfos;
    }

    public XmlUnpaidLoansReport() {

    }

    public List<OverdueLoanInfo> getOverdueLoanInfos() {
        return overdueLoanInfos;
    }

    public void setOverdueLoanInfos(List<OverdueLoanInfo> overdueLoanInfos) {
        this.overdueLoanInfos = overdueLoanInfos;
    }
}
