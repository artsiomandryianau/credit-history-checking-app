package com.wolknashatle.clientdataservice.dao;

import com.wolknashatle.clientdataservice.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findById(Integer id);
}
