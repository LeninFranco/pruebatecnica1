package com.leninfranco.pruebatecnica1.classes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    private AddressClass address;
    private String phone;
    private String website;
    private Company company;
}
