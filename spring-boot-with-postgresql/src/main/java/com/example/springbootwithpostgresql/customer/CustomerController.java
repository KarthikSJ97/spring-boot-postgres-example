package com.example.springbootwithpostgresql.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer")
    public Iterable<CustomerEntity> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping("/customer")
    public CustomerEntity addCustomer(@RequestBody CustomerEntity customer) {
        return customerService.addCustomer(customer);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Object> getCustomerById(@PathVariable("id") long id) {
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    @DeleteMapping("/customer/{id}")
    @ResponseStatus(reason = "user deleted", code = HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("id") long id) {
        customerService.deleteCustomer(id);
    }

}
