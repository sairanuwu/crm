package com.vasaal.crm.controllers;

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
import com.vasaal.crm.repository.CustomerRepository;

@Controller
@RequestMapping(path = "/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    // LISTER CLIENT
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Customer> getAllCustomers() {

        return customerRepository.findAll();
    }

    // AJOUTER CLIENT
    @PostMapping(path = "/add")
    public @ResponseBody String addNewCustomer(@RequestParam String name, @RequestParam String surname,
            @RequestParam String address, @RequestParam String email, @RequestParam String phone_number) {

        Customer n = new Customer();
        n.setSurname(surname);
        n.setName(name);
        n.setAddress(address);
        n.setEmail(email);
        n.setPhoneNumber(phone_number);
        customerRepository.save(n);
        return "Customer added";
    }

    // SUPPRIMER UN CLIENT
    @DeleteMapping(path = "/delete")
    public @ResponseBody String deleteCustomer(@RequestParam long id) {

        customerRepository.deleteById(id);
        return "Customer deleted";
    }

    // MODIFIER UN CLIENT
    @PutMapping(path = "/update")
    public @ResponseBody String updateCustomer(@RequestParam long id, @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String address, @RequestParam String email, @RequestParam String phone_number) {
        Customer customer = customerRepository.findById(id).orElseThrow();

        customer.setSurname(surname);
        customer.setName(name);
        customer.setAddress(address);
        customer.setEmail(email);
        customer.setPhoneNumber(phone_number);
        return "Customer updated";

    }
}
