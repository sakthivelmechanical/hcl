package com.example.hcl.transaction.service;


import com.example.hcl.transaction.Repository.CustomerRepository;
import com.example.hcl.transaction.Repository.SettlementRepository;
import com.example.hcl.transaction.Repository.TransactionRepository;
import com.example.hcl.transaction.Repository.WalletRepository;
import com.example.hcl.transaction.enitiy.Customer;
import com.example.hcl.transaction.enitiy.TransactionTable;
import com.example.hcl.transaction.enitiy.Wallet;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TransactionService implements Transaction{

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    SettlementRepository settlementRepository;

    @Autowired
    WalletRepository walletRepository;
    @Autowired
    CustomerRepository customerRepository;

    @Transactional
    public void placeOrder(Integer userId, Integer productId){
       Integer transactionId =  createTransaction(userId, productId);


    }



    private Integer createTransaction(Integer userId, Integer productId){
        TransactionTable transactionTable = new TransactionTable();
        transactionTable.setProductId(productId);
        transactionTable.setUserId(userId);
        transactionTable.setTransactionType("DEBIT");
        transactionTable.setDate(LocalDateTime.now());
        transactionRepository.save(transactionTable);
        return transactionTable.getId();
    }

    private void updateWallet(Integer userId, Integer amount){
       Customer customer =  customerRepository.findById(userId);
       Optional<Wallet> walletOptional =  walletRepository.findByIdForUpdate(customer.getWalletId());
       if(walletOptional.isPresent()) {
           Wallet wallet = walletOptional.get();
           long l = wallet.getBalance() - amount.longValue();
           wallet.setBalance(l);
           walletRepository.save(wallet);
       }
    }

    private void settlement(){


    }


}
