package edu.ufrgs.pedrovereza.genetic;

public interface ChromosomeGenerator<T extends Chromosome<T>> {

    T generate(int size);
}
