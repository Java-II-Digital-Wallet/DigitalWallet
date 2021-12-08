/**
 * @author Caleb - cawasle
CIS175 - Fall 2021
Dec 7, 2021
 */
package wallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wallet.beans.Customer;
import wallet.repository.CustomerRepository;

/**
 * @author Caleb
 *
 */

@Service
public class SearchService {

	@Autowired
	CustomerRepository repo;
	
	public List<Customer> listAll(String keyword)
	{	
			if(keyword != null)
			{
				System.out.println("********* The Search Worked ***********");
				System.out.println(keyword);
				System.out.println(repo.search(keyword));
				System.out.println("End of repo.search(keyword)");
				System.out.println("***************************************");
				return repo.search(keyword);
			}
			//return repo.findAll();
			return null;
	}
	
}
