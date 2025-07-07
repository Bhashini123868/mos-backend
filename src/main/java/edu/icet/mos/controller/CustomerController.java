package edu.icet.mos.controller;

import edu.icet.mos.dto.Customer;
import edu.icet.mos.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/mos/customer")
@RestController
@CrossOrigin
public class CustomerController {
    final CustomerService service;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomer(@Valid @RequestBody Customer customer) {
        service.addCustomer(customer);
    }

    @PutMapping("/update/{id}")
    public void updateCustomer(@Valid @RequestBody Customer customer, @PathVariable Integer id) {
        service.updateCustomer(customer, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable Integer id) {
        service.deleteCustomer(id);
    }

    @GetMapping("/get-all")
    public List<Customer> getAll() {
        return service.getAll();
    }

    @GetMapping("/search-by-id/{id}")
    public List<Customer> searchById(@PathVariable Integer id) {
        return service.searchById(id);
    }
}
