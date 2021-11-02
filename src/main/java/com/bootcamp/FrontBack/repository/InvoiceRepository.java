package com.bootcamp.FrontBack.repository;

import com.bootcamp.FrontBack.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
