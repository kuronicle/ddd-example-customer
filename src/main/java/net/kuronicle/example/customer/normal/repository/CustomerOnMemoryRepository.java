package net.kuronicle.example.customer.normal.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import net.kuronicle.example.customer.normal.domain.Customer;

@Repository
public class CustomerOnMemoryRepository implements CustomerRepository {

	private Map<String, Customer> customerMap = new ConcurrentHashMap<>();

	@Override
	public void save(Customer customer) {
		customerMap.put(customer.getId(), customer);
	}

	@Override
	public Customer findOneById(String id) {
		return customerMap.get(id);
	}

}
