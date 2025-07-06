package edu.icet.mos.service;

import edu.icet.mos.dto.Order;

import java.util.List;

public interface OrderService {
    void add(Order order);
    List<Order> getAll();
    void delete(Integer id);
    void update(Order order);
    Order searchById(Integer id);
    List<Order> getAllBYId(Integer id);
}
