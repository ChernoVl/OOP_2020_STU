package com.example.demo.controller;

import com.example.demo.domain.Contract;
import com.example.demo.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ContractController {
    //Map<Long, Contract> insurances = new HashMap<>();

    @GetMapping("/contract/create")
    public String addForm(Model model) {
        model.addAttribute("contract", new Contract());
        //System.out.println("Get Contract");
        return "contract/create";
    }

    @PostMapping("/contract/create")
    public String addSubmit(@ModelAttribute Contract contract, Model model) {
        model.addAttribute("contract", contract);
        //insurances.put(contract.getId(), contract);
        return "contract/create";
    }
}
