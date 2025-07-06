package edu.icet.mos.service.impl;

import edu.icet.mos.dto.Order;
import edu.icet.mos.entity.OrderDetailsEntity;
import edu.icet.mos.entity.OrderEntity;
import edu.icet.mos.repository.OrderDetailsRepository;
import edu.icet.mos.repository.OrderRepository;
import edu.icet.mos.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    final OrderRepository repository;
    final OrderDetailsRepository orderDetailRepository;
    final ModelMapper mapper;

    @Override
    public void add(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setDate(order.getDate());
        orderEntity.setCusID(order.getCusID());
        orderEntity.setTotal(order.getTotal());

        OrderEntity savedOrder = repository.save(orderEntity);

        if (order.getOrderDetail() != null) {
            List<OrderDetailsEntity> orderDetail = order.getOrderDetail().stream().map(item -> {
                OrderDetailsEntity orderDetailEntity = new OrderDetailsEntity();
                orderDetailEntity.setOrder(savedOrder);
                orderDetailEntity.setItemID(mapper.map(item.getItemID(), Integer.class));
                orderDetailEntity.setQty(item.getQty());
                orderDetailEntity.setUnitPrice(item.getUnitPrice());
                return orderDetailEntity;
            }).collect(Collectors.toList());

            orderDetailRepository.saveAll(orderDetail);
            savedOrder.setOrderDetail(orderDetail);
        }
    }

    @Override
    public List<Order> getAll() {
        List<OrderEntity> orderEntities = repository.findAll();
        List<Order> orderList = new ArrayList<>();
        orderEntities.forEach(el -> orderList.add(mapper.map(el, Order.class)) );
        return orderList;
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Order order) {
        repository.save(mapper.map(order, OrderEntity.class));
    }

    @Override
    public Order searchById(Integer id) {
        return mapper.map(repository.findById(id), Order.class);
    }

    @Override
    public List<Order> getAllBYId(Integer id) {
        List<OrderEntity> orderEntities = repository.findAllById(Collections.singleton(id));
        List<Order> orderList = new ArrayList<>();
        orderEntities.forEach(el -> orderList.add(mapper.map(el, Order.class)));
        return orderList;
    }
}
