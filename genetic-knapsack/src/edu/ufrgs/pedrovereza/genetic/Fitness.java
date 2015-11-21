package edu.ufrgs.pedrovereza.genetic;

import java.util.Comparator;

public interface Fitness<T extends Chromosome<T>, U extends Comparable<U>> extends Comparator<T> {

    U calculate(T chromosome);

}