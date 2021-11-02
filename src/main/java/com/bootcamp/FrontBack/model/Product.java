package com.bootcamp.FrontBack.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private float value;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

}
