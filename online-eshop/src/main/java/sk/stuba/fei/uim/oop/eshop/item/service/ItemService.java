package sk.stuba.fei.uim.oop.eshop.item.service;

import sk.stuba.fei.uim.oop.eshop.item.domain.Item;

import java.util.Optional;
import java.util.Set;

public interface ItemService {

    void addItem(Item item);

    Set<Item> findAllItems();

    Optional<Item> findItemByName(String name);
}
