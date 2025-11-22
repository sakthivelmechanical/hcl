package com.example.hcl.transaction.service;


import com.example.hcl.transaction.Exception.InValidCurrencyException;
import com.example.hcl.transaction.Exception.InsufficientFundsException;
import com.example.hcl.transaction.Repository.*;
import com.example.hcl.transaction.enitiy.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TransactionService implements Transaction {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    SettlementRepository settlementRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    WalletRepository walletRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    MerchantRepository merchantRepository;

    @Transactional
    public Integer placeOrder(Integer userId, Integer productId) {
        checkFundAvailability(userId, productId);
        checkCurrencyValidation(userId, productId);
        Product product = productRepository.findById(productId);

        Integer transactionId = createTransaction(userId, productId, product.getProductCost());
        updateWallet(userId, product.getProductCost().intValue());
        settlement(transactionId, userId, product.getMerchantId(), product.getProductCost());
        return transactionId;
    }


    public Integer createTransaction(Integer userId, Integer productId, Long amount) {
        TransactionTable transactionTable = new TransactionTable();
        transactionTable.setProductId(productId);
        transactionTable.setTransactionType("DEBIT");
        transactionTable.setAnount(amount.intValue());
        transactionTable.setDate(LocalDateTime.now());
        transactionRepository.save(transactionTable);
        return transactionTable.getId();
    }

    public void updateWallet(Integer userId, Integer amount) {
        Customer customer = customerRepository.findById(userId);
        Optional<Wallet> walletOptional = walletRepository.findByIdForUpdateNative(customer.getWalletId());
        if (walletOptional.isPresent()) {
            Wallet wallet = walletOptional.get();
            long l = wallet.getBalance() - amount.longValue();
            wallet.setBalance(l);
            walletRepository.save(wallet);
        }
    }

    public void settlement(int transactionId, Integer userId, Integer merchantId, Long amount) {
        Settlement settlement = new Settlement();
        settlement.setTransactionId(transactionId);
        settlement.setAmount(amount);
        settlement.setCustomerId(userId);
        settlement.setMerchantId(merchantId);
        settlement.setStatus("HOLD");
        settlement.setDate(LocalDateTime.now());
        settlementRepository.save(settlement);
    }

    public void checkFundAvailability(Integer userId, Integer projectId) {
        Customer customer = customerRepository.findById(userId);
        Optional<Wallet> walletOptional = walletRepository.findByIdForUpdateNative(customer.getWalletId());
        if (walletOptional.isPresent()) {
            Wallet wallet = walletOptional.get();
            Product product = productRepository.findById(projectId);
            if (wallet.getBalance() < product.getProductCost()) {
                throw new InsufficientFundsException("InsufficientFunds");
            }
        }
    }


    public void checkCurrencyValidation(Integer userId, Integer projectId) {
        Customer customer = customerRepository.findById(userId);
        Optional<Wallet> walletOptional = walletRepository.findByIdForUpdateNative(customer.getWalletId());
        if (walletOptional.isPresent()) {
            Wallet wallet = walletOptional.get();
            Product product = productRepository.findById(projectId);
            Merchant merchant = merchantRepository.findById(product.getMerchantId());
            Optional<Wallet> walletMerchantOptional = walletRepository.findByIdForUpdateNative(merchant.getWalletId());
            Wallet wallet1 = walletMerchantOptional.get();
            if (!wallet.getCurrencyType().equalsIgnoreCase(wallet1.getCurrencyType())) {
                throw new InValidCurrencyException("InsufficientFunds");
            }
        }
    }

}
