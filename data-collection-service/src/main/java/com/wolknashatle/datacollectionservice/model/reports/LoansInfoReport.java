package com.wolknashatle.datacollectionservice.model.reports;

import com.wolknashatle.datacollectionservice.model.ClientInfo;
import com.wolknashatle.datacollectionservice.model.LoanInfo;

import java.util.List;

public class LoansInfoReport {

    private List<ClientInfo> clientInfos;



    public LoansInfoReport() {

    }

    public LoansInfoReport(List<ClientInfo> clientInfos) {
        this.clientInfos = clientInfos;
    }

    public List<ClientInfo> getClientInfos() {
        return clientInfos;
    }

    public void setClientInfos(List<ClientInfo> clientInfos) {
        this.clientInfos = clientInfos;
    }
}
