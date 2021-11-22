/**
 * @author Caleb - cawasle
CIS175 - Fall 2021
Nov 14, 2021
 */
package wallet.beans;

import javax.annotation.Resource;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Customer {
	@Id
	@GeneratedValue
	private long id; // might need to take out card id if customer is main class
	private String name;
	private String address;
	private String birthDate;
	private String phoneNumber;
	private int accountNumber;
//	@OneToMany(fetch = FetchType.LAZY)
//	@JoinColumn(name = "card_id", foreignKey = @ForeignKey(name = "fk_customers_cards_id"))
//	@OrderColumn(name="cardName")
	@Autowired
	private Card[] card;
	@Autowired
	private StoreInfo[] storeInfo;

	public Customer(String name) {
		super();
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
