package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.eshop.EShop;
import sk.stuba.fei.uim.oop.eshop.item.domain.Category;
import sk.stuba.fei.uim.oop.eshop.item.domain.Manufacturer;
import sk.stuba.fei.uim.oop.eshop.item.service.BasicItemService;
import sk.stuba.fei.uim.oop.eshop.user.domain.User;
import sk.stuba.fei.uim.oop.eshop.user.service.EmailPasswordUserService;

public class Main {

    public static final String EMAIL = "mazari@stuba.sk";
    public static final String PASSWORD = "heslo";

    public static final String[] manufacturers = {
            "Acer",
            "Apple",
            "ASUS",
            "Dell",
            "HP",
            "Lenovo",
            "MSI"
    };

    public static void main(String[] args) {
        EmailPasswordUserService emailPasswordUserService = new EmailPasswordUserService();
        BasicItemService basicItemService = new BasicItemService("Katalóg");
        EShop eShop = new EShop(emailPasswordUserService, emailPasswordUserService, basicItemService, basicItemService, basicItemService);

        for (String manufacturer : manufacturers) {
            eShop.getManufacturerService().addManufacturer(new Manufacturer(manufacturer));
        }
        Category notebooks = new Category("Notebooky");
        notebooks.addSubcategory(new Category("Herné"));
        notebooks.addSubcategory(new Category("Pracovné"));
        notebooks.addSubcategory(new Category("MacBook"));
        Category components = new Category("Komponenty");
        components.addSubcategory(new Category("Procesory"));
        components.addSubcategory(new Category("Grafické karty"));
        components.addSubcategory(new Category("Disky a SSD"));
        components.addSubcategory(new Category("Pamäte RAM"));
        components.addSubcategory(new Category("Základné dosky"));
        Category photo = new Category("Foto Audio Video");
        photo.addSubcategory(new Category("Slúchadlá"));
        photo.addSubcategory(new Category("Reproduktory"));
        photo.addSubcategory(new Category("Digitálne kamery"));
        photo.addSubcategory(new Category("Digitálne fotoaparáty"));
        photo.addSubcategory(new Category("Objektívy"));
        Category root = eShop.getCategoryService().getRootCategory();
        root.addSubcategory(notebooks);
        root.addSubcategory(components);
        root.addSubcategory(photo);
        System.out.println(eShop);

        User user = eShop.getUserService().register(EMAIL, PASSWORD, "Juraj", "Mazari");
        assert user != null;


        if (eShop.getAuthorisationService().logIn(EMAIL, PASSWORD)) {
            System.out.println(eShop.getUserService().findUserByEmail(EMAIL));
        } else {
            System.out.println("Login failed");
        }
    }
}
