package com.example.springbootwithpostgresql.customer;

import com.example.springbootwithpostgresql.commons.CustomNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Iterable<CustomerEntity> getAllCustomers() {
        return customerRepository.findAll();
    }

    public CustomerEntity addCustomer(CustomerEntity customer) {
        return customerRepository.save(customer);
    }

    public Optional<CustomerEntity> getCustomerById(long id) {
        return Optional.ofNullable(customerRepository.findById(id)
                .orElseThrow(() -> new CustomNotFoundException("customer details not found")));
    }

    public void deleteCustomer(long id) {
        try {
            customerRepository.deleteById(id);
        } catch(EmptyResultDataAccessException e) {
            throw new CustomNotFoundException("customer with id: "+id+" does not exist");
        }

    }
}
