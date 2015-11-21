package edu.ufrgs.pedrovereza.domain;

public class Dimension {

    private final int index;
    private final int size;

    public Dimension(int index, int size) {
        this.index = index;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public int getIndex() {
        return index;
    }
}
