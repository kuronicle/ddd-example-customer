package net.kuronicle.example.customer.normal.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import net.kuronicle.example.customer.normal.application.CustomerApplication;
import net.kuronicle.example.customer.normal.domain.Customer;

@RestController
@RequestMapping("api/normal/customer")
public class CustomerController {

	@Autowired
	CustomerApplication customerApplication;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	Customer postCustomer(@RequestBody Customer customer) {
		return customerApplication.createCustomer(customer);
	}

	@GetMapping("{id}")
	Customer getCustomer(@PathVariable String id) {
		return customerApplication.getCustomer(id);
	}
}
