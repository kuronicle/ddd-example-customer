package net.kuronicle.example.customer.normal.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
public class Customer {

	@Getter
	private String id;
	
	@Getter
	private String name;
	
	@Getter
	private String mailAddress;
	
	@Getter
	private String company;

	public Customer(String name, String mailAddress, String company) {
		this.name = name;
		this.mailAddress = mailAddress;
		this.company = company;
	}
	
	public Customer(String id, String name, String mailAddress, String company) {
		this.id = id;
		this.name = name;
		this.mailAddress = mailAddress;
		this.company = company;
	}

}
