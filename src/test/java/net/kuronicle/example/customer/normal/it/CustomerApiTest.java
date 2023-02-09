package net.kuronicle.example.customer.normal.it;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import net.kuronicle.example.customer.normal.domain.Customer;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CustomerApiTest {
	@LocalServerPort
	int port;

	@Autowired
	RestTemplateBuilder restTemplateBuilder;

	RestTemplate restTemplate;
	
	@BeforeEach
	void setUp() {
		if (restTemplate == null) {
			restTemplate = restTemplateBuilder.build();
		}
	}

	@Test
	void testGetCustomer() {
		// Customerを登録する
		Customer customer = new Customer("Taro", "taro@example.com", "Example.inc");
		String createUrl = "http://localhost:" + port + "/api/normal/customer";
		RequestEntity<Customer> createRequest = RequestEntity.post(createUrl)
				.contentType(MediaType.APPLICATION_JSON)
				.body(customer);
		ResponseEntity<Customer> createResponse = restTemplate.exchange(createRequest, Customer.class);
		System.out.println(String.format("Create customer result\n HTTP Status:%s\n Customer:%s", createResponse.getStatusCode().toString(),
				createResponse.getBody().toString()));

		// Customerを取得する
		String id = createResponse.getBody().getId();
		String getUrl = createUrl + "/" + id;
		ResponseEntity<Customer> getResponse = restTemplate.getForEntity(getUrl, Customer.class);
		System.out.println(String.format("Get customer result\n HTTP Status:%s\n Customer:%s", getResponse.getStatusCode().toString(), getResponse.getBody().toString()));
	}

}
