package edu.ufrgs.pedrovereza.genetic;

import java.util.List;

public interface Chromosome<T extends Chromosome<T>> {

    T mutate();
    List<T> crossOverWith(T other);
}
