package edu.icet.mos.service;

import edu.icet.mos.dto.Item;

import java.util.List;

public interface ItemService {
    void add(String name, Double price, String image);
    List<Item> getAll();
    void delete(Integer id);
    void update(Item item, Integer id);
    List<Item> searchById(Integer id);
}
