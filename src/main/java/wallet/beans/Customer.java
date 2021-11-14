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

@Entity
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
	private Card card;
	
	public Customer()
	{
		super();
	}
	
	public Customer(String name)
	{
		super();
		this.name = name;
	}
	
	public Customer(String name, String address, String birthDate, String phoneNumber, int accountNumber)
	{
		this.name = name;
		this.address = address;
		this.birthDate = birthDate;
		this.phoneNumber = phoneNumber;
		this.accountNumber = accountNumber;
	}
	
	public Customer(int id, String name, String address, String birthDate, String phoneNumber, int accountNumber)
	{
		this.id = id;
		this.name = name;
		this.address = address;
		this.birthDate = birthDate;
		this.phoneNumber = phoneNumber;
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the birthDate
	 */
	public String getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the accountNumber
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the card
	 */
	public Card getCard() {
		return card;
	}

	/**
	 * @param card the card to set
	 */
	public void setCard(Card card) {
		this.card = card;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", birthDate=" + birthDate
				+ ", phoneNumber=" + phoneNumber + ", accountNumber=" + accountNumber + "]";
	}
}
