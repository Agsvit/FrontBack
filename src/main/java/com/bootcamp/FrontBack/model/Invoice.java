package com.bootcamp.FrontBack.model;

import com.bootcamp.FrontBack.controller.response.InvoiceResponse;
import com.bootcamp.FrontBack.controller.response.ProductResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private double number;
    private float total;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "productInvoice",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "invoice_id"))
    private List<Product> productList;

    @JsonIgnore
    public InvoiceResponse invoiceResponse() {
        List<ProductResponse> productResponses = new ArrayList<ProductResponse>();
        if (this.productList != null && !this.productList.isEmpty()) {
            for (Product product : this.productList) {
                productResponses.add(new ProductResponse(
                        product.getId(),
                        product.getName(),
                        product.getValue()
                ));
            }
        }
        return new InvoiceResponse(
                this.getId(),
                this.getNumber(),
                productResponses,
                this.getTotal(),
                this.getUser().getUsername());
    }
}

