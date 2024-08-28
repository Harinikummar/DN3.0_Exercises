package com.example.BookstoreAPI.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Setter
@Getter
public class CustomerModel extends RepresentationModel<CustomerModel> {

    private Long id;
    private String name;
    private String email;
    private String address;

}
