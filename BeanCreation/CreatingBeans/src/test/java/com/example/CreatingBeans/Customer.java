package com.example.CreatingBeans;

import javax.persistence.Entity;

@Entity
public class Customer {

    private long id;
private String firstName, lastName;

Customer(long id,String firstName, String lastName){
    this.id=id;
    this.firstName=firstName;
    this.lastName=lastName;
}

@Override
    public String toString(){
    return String.format(
            "Customer ID is:"+ id + "First name is"+firstName+"Last name is"+
                    lastName
    );
    }
    public void setFirstName(String firstName){
    this.firstName=firstName;
    }
    public void setLastName(String lastName){
    this.lastName=lastName;
    }
    public String getFirstName(){
    return firstName;
    }

}
