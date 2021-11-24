package wallet.beans;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jakem - jrmeyer4
 * CIS175 - Fall 2021
 * Nov 17, 2021
 */
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreInfo {
	private String storeCompanyName;
	private String storeAddress;
	private String storeInfoAddress;
}
