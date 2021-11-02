package com.bootcamp.FrontBack.controller;

import com.bootcamp.FrontBack.controller.response.InvoiceResponse;
import com.bootcamp.FrontBack.model.Invoice;
import com.bootcamp.FrontBack.service.InvoiceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    public List<InvoiceResponse> invoiceResponses(List<Invoice> invoices) {
        List<InvoiceResponse> invoiceResponses = new ArrayList<>();
        for (Invoice invoice : invoices) {
            invoiceResponses.add(invoice.invoiceResponse());
        }
        return invoiceResponses;
    }

    @GetMapping("/planes")
    public List<InvoiceResponse> getInvoices() {
        return this.invoiceResponses(invoiceService.findAll());
    }

}
