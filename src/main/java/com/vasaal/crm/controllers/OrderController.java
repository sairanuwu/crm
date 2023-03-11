package com.vasaal.crm.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vasaal.crm.entities.Customer;
import com.vasaal.crm.entities.Customer;
import com.vasaal.crm.repository.CustomerRepository;

@Controller
@RequestMapping(path = "/order")
public class OrderController {
    @Autowired
    private CustomerRepository orderRepository;

    // LISTER COMMANDE
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Customer> getAllOrders() {

        return orderRepository.findAll();
    }

    // AJOUTER COMMANDE
    @PostMapping(path = "/add")
    public @ResponseBody String addNewOrder(@RequestParam String name, @RequestParam String surname,
            @RequestParam String address, @RequestParam String email, @RequestParam String phone_number) {

        Customer n = new Customer();
        n.setSurname(surname);
        n.setName(name);
        n.setAddress(address);
        n.setEmail(email);
        n.setPhoneNumber(phone_number);
        orderRepository.save(n);
        return "Order added";
    }

}
