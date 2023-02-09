package net.kuronicle.example.customer.normal.application;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.kuronicle.example.customer.normal.domain.Customer;
import net.kuronicle.example.customer.normal.repository.CustomerRepository;

@Service
public class CustomerApplication {

	@Autowired
	CustomerRepository customerRepository;

	public Customer createCustomer(Customer customerRequest) {
		String customerId = UUID.randomUUID().toString();
		Customer customer = new Customer(customerId, customerRequest.getName(), customerRequest.getMailAddress(),
				customerRequest.getCompany());
		customerRepository.save(customer);
		return customer;
	}

	public Customer getCustomer(String id) {
		Customer customer = customerRepository.findOneById(id);
		return customer;
	}
}
