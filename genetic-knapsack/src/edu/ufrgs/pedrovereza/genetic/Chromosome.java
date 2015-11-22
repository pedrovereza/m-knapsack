package edu.ufrgs.pedrovereza.genetic;

import java.util.List;

public interface Chromosome<T extends Chromosome<T>> extends Copyable<T> {

    T mutate();
    List<T> crossOverWith(T other);
}
