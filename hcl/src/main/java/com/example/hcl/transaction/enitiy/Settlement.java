package com.example.hcl.transaction.enitiy;


import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "settlement")
public class Settlement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "transaction_id", nullable = false)
    private Integer transactionId;

    @Column(name = "customer_id", nullable = false)
    private Integer customerId;

    @Column(name = "merchant_id", nullable = false)
    private Integer merchantId;


    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "amount", nullable = false, precision = 15, scale = 2)
    private BigDecimal amount;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    // Constructors
    public Settlement() {
    }

    public Settlement(Integer transactionId, Integer customerId, Integer userId,
                      BigDecimal amount, String status) {
        this.transactionId = transactionId;
        this.customerId = customerId;
        this.userId = userId;
        this.amount = amount;
        this.status = status;
    }

    // Getters & Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }
}
