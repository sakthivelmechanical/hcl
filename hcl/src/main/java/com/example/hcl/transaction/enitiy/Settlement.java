package com.example.hcl.transaction.enitiy;


import jakarta.persistence.*;
import java.time.LocalDateTime;

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



    @Column(name = "amount", nullable = false, precision = 15, scale = 2)
    private Long amount;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    // Constructors
    public Settlement() {
    }

    public Settlement(Integer transactionId, Integer customerId,
                      Long amount, String status) {
        this.transactionId = transactionId;
        this.customerId = customerId;
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



    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
