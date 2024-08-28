package com.example.BookstoreAPI.assembler;

import com.example.BookstoreAPI.controller.CustomerController;
import com.example.BookstoreAPI.model.Customer;
import com.example.BookstoreAPI.model.CustomerModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class CustomerModelAssembler extends RepresentationModelAssemblerSupport<Customer, CustomerModel> {

    public CustomerModelAssembler() {
        super(CustomerController.class, CustomerModel.class);
    }

    @Override
    public CustomerModel toModel(Customer customer) {
        CustomerModel customerModel = new CustomerModel();
        customerModel.setId(customer.getId());
        customerModel.setName(customer.getName());
        customerModel.setEmail(customer.getEmail());
        customerModel.setAddress(customer.getAddress());
        
        customerModel.add(linkTo(methodOn(CustomerController.class).getCustomerById(customer.getId())).withSelfRel());

        customerModel.add(linkTo(methodOn(CustomerController.class).getCustomers()).withRel("customers"));

        return customerModel;
    }
}

