package edu.icet.mos.service.impl;

import edu.icet.mos.dto.Customer;
import edu.icet.mos.entity.CustomerEntity;
import edu.icet.mos.repository.CustomerRepository;
import edu.icet.mos.service.CustomerService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    final CustomerRepository repository;
    final ModelMapper mapper;

    @Override
    public void addCustomer(Customer customer) {
        repository.save(mapper.map(customer, CustomerEntity.class));
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customerList = new ArrayList<>();
        List<CustomerEntity> all = repository.findAll();
        all.forEach(entity ->customerList.add(mapper.map(entity, Customer.class)));
        return customerList;
    }

    @Override
    public void deleteCustomer(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void updateCustomer(Customer customer, Integer id) {
        Optional<CustomerEntity> cusOpt = repository.findById(id);

        if (cusOpt.isPresent()){
            CustomerEntity existCus = cusOpt.get();
            existCus.setName(customer.getName());
            existCus.setContact(customer.getContact());
            existCus.setAddress(customer.getAddress());

            repository.save(existCus);
        }else {
            throw new EntityNotFoundException("Customer with ID " + id + " not found.");
        }
    }

    @Override
    public List<Customer> searchById(Integer id) {
        List<Customer> customerList = new ArrayList<>();
        List<CustomerEntity> all = repository.findAllById(Collections.singleton(id));
        all.forEach(entity -> customerList.add(mapper.map(entity, Customer.class)));
        return customerList;
    }
}
