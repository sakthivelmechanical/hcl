package com.example.hcl.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hcl.transaction.Repository.CustomerRepository;
import com.example.hcl.transaction.Repository.WalletRepository;
import com.example.hcl.transaction.enitiy.Customer;
import com.example.hcl.transaction.enitiy.Wallet;

import jakarta.transaction.Transactional;

@Service
public class CustomerServiceimpl {
	
	 @Autowired
	 CustomerRepository customerRepository;
	 
	 @Autowired
	 WalletRepository walletRepo;

	 @Transactional
	public Customer getCustomerById(int custId) {
		return customerRepository.findById(custId);
		
	}
	 @Transactional
	public Wallet getWallet(int walletid) {
		
	Wallet wallet = 	walletRepo.findByIdForUpdateNative(walletid).get();
  		return wallet;
	}
	
}
