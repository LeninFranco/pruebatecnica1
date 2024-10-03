package com.leninfranco.pruebatecnica1.classes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressClass {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;
}
