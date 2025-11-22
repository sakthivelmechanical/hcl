package com.example.hcl.transaction.enitiy;


import jakarta.persistence.*;

@Entity
@Table(name = "product_table")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_name", nullable = false, length = 150)
    private String productName;

    @Column(name = "product_cost", nullable = false, precision = 15, scale = 2)
    private Long productCost;

    @Column(name = "merchant_id", nullable = false)
    private Integer merchantId;

    //@Enumerated(EnumType.STRING)
    @Column(name = "currency_type", nullable = false, length = 10)
    private String currencyType;

    // Constructors
    public Product() {}

    public Product(String productName, Long productCost, Integer merchantId, String currencyType) {
        this.productName = productName;
        this.productCost = productCost;
        this.merchantId = merchantId;
        this.currencyType = currencyType;
    }

    // Getters & Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getProductCost() {
        return productCost;
    }

    public void setProductCost(Long productCost) {
        this.productCost = productCost;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }
}

