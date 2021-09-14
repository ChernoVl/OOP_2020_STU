package sk.stuba.fei.uim.oop.eshop.item.service.comparator;

import sk.stuba.fei.uim.oop.eshop.item.domain.Manufacturer;

import java.util.Comparator;

public class ManufacturerComparator implements Comparator<Manufacturer> {

    private static ManufacturerComparator instance;

    private ManufacturerComparator() {
    }

    public static ManufacturerComparator getInstance() {
        if (instance == null) {
            instance = new ManufacturerComparator();
        }
        return instance;
    }

    @Override
    public int compare(Manufacturer first, Manufacturer second) {
        return first.getName().compareTo(second.getName());
    }
}
