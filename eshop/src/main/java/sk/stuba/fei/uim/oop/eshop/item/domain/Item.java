package sk.stuba.fei.uim.oop.eshop.item.domain;

public class Item {

    private String name;
    private Float price;
    private Manufacturer manufacturer;
    private Category category;

    public Item(String name, Manufacturer manufacturer, Category category) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return name + " [ " + price + " € ]";
    }
}
