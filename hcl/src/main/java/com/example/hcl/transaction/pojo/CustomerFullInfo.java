package com.example.hcl.transaction.pojo;

import com.example.hcl.transaction.enitiy.Customer;
import com.example.hcl.transaction.enitiy.Wallet;

public class CustomerFullInfo {

	Customer customer;
	
	Wallet wallet;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	
	
	
}
