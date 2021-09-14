package sk.stuba.fei.uim.oop.eshop.item.service;

import sk.stuba.fei.uim.oop.eshop.item.domain.Manufacturer;

import java.util.Optional;
import java.util.Set;

public interface ManufacturerService {

    void addManufacturer(Manufacturer manufacturer);

    Set<Manufacturer> findAllManufacturers();

    Optional<Manufacturer> findManufacturerByName(String name);
}
