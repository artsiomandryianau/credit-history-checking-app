package com.wolknashatle.datacollectionservice.model.reports;


import com.wolknashatle.datacollectionservice.model.ClientInfo;

import java.util.List;


public class SingleClientReport {


    private List<ClientInfo> clientsInfo = null;

    public List<ClientInfo> getClientsInfo() {
        return clientsInfo;
    }

    public void setClientsInfo(List<ClientInfo> clients) {
        this.clientsInfo = clients;
    }

}
