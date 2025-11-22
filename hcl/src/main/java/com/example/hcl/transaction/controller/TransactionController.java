package com.example.hcl.transaction.controller;

import com.example.hcl.transaction.pojo.BuyProduct;
import com.example.hcl.transaction.service.Transaction;
import com.example.hcl.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ewallet")
public class TransactionController {

    @Autowired
    Transaction transaction;


   @PostMapping("/transaction")
   public ResponseEntity<Integer> buyProduct(@RequestBody BuyProduct buyProduct){
      Integer transactionId =  transaction.placeOrder(buyProduct.getUserId(), buyProduct.getProductId());
       return new ResponseEntity<>(transactionId, HttpStatus.OK);
   }



}
