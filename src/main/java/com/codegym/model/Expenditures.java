package com.codegym.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Expenditures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String exName;
    private String exPrice;
    private String exDescription;
    private String exCategory;
    private String invoicePhoto;

    public Expenditures() {
    }

    public Expenditures(Long id, String exName, String exPrice, String exDescription, String exCategory, String invoicePhoto) {
        this.id = id;
        this.exName = exName;
        this.exPrice = exPrice;
        this.exDescription = exDescription;
        this.exCategory = exCategory;
        this.invoicePhoto = invoicePhoto;
    }

    public Expenditures(String exName, String exPrice, String exDescription, String exCategory, String invoicePhoto) {
        this.exName = exName;
        this.exPrice = exPrice;
        this.exDescription = exDescription;
        this.exCategory = exCategory;
        this.invoicePhoto = invoicePhoto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExName() {
        return exName;
    }

    public void setExName(String exName) {
        this.exName = exName;
    }

    public String getExPrice() {
        return exPrice;
    }

    public void setExPrice(String exPrice) {
        this.exPrice = exPrice;
    }

    public String getExDescription() {
        return exDescription;
    }

    public void setExDescription(String exDescription) {
        this.exDescription = exDescription;
    }

    public String getExCategory() {
        return exCategory;
    }

    public void setExCategory(String exCategory) {
        this.exCategory = exCategory;
    }

    public String getInvoicePhoto() {
        return invoicePhoto;
    }

    public void setInvoicePhoto(String invoicePhoto) {
        this.invoicePhoto = invoicePhoto;
    }
}
