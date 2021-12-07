package wallet.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Thomas Syvertsen - tjsyvertsen
 * CIS175 - Fall 2021
 * Nov 10, 2021
 */

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long id;
	private String cardName;
	private String type;
	private int cardNumber;
	private int pin;
	private double balance;
//	private Date expiration;
	@Autowired
	private Transaction[] transaction;
	
//	public double balanceAfterCharge() {
//		balance -= transaction.getTransactionAmount();
//		return balance;
//	}
}
