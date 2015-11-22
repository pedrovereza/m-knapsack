package edu.ufrgs.pedrovereza.domain;

import static java.util.Collections.unmodifiableCollection;

import java.util.Collection;
import java.util.List;

public class Instance {
    private final List<Item> items;
    private final List<Dimension> dimensions;

    public Instance(List<Item> items, List<Dimension> dimensions) {
        this.items = items;
        this.dimensions = dimensions;
    }

    public Collection<Item> items() {
        return unmodifiableCollection(items);
    }

    public Collection<Dimension> dimensions() {
        return unmodifiableCollection(dimensions);
    }

    public int numberOfItems() {
        return items.size();
    }
    public int numberOfDimension() {
        return dimensions.size();
    }
}
