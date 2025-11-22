package com.example.hcl.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hcl.transaction.enitiy.Customer;
import com.example.hcl.transaction.enitiy.Wallet;
import com.example.hcl.transaction.pojo.CustomerFullInfo;
import com.example.hcl.transaction.service.CustomerServiceimpl;

@RestController
@RequestMapping("/ewallet")
public class CustomerController {

	@Autowired
	private CustomerServiceimpl customerServiceimpl;
	
	@GetMapping("/user/get")
	public ResponseEntity<CustomerFullInfo> customerDetails(@RequestParam Integer id) {
		Customer customer = customerServiceimpl.getCustomerById(id);
	    Wallet wallet =	customerServiceimpl.getWallet(customer.getWalletId());
	    CustomerFullInfo info = new CustomerFullInfo();
		
		if (customer != null) {		   
		    info.setCustomer(customer);
		    info.setWallet(wallet);
			return new ResponseEntity<>(info, HttpStatus.OK);}
		else {
			Customer noCus = new Customer();
			noCus.setName("No customer Found");			
			Customer noWall = new Customer();
			noWall.setName("No Wallet Found");
			info.setCustomer(noCus);
		    info.setWallet(null);

		    return new ResponseEntity<>(info, HttpStatus.NO_CONTENT);
        }
	}
}
