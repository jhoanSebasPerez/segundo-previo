package com.perez.simpledemo.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {

    private Integer id;

    private String username;

    private String email;

    private String pass;

}
