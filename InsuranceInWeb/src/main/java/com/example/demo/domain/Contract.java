package com.example.demo.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
public class Contract {
    private long id;
    private LocalDate created;
    private User user;
    private LocalDate beginOfInsurance;
    private LocalDate endOfInsurance;
    private double insuranceAmount;
    private double monthlyPayment;
}
