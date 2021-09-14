package sk.stuba.fei.uim.oop.eshop.item.domain;

import lombok.*;

@Data
@AllArgsConstructor
public class Item implements WithName {

    @Setter(AccessLevel.PROTECTED)
    private String name;
    private Float price;
    private Manufacturer manufacturer;
    private Category category;
}
