package com.example.hcl.transaction.enitiy;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "wallet_fee_records")
public class WalletFeeRecords {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, precision = 15, scale = 2)
    private Long amount;

    @Column(name = "merchant_id", nullable = false, length = 10)
    private int merchantId;
    
    @Column(name = "date", nullable = false)
    private LocalDateTime date;
    
    public WalletFeeRecords() {}

    public WalletFeeRecords(Long amount, int merchantId, LocalDateTime date) {
        this.amount = amount;
        this.merchantId = merchantId;
        this.date = date;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
