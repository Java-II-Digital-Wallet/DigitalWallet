package wallet.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Thomas Syvertsen - tjsyvertsen
 * CIS175 - Fall 2021
 * Nov 10, 2021
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {
	@Id
	@GeneratedValue
	private Long id;
	private String cardName;
	private int cardNumber;
	private int pin;
	private int balance;
	private Date expiration;
}
