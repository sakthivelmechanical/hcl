package com.example.hcl.transaction.service;

public interface Transaction {


     Integer placeOrder(Integer userId, Integer productId) ;
     Integer createTransaction(Integer userId, Integer productId);
     void updateWallet(Integer userId, Integer amount);
     void settlement(int transactionId, Integer userId, Integer merchantId, Long amount );
}
