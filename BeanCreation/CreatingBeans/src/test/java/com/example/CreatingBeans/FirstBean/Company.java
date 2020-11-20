package com.example.CreatingBeans.FirstBean;

import com.example.CreatingBeans.FirstBean.Address;

import javax.persistence.Entity;



@Entity
public class Company {
    private com.example.CreatingBeans.FirstBean.Address address;
     public Company (Address address)
     {
         this.address=address;
     }
}
