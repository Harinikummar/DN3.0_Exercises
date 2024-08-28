package com.example.BookstoreAPI.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 100)
    private String name;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min = 10, max = 200)
    private String address;

    @Version
    private int version;

    public Customer(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;

    }
}



