package sk.stuba.fei.uim.oop.eshop;

import sk.stuba.fei.uim.oop.eshop.item.domain.Item;
import sk.stuba.fei.uim.oop.eshop.item.domain.Manufacturer;
import sk.stuba.fei.uim.oop.eshop.item.service.CategoryService;
import sk.stuba.fei.uim.oop.eshop.item.service.ItemService;
import sk.stuba.fei.uim.oop.eshop.item.service.ManufacturerService;
import sk.stuba.fei.uim.oop.eshop.user.service.AuthorisationService;
import sk.stuba.fei.uim.oop.eshop.user.service.UserService;

public class EShop {

    private AuthorisationService authorisationService;
    private UserService userService;
    private CategoryService categoryService;
    private ItemService itemService;
    private ManufacturerService manufacturerService;

    public EShop(AuthorisationService authorisationService, UserService userService, CategoryService categoryService, ItemService itemService, ManufacturerService manufacturerService) {
        this.authorisationService = authorisationService;
        this.userService = userService;
        this.categoryService = categoryService;
        this.itemService = itemService;
        this.manufacturerService = manufacturerService;
    }

    public AuthorisationService getAuthorisationService() {
        return authorisationService;
    }

    public void setAuthorisationService(AuthorisationService authorisationService) {
        this.authorisationService = authorisationService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public CategoryService getCategoryService() {
        return categoryService;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public ItemService getItemService() {
        return itemService;
    }

    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    public ManufacturerService getManufacturerService() {
        return manufacturerService;
    }

    public void setManufacturerService(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

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
