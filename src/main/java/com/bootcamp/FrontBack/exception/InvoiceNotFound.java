package com.bootcamp.FrontBack.exception;

public class InvoiceNotFound extends RuntimeException {

    public InvoiceNotFound() {
        super("Invoice not found");     }


    public InvoiceNotFound(String message) {
        super(message);
    }
}

