package com.bootcamp.FrontBack.controller.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserIdResponse {
    private String name;
    private int age;
}
