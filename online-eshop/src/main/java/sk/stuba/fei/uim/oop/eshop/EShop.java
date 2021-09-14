package sk.stuba.fei.uim.oop.eshop;

import lombok.AllArgsConstructor;
import lombok.Data;
import sk.stuba.fei.uim.oop.eshop.item.domain.Item;
import sk.stuba.fei.uim.oop.eshop.item.domain.Manufacturer;
import sk.stuba.fei.uim.oop.eshop.item.service.CategoryService;
import sk.stuba.fei.uim.oop.eshop.item.service.ItemService;
import sk.stuba.fei.uim.oop.eshop.item.service.ManufacturerService;
import sk.stuba.fei.uim.oop.eshop.user.service.AuthorisationService;
import sk.stuba.fei.uim.oop.eshop.user.service.UserService;

@Data
@AllArgsConstructor
public class EShop {

    private UserService userService;
    private AuthorisationService authorisationService;

    private ItemService itemService;
    private ManufacturerService manufacturerService;
    private CategoryService categoryService;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("eShop:\n");

        builder.append("\nMANUFACTURERS:\n");
        for (Manufacturer manufacturer : manufacturerService.findAllManufacturers()) {
            builder.append(" ").append(manufacturer).append("\n");
        }

        builder.append("\nCATEGORIES:\n");
        builder.append(categoryService.getRootCategory().toStringTree(" "));

        builder.append("\nITEMS:\n");
        for (Item item : itemService.findAllItems()) {
            builder.append(" ").append(item).append("\n");
        }

        return builder.toString();
    }
}
