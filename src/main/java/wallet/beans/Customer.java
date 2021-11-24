/**
 * @author Caleb - cawasle
CIS175 - Fall 2021
Nov 14, 2021
 */
package wallet.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	@Id
	@GeneratedValue
	private long id; // might need to take out card id if customer is main class
	private String name;
	private String address;
	private String birthDate;
	private String phoneNumber;
	private int accountNumber;
	@Autowired
	private Card[] card;

	public Customer(String name) {
		this.name = name;
	}

	public Customer(String name, String address, String birthDate, String phoneNumber, int accountNumber) {
		this.name = name;
		this.address = address;
		this.birthDate = birthDate;
		this.phoneNumber = phoneNumber;
		this.accountNumber = accountNumber;
	}
}
