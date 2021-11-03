package com.bootcamp.FrontBack.controller.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateUserRequest {
    private String userName;
    private int age;
    private String password;


}
