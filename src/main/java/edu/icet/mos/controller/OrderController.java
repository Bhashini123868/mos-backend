package edu.icet.mos.controller;

import edu.icet.mos.dto.Order;
import edu.icet.mos.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mos/order")
@CrossOrigin
@RequiredArgsConstructor
public class OrderController {
    final OrderService service;

    @PostMapping("/add")
    public void addOrder(@Valid @RequestBody Order order) {
        System.out.println(order);
        service.add(order);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable Integer id) {
        service.delete(id);
    }

    @GetMapping("/get-all")
    List<Order> getAll() {
        return service.getAll();
    }

    @GetMapping("/getAllByID")
    Order searchByID(@RequestParam(value = "id") Integer id) {
        return service.searchById(id);
    }

    @PutMapping("/update")
    public void update(@Valid @RequestBody Order order) {
        service.update(order);
    }

    @GetMapping("/get-all-byID/{id}")
    List<Order> getAllBYId(@PathVariable Integer id) {
        return service.getAllBYId(id);
    }

}
