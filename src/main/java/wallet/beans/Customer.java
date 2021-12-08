/**
 * @author Caleb - cawasle
CIS175 - Fall 2021
Nov 14, 2021
 */
package wallet.beans;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.SequenceGenerator;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(initialValue = 1000000, name = "port_gen")
public class Customer {
	@Id
	@GeneratedValue()
	private long id; // might need to take out card id if customer is main class
	private String name;
	private String address;
	private String birthDate;
	private String phoneNumber;
//	@Autowired
	@OneToMany(mappedBy = "id", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
	@OrderColumn
	private Card[] cards = new Card[10];

	public Customer(String name) {
		this.name = name;
	}

	public Customer(String name, String address, String birthDate, String phoneNumber, int accountNumber) {
		this.name = name;
		this.address = address;
		this.birthDate = birthDate;
		this.phoneNumber = phoneNumber;
	}
	
	public void addCard(Card card) {
		cards[0] = card;
	}
}
