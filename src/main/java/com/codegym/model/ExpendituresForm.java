package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class ExpendituresForm {
    private Long id;
    private String exName;
    private String exPrice;
    private String exDescription;
    private String exCategory;
    private MultipartFile invoicePhoto;

    public ExpendituresForm() {
    }

    public ExpendituresForm(Long id, String exName, String exPrice, String exDescription, String exCategory, MultipartFile invoicePhoto) {
        this.id = id;
        this.exName = exName;
        this.exPrice = exPrice;
        this.exDescription = exDescription;
        this.exCategory = exCategory;
        this.invoicePhoto = invoicePhoto;
    }

    public ExpendituresForm(String exName, String exPrice, String exDescription, String exCategory, MultipartFile invoicePhoto) {
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

    public MultipartFile getInvoicePhoto() {
        return invoicePhoto;
    }

    public void setInvoicePhoto(MultipartFile invoicePhoto) {
        this.invoicePhoto = invoicePhoto;
    }
}
