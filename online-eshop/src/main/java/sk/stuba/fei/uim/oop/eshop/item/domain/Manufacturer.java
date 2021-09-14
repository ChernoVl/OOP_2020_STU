package sk.stuba.fei.uim.oop.eshop.item.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Manufacturer implements WithName {

    private String name;
}
