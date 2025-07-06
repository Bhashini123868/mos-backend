package edu.icet.mos.service.impl;

import edu.icet.mos.dto.Item;
import edu.icet.mos.entity.ItemEntity;
import edu.icet.mos.repository.ItemRepository;
import edu.icet.mos.service.ItemService;
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
public class ItemServiceImpl implements ItemService {

    final ItemRepository repository;
    final ModelMapper mapper;

    @Override
    public void add(String name, Double price, String image) {
        ItemEntity item = new ItemEntity();
        item.setName(name);
        item.setPrice(price);
        item.setImage(image);

        repository.save(item);
    }

    @Override
    public List<Item> getAll() {
        List<Item> itemList = new ArrayList<>();
        List<ItemEntity> all = repository.findAll();
        all.forEach(entity -> itemList.add(mapper.map(entity, Item.class)));

        return itemList;
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Item item, Integer id) {
        Optional<ItemEntity> sOpt = repository.findById(id);

        if (sOpt.isPresent()){
            ItemEntity existCus = sOpt.get();
            existCus.setName(item.getName());
            existCus.setPrice(item.getPrice());
            existCus.setImage(item.getImage());

            repository.save(existCus);
        } else {
            throw new EntityNotFoundException("Customer with ID " + id + " not found.");
        }
    }

    @Override
    public List<Item> searchById(Integer id) {
        List<Item> itemList = new ArrayList<>();
        List<ItemEntity> entityList = repository.findAllById(Collections.singleton(id));
        entityList.forEach(entity -> itemList.add(mapper.map(entity, Item.class)));
        return itemList;
    }
}
