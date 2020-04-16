package com.wolknashatle.clientdataservice.dao;

import com.wolknashatle.clientdataservice.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findById(Integer id);

    List<Client> findAll();
}
