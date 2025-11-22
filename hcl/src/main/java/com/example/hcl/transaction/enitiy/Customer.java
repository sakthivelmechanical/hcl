package com.example.hcl.transaction.enitiy;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "phone_number", nullable = false, length = 15)
    private String phoneNumber;

    @Column(name = "email_id", nullable = false, length = 100)
    private String emailId;

    @Column(nullable = false, length = 200)
    private String location;

    @Column(name = "wallet_id", nullable = false)
    private Long walletId;  // <-- No relation, simple FK value

    // Constructors
    public Customer() {}

    public Customer(String name, String phoneNumber, String emailId, String location, Long walletId) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.location = location;
        this.walletId = walletId;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getWalletId() {
        return walletId;
    }

    public void setWalletId(Long walletId) {
        this.walletId = walletId;
    }
}

