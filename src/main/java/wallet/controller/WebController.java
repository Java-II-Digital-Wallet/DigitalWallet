package wallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import wallet.beans.Customer;
import wallet.repository.CustomerRepository;

/**
 * @author Thomas Syvertsen - tjsyvertsen CIS175 - Fall 2021 Nov 17, 2021
 */

@Controller
public class WebController {
	@Autowired
	CustomerRepository repo;

	@GetMapping("/viewAllCustomers")
	public String viewAllCustomers(Model model) {
		model.addAttribute("customers", repo.findAll());
		return "customerResults";
	}
	
	@GetMapping("/viewCustomer/{id}")
	public String viewCustomer(@PathVariable("id") long id, Model model) {
		Customer c = repo.findById(id).orElse(null);
		model.addAttribute("Customer", c);
		return "customerInfo";
	}

	@GetMapping("/inputCustomer")
	public String addNewCustomer(Model model) {
		Customer c = new Customer();
		model.addAttribute("newCustomer", c);
		return "customerInput";
	}

	@PostMapping("/inputCustomer")
	public String addNewCustomer(@ModelAttribute Customer c, Model model) {
		repo.save(c);
		return viewAllCustomers(model);
	}

}
