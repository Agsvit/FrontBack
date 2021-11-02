package com.bootcamp.FrontBack.repository;

import com.bootcamp.FrontBack.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {


    List<Invoice> findByUser(User user);
}
