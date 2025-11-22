package com.example.hcl.transaction.enitiy;


import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "wallet")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, precision = 15, scale = 2)
    private Long balance;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency_type", nullable = false, length = 10)
    private String currencyType;

    // Constructors
    public Wallet() {}

    public Wallet(Long balance, String currencyType) {
        this.balance = balance;
        this.currencyType = currencyType;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }
}
