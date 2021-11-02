package com.bootcamp.FrontBack.controller.request;

import com.bootcamp.FrontBack.model.Invoice;
import com.bootcamp.FrontBack.model.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceRequest {
    private Long userId;
    private List<Long> productIds;

    @JsonIgnore
    public Invoice createInvoice(User user, List<Product> products) {
        return Invoice.builder()
                .user(user)
                .productList(products)
                .build();
    }
}
