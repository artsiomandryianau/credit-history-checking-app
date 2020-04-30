package com.wolknashatle.clientdataservice.domain;


import java.util.ArrayList;
import java.util.List;

public class ClientList {

    private List<Client> clientList = new ArrayList<Client>();

    public ClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }
}
