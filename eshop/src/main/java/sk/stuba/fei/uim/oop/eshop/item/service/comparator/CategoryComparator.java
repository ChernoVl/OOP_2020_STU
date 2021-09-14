package sk.stuba.fei.uim.oop.eshop.item.service.comparator;

import sk.stuba.fei.uim.oop.eshop.item.domain.Category;

import java.util.Comparator;

/**
 * Pouzity navrhovy vzor Singleton
 */
public class CategoryComparator implements Comparator<Category> {

    private static CategoryComparator instance;

    private CategoryComparator() {}

    public static CategoryComparator getInstance() {
        if (instance == null) {
            instance = new CategoryComparator();
        }
        return instance;
    }

    @Override
    public int compare(Category first, Category second) {
        return first.getName().compareTo(second.getName());
    }
}
