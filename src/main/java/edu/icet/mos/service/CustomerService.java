package edu.icet.mos.service;

import edu.icet.mos.dto.Customer;

import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);
    List<Customer> getAll();
    void deleteCustomer(Integer id);
    void updateCustomer(Customer customer, Integer id);
    List<Customer> searchById(Integer id);
}
