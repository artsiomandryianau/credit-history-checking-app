package com.wolknashatle.datacollectionservice.model.reports;


import com.wolknashatle.datacollectionservice.model.ClientInfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


public class XmlSingleClientReport {


    private List<ClientInfo> clientsInfo = null;

    public List<ClientInfo> getClientsInfo() {
        return clientsInfo;
    }

    public void setClientsInfo(List<ClientInfo> clients) {
        this.clientsInfo = clients;
    }

}
