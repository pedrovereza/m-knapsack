package edu.ufrgs.pedrovereza.genetic;

public interface ChromosomeFactory<T extends Chromosome<T>> {

    T createWithSize(int size);
}
