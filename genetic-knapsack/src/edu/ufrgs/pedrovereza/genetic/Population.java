package edu.ufrgs.pedrovereza.genetic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Population<T extends Chromosome<T>> implements Iterable<T> {

    private final List<T> chromosomes;
    private final int maxSize;
    private final Random random = new Random();

    public Population(int size) {
        this.maxSize = size;
        this.chromosomes = new ArrayList<T>(size);
    }

    public void addChromosome(T chromosome) {
        this.chromosomes.add(chromosome);
    }

    public void sort(Comparator<T> comparator) {
        Collections.sort(this.chromosomes, comparator);
    }

    public T getBest() {
        return chromosomes.get(0);
    }

    @Override
    public Iterator<T> iterator() {
        return new PopulationIterator();
    }

    public int size() {
        return this.chromosomes.size();
    }

    public void evolve() {

        while (size() < maxSize) {
            for (T chromosome : chromosomes) {
                chromosome.mutate();
            }

            for (int i = 0; i < maxSize; ++i) {

                for (T sibling : chromosomes.get(i).crossOverWith(randomChrosomose())) {
                    chromosomes.add(sibling);
                }
            }


        }

    }

    private T randomChrosomose() {
        return chromosomes.get((int) (random.nextDouble() * size()));
    }

    private class PopulationIterator implements Iterator<T> {

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < chromosomes.size() - 1;
        }

        @Override
        public T next() {
            return chromosomes.get(currentIndex++);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
