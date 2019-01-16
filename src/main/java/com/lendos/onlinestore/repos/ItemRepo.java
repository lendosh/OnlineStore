package com.lendos.onlinestore.repos;

import com.lendos.onlinestore.domain.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepo extends CrudRepository<Item, Long> {

    List<Item> findByItemName(String itemName);

    Optional<Item> findById(Long itemId);

}
