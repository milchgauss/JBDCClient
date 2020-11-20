package com.example.CreatingBeans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter

@Configuration
@ComponentScan(basePackageClasses=Company.class)
public class Address implements Serializable {
    private @Id Long id; // ID annotation will be automatically set
    //when setting persistence data

    private String street;
    private int number;


    public Address(String street, int number){
        this.street=street;
        this.number=number;
    }

}
