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
		model.addAttribute("Customer", cust);
		return "cardInfo";
	}

	@GetMapping("/inputCard/{id}")
	public String addNewCard(@PathVariable("id") long id, Model model) {
		Customer cust = repo.findById(id).orElse(null);
		Card card = new Card();
		cust.addCard(card);
		model.addAttribute("newCard", card);
		return "cardInput";
	}

	@PostMapping("/inputCard")
	public String addNewCard(@ModelAttribute Customer cust, @ModelAttribute Card card, Model model) {
		cust.addCard(card);
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
