package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.assembler.CustomerModelAssembler;
import com.example.BookstoreAPI.model.Customer;
import com.example.BookstoreAPI.model.CustomerModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private List<Customer> customerList = new ArrayList<>();

    @Autowired
    private CustomerModelAssembler assembler;

    @GetMapping
    public CollectionModel<CustomerModel> getCustomers() {
        List<CustomerModel> customers = new ArrayList<>();
        for (Customer customer : customerList) {
            customers.add(assembler.toModel(customer));
        }

        return CollectionModel.of(customers,
                linkTo(methodOn(CustomerController.class).getCustomers()).withSelfRel());
    }

    // GET a customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<CustomerModel> getCustomerById(@PathVariable Long id) {
        Optional<Customer> customer = customerList.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();

        return customer.map(value -> ResponseEntity.ok(assembler.toModel(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST a new customer
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) {
        customer.setId((long) (customerList.size() + 1));
        customerList.add(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    // PUT (update) an existing customer
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @Valid @RequestBody Customer updatedCustomer) {
        Optional<Customer> customerOptional = customerList.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();

        if (customerOptional.isPresent()) {
            Customer existingCustomer = customerOptional.get();
            existingCustomer.setName(updatedCustomer.getName());
            existingCustomer.setEmail(updatedCustomer.getEmail());
            // Update other fields as needed
            return ResponseEntity.ok(existingCustomer);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // DELETE a customer by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        boolean removed = customerList.removeIf(customer -> customer.getId().equals(id));
        if (removed) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}



