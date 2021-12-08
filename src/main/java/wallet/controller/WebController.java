package wallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import wallet.beans.Card;
import wallet.beans.Customer;
import wallet.beans.StoreInfo;
import wallet.beans.Transaction;
import wallet.repository.CustomerRepository;

/**
 * @author Thomas Syvertsen - tjsyvertsen CIS175 - Fall 2021 Nov 17, 2021
 */

@Controller
public class WebController {
	@Autowired
	CustomerRepository repo;
	
	@Autowired
	SearchService service;

	@GetMapping("/viewAllCustomers")
	public String viewAllCustomers(Model model) {
		model.addAttribute("customers", repo.findAll());
		return "customerResults";
	}

	@GetMapping("/viewCustomer/{id}")
	public String viewCustomer(@PathVariable("id") long id, Model model) {
		Customer cust = repo.findById(id).orElse(null);
		model.addAttribute("Customer", cust);
		return "customerInfo";
	}

	@GetMapping("/viewAllAccountCards/{id}")
	public String viewAllAccountCards(@PathVariable("id") long id, Model model) {
		Customer cust = repo.findById(id).orElse(null);
		model.addAttribute("card", cust.getCard());
		model.addAttribute("id", id);
		return "cardInfo";
	}
	
	@GetMapping("/viewAllTransactions/{id}")
	public String viewAllTransactions(@PathVariable("id") long id, Model model) {
		Customer cust = repo.findById(id).orElse(null);
		model.addAttribute("Transactions", cust.getCard().getTransaction());
		model.addAttribute("id", id);
		return "transactionInfo";
	}
	
	@GetMapping("/inputTransaction/{id}")
	public String addNewTransaction(@PathVariable("id") long id, Model model) {
		Customer cust = repo.findById(id).orElse(null);
		Transaction transaction = new Transaction();
		model.addAttribute("transaction", transaction);
		model.addAttribute("id", id);
		return "transactionInput";
	}
	
	@PostMapping("/inputTransaction/{id}")
	public String addNewTransaction(@PathVariable("id") long id, @ModelAttribute Transaction transaction, Model model) {
		Customer cust = repo.findById(id).orElse(null);
		Card card = cust.getCard();
		card.setTransaction(transaction);
		cust.setCard(card);
		repo.save(cust);
		return viewAllTransactions(id, model);
	}

	@GetMapping("/inputCard/{id}")
	public String addNewCard(@PathVariable("id") long id, Model model) {
		Customer cust = repo.findById(id).orElse(null);
		Card card = new Card();
		model.addAttribute("card", card);
		model.addAttribute("customerId", cust.getId());
		return "cardInput";
	}

	@PostMapping("/inputCard/{id}")
	public String addNewCard(@PathVariable("id") long id, @ModelAttribute Card card, Model model) {
		Customer cust = repo.findById(id).orElse(null);
		cust.setCard(card);
		repo.save(cust);
		return viewAllAccountCards(cust.getId(), model);
	}

	@GetMapping("/inputCustomer")
	public String addNewCustomer(Model model) {
		Customer cust = new Customer();
		model.addAttribute("newCustomer", cust);
		return "customerInput";
	}

	@PostMapping("/inputCustomer")
	public String addNewCustomer(@ModelAttribute Customer cust, Model model) {
		Card card = new Card();
		Transaction transaction = new Transaction();
		StoreInfo storeInfo = new StoreInfo();
		transaction.setStoreInfo(storeInfo);
		card.setTransaction(transaction);
		cust.setCard(card);
		repo.save(cust);
		return viewAllCustomers(model);
	}
	
	@RequestMapping("/")	
	public String searchCustomer(Model model, @Param("keyword") String keyword)
	{
			List<Customer> listCustomers = service.listAll(keyword);
			model.addAttribute("listCustomer", listCustomers);
			model.addAttribute("keyword", keyword);		
			return "index";
	}
}
