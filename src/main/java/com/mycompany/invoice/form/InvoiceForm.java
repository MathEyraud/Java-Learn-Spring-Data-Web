package com.mycompany.invoice.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class InvoiceForm {

    /**
     * ATTRIBUTS
     */
    private String number;

    @NotEmpty(message = "Customer name is required !")
    @Size(min = 3, max = 50, message = "Customer name must be between 3 and 50 characters !")
    private String customerName;

    //@Pattern(regexp = "^\\d{3}-\\d{3}-\\d{4}$", message = "Order number must follow the pattern XXX-XXX-XXXX")
    private String orderNumber;

    /**
     * GETTERS/SETTERS
     */
    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOrderNumber() {
        return this.orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}