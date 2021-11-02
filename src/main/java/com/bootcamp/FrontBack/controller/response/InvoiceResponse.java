package com.bootcamp.FrontBack.controller.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceResponse {
    private Long id;
    private double number;
    private float total;

    private List<ProductResponse> productResponses;

}
