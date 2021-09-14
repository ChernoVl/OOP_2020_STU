package sk.stuba.fei.uim.oop.eshop.item.service;

import sk.stuba.fei.uim.oop.eshop.item.domain.Category;
import sk.stuba.fei.uim.oop.eshop.item.domain.Item;
import sk.stuba.fei.uim.oop.eshop.item.domain.Manufacturer;
import sk.stuba.fei.uim.oop.eshop.item.service.comparator.ItemComparator;
import sk.stuba.fei.uim.oop.eshop.item.service.comparator.ManufacturerComparator;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

public class BasicItemService implements CategoryService, ManufacturerService, ItemService {

    private Set<Item> items;
    private Set<Manufacturer> manufacturers;
    private Category rootCategory;

    public BasicItemService(String rootCategoryName) {
        items = new TreeSet<>(ItemComparator.getInstance());
        manufacturers = new TreeSet<>(ManufacturerComparator.getInstance());
        rootCategory = new Category(rootCategoryName);
    }

    public Category getRootCategory() {
        return rootCategory;
    }

    @Override
    public Set<Item> findAllItems() {
        return items;
    }

    @Override
    public Optional<Item> findItemByName(String name) {
        return items.stream()
                .filter(item -> item.getName().equals(name))
                .findFirst();
    }

    @Override
    public void addManufacturer(Manufacturer manufacturer) {
        manufacturers.add(manufacturer);
    }

    @Override
    public Set<Manufacturer> findAllManufacturers() {
        return manufacturers;
    }

    @Override
    public Optional<Manufacturer> findManufacturerByName(String name) {
        return manufacturers.stream()
                .filter(manufacturer -> manufacturer.getName().equals(name))
                .findFirst();
    }
}
