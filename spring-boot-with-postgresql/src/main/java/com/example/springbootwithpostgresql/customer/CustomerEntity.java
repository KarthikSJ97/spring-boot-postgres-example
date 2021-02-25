package com.example.springbootwithpostgresql.customer;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="customer")
@Getter
@Setter
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
}
