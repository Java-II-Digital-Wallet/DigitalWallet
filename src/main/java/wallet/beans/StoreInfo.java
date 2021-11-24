package wallet.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jakem - jrmeyer4
 * CIS175 - Fall 2021
 * Nov 17, 2021
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreInfo {
	@Id
	@GeneratedValue
	private long id;
	private String storeCompanyName;
	private String storeAddress;
	private String storeInfoAddress;
}
