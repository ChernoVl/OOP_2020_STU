package sk.stuba.fei.uim.oop.eshop.item.domain;

import sk.stuba.fei.uim.oop.eshop.item.service.comparator.CategoryComparator;

import java.util.Set;
import java.util.TreeSet;

public class Category {

    private String name;
    private Set<Category> subcategories;

    public Category(String name) {
        this.name = name;
        this.subcategories = new TreeSet<>(CategoryComparator.getInstance());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Category> getSubcategories() {
        return subcategories;
    }

    public void addSubcategory(Category subcategory) {
        this.subcategories.add(subcategory);
    }

    public void removeSubcategory(Category subcategory) {
        this.subcategories.remove(subcategory);
    }

    public String toStringTree(String tabs) {
        StringBuilder builder = new StringBuilder();
        builder.append(tabs).append(name).append("\n");
        for (Category subcategory : subcategories) {
            builder.append(subcategory.toStringTree(tabs+" "));
        }
        return builder.toString();
    }
}
