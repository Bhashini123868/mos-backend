package edu.icet.mos.service.impl;

import edu.icet.mos.dto.Item;
import edu.icet.mos.service.ItemService;

import java.util.List;

public class ItemServiceImpl implements ItemService {
    @Override
    public void add(String name, Double price, String image) {

    }

    @Override
    public List<Item> getAll() {
        return List.of();
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(Item item, Integer id) {

    }

    @Override
    public List<Item> searchById(Integer id) {
        return List.of();
    }
}
