package wallet.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import wallet.beans.Card;
import wallet.beans.Customer;
import wallet.beans.StoreInfo;

/**
 * @author Thomas Syvertsen - tjsyvertsen
 * CIS175 - Fall 2021
 * Nov 10, 2021
 */

@Controller
public class BeanConfiguration {
	@Bean
	public Card card() {
		Card bean = new Card();
		return bean;
	}
	
	@Bean
	public Customer customer() {
		Customer bean = new Customer();
		return bean;
	}
	
	@Bean
	public StoreInfo storeInfo() {
		StoreInfo bean = new StoreInfo();
		return bean;
	}
	
	
}
