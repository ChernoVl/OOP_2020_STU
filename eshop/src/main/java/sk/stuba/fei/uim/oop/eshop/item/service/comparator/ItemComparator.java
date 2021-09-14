package sk.stuba.fei.uim.oop.eshop.item.service.comparator;

import sk.stuba.fei.uim.oop.eshop.item.domain.Item;

import java.util.Comparator;

public class ItemComparator implements Comparator<Item> {

    private static ItemComparator instance;

    private ItemComparator() {
    }

    public static ItemComparator getInstance() {
        if (instance == null) {
            instance = new ItemComparator();
        }
        return instance;
    }

    @Override
    public int compare(Item first, Item second) {
        return first.getName().compareTo(second.getName());
    }
}
