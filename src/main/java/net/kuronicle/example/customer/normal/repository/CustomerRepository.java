package net.kuronicle.example.customer.normal.repository;

import net.kuronicle.example.customer.normal.domain.Customer;

public interface CustomerRepository {

	void save(Customer customer);

	Customer findOneById(String id);

}
