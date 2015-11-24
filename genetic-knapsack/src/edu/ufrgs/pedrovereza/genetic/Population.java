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
    private final Random random;

    public Population(int size, Random random) {
        this.maxSize = size;
        this.random = random;
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

            int currentSize = size();

            for (int i = 0; i < currentSize; ++i) {
                chromosomes.add(chromosomes.get(i).mutate());
            }

            for (int i = 0; i < maxSize && size() < maxSize; ++i) {

                for (T sibling : chromosomes.get(i).crossOverWith(randomChromosome())) {
                    chromosomes.add(sibling);
                }
            }

        }

    }

    public void trim() {
        this.chromosomes.subList(0, maxSize - 1);
    }

    public T randomChromosome() {
        return chromosomes.get((int) (random.nextDouble() * size()));
    }

    private class PopulationIterator implements Iterator<T> {

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < chromosomes.size();
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
