package com.example.CreatingBeans;

import org.springframework.stereotype.Component;

@Component //Indicates that it's a bean and preparesit for autoconfiguration in Spring
public class Company {
    private Address address;
    public Company(Address address){
        this.address=address;
    }

}
