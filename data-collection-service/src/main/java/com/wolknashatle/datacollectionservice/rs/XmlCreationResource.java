package com.wolknashatle.datacollectionservice.rs;


import com.wolknashatle.datacollectionservice.model.Client;
import com.wolknashatle.datacollectionservice.model.ClientInfo;
import com.wolknashatle.datacollectionservice.model.LoanList;
import com.wolknashatle.datacollectionservice.model.reports.XmlObject;
import com.wolknashatle.datacollectionservice.properties.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/getReport")
@RestController
public class XmlCreationResource {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/clientsLoans/{clientId}")
    public XmlObject getClientLoansReport(@PathVariable("clientId") String clientId){
        //Getting data from client-data-service
        String clientServiceUrl = "http://" + applicationProperties.getClientDataServicehost() + ":" + applicationProperties.getClientDataServicePort();
        Client client = restTemplate.getForObject(clientServiceUrl + "/client/" + clientId, Client.class);
        //Getting data from loan-data-service
        String loanServiceUrl = "http://" + applicationProperties.getLoanDataServiceHost() + ":" + applicationProperties.getLoanDataServicePort();
        LoanList loanList = restTemplate.getForObject(loanServiceUrl +"/loans/client/" + clientId, LoanList.class);
        //Saving data into one object
        ClientInfo clientInfo = new ClientInfo(client, loanList);
        XmlObject xmlObject = new XmlObject();
        List<ClientInfo> clientInfoList = new ArrayList<>();
        clientInfoList.add(clientInfo);
        xmlObject.setClientsInfo(clientInfoList);
        return xmlObject;
    }


}
