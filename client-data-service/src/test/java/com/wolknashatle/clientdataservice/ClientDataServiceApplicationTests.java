package com.wolknashatle.clientdataservice;

import com.wolknashatle.clientdataservice.rs.ClientInfoResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("/application-test.properties")
@Sql(value = {"/create-client-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/delete-client-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class ClientDataServiceApplicationTests {

	@Autowired
	private ClientInfoResource controller;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void clientInfoResourceTest() throws Exception {

	}

}
