package com.example.hcl.transaction.enitiy;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transaction_record")
public class TransactionTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "product_id", nullable = false)
    private Integer productId;

    @Column(name = "debit_wallet_id")
    private Integer debitWalletId;

    @Column(name = "credit_wallet_id")
    private Integer creditWalletId;

    @Column(name = "transaction_type", nullable = false, length = 50)
    private String transactionType;

    @Column(name = "amount")
    private Integer anount;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    // Constructors
    public TransactionTable() {
    }

    public TransactionTable(Integer userId, Integer productId, String transactionType, LocalDateTime date) {
        this.productId = productId;
        this.transactionType = transactionType;
        this.date = date;
    }

    // Getters & Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Integer getDebitWalletId() {
        return debitWalletId;
    }

    public void setDebitWalletId(Integer debitWalletId) {
        this.debitWalletId = debitWalletId;
    }

    public Integer getCreditWalletId() {
        return creditWalletId;
    }

    public void setCreditWalletId(Integer creditWalletId) {
        this.creditWalletId = creditWalletId;
    }

    public Integer getAnount() {
        return anount;
    }

    public void setAnount(Integer anount) {
        this.anount = anount;
    }
}