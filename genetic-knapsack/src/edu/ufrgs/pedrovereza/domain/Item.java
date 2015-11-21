package edu.ufrgs.pedrovereza.domain;

import java.util.ArrayList;
import java.util.List;

public class Item {

    private final int value;
    private final List<Dimension> dimensions;
    private final int index;

    public Item(int index, int value) {
        this.index = index;
        this.value = value;
        this.dimensions = new ArrayList<Dimension>();
    }

    public void addDimension(Dimension dimension) {
        this.dimensions.add(dimension);
    }

    public int getSizeAtDimension(Dimension dimension) {
        return this.dimensions.get(dimension.getIndex()).getSize();
    }

    public int getIndex() {
        return index;
    }

    public int getValue() {
        return value;
    }
}
