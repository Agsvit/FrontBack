package com.bootcamp.FrontBack.repository;

import com.bootcamp.FrontBack.model.Invoice;
import com.bootcamp.FrontBack.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    List<Invoice> findByUser(User user);
}
