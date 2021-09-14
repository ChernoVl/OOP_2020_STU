package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

import static java.lang.Math.abs;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private long id;
    private String name;
    private String surname;
    private String natalNumber;
    private String email;
    private Address permanentAddress;
    private Address correspondenceAddress;
    private List<Contract> contracts;

    public User(String name, String surname, String natalNumber, String email, Address permanentAddress, Address correspondenceAddress) {
        this.id = abs(UUID.randomUUID().getLeastSignificantBits());
        this.name = name;
        this.surname = surname;
        this.natalNumber = natalNumber;
        this.email = email;
        this.permanentAddress = permanentAddress;
        this.correspondenceAddress = correspondenceAddress;
    }
}
