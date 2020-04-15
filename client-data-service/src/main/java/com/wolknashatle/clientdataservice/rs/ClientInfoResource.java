package com.wolknashatle.clientdataservice.rs;

import com.wolknashatle.clientdataservice.dao.ClientRepository;
import com.wolknashatle.clientdataservice.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientInfoResource {

    @Autowired
    private ClientRepository clientRepository;

    @RequestMapping("/{clientId}")
    public Client getClientById(@PathVariable("clientId") String id) {
        return clientRepository.findById(Integer.parseInt(id));
    }
}
