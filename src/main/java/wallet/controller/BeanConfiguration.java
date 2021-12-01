package wallet.controller;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import wallet.beans.Card;
import wallet.beans.Customer;
import wallet.beans.StoreInfo;
import wallet.beans.Transaction;

/**
 * @author Thomas Syvertsen - tjsyvertsen
 * CIS175 - Fall 2021
 * Nov 10, 2021
 */

@Controller
public class BeanConfiguration {
//	@Bean
//	public ArrayList<Card> cards() {
//		ArrayList<Card> bean = new ArrayList<Card>();
//		return bean;
//	}
	
	@Bean
	public Card[] card() {
		Card[] bean = new Card[10];
		return bean;
	}
	
	@Bean
	public Customer customer() {
		Customer bean = new Customer();
		bean.setCards(new Card[10]);
		return bean;
	}
	
	@Bean
	public StoreInfo storeInfo() {
		StoreInfo bean = new StoreInfo();
		return bean;
	}
	
	@Bean
	public Transaction transaction() {
		Transaction bean = new Transaction();
		return bean;
	}
}
