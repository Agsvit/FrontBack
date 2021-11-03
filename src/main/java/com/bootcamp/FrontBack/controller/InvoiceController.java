package com.bootcamp.FrontBack.controller;

import com.bootcamp.FrontBack.controller.request.InvoiceRequest;
import com.bootcamp.FrontBack.controller.request.ProductRequest;
import com.bootcamp.FrontBack.controller.response.InvoiceResponse;
import com.bootcamp.FrontBack.model.Invoice;
import com.bootcamp.FrontBack.service.InvoiceService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/invoices/users/{id}")
    @ApiOperation(value = "Get invoice by user id",
            authorizations = { @Authorization(value="basicAuth") })
    public List<InvoiceResponse> getAllInvoices(@PathVariable(value = "id") Long id) {
        return this.invoiceResponses(invoiceService.findByUser(id));
    }

    @GetMapping("/invoices/{id}")
    @ApiOperation(value = "Get invoice by id",
            authorizations = { @Authorization(value="basicAuth") })
    public InvoiceResponse getInvoiceById(@PathVariable(value = "id") Long id) {
        return invoiceService.findById(id).invoiceResponse();
    }

    @PostMapping(value = "/invoices/products/")
    @ApiOperation(value = "Create invoice",
            authorizations = { @Authorization(value="basicAuth") })
    public InvoiceResponse createInvoice(@RequestBody InvoiceRequest invoiceRequest) {
        return invoiceService.newInvoice(invoiceRequest.getProductIds(),invoiceRequest.getUserId()).invoiceResponse();
    }

}
