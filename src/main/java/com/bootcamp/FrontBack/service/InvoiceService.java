package com.bootcamp.FrontBack.service;

import com.bootcamp.FrontBack.model.Invoice;
import com.bootcamp.FrontBack.model.Product;
import com.bootcamp.FrontBack.model.User;
import com.bootcamp.FrontBack.repository.InvoiceRepository;
import com.bootcamp.FrontBack.repository.ProductRepository;
import com.bootcamp.FrontBack.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public InvoiceService(InvoiceRepository invoiceRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.invoiceRepository = invoiceRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }


    public List<Invoice> findByUser(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return user.getInvoiceList();
    }

    //ADD EXCEPTION
    public Invoice findById(Long id) {
        return invoiceRepository.findById(id).orElseThrow();
    }

    public Invoice newInvoice(List<Long> productIds, Long userId) {
        List<Product> productList = new ArrayList<>();
        float total = 0;
        for (Long id : productIds) {
            Product product = productRepository.findById(id).orElseThrow();
            productList.add(product);
            total = total + product.getValue();
        }
        User user = userRepository.findById(userId).orElseThrow();
        Invoice invoice = Invoice.builder()
                .total(total)
                .productList(productList)
                .user(user)
                .build();
        return invoiceRepository.save(invoice);

    }
}
