package wallet.beans;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Thomas Syvertsen - tjsyvertsen CIS175 - Fall 2021 Nov 24, 2021
 */

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
//	@Id
//	@GeneratedValue
//	private long id;
	private double transactionAmount;
	@Autowired
	private StoreInfo storeInfo;
}
