package edu.ufrgs.pedrovereza.domain;

import edu.ufrgs.pedrovereza.genetic.ChromosomeGenerator;

import java.util.BitSet;
import java.util.Random;

public class KnapsackFactory implements ChromosomeGenerator<Knapsack> {

    private final Instance instance;
    private Random random;

    public KnapsackFactory(Instance instance, Random random) {
        this.instance = instance;
        this.random = random;
    }

    @Override
    public Knapsack generate(int size) {
        BitSet bitSet = new BitSet(size);

        for (int i = 0; i < size; ++i) {
            if (random.nextDouble() > 0.50)
                bitSet.set(i);
        }

        for (int i = 0; i < size; ++i) {
            System.out.println(bitSet.get(i) ? '1' : '0');
        }


        return new Knapsack(instance, bitSet, random);
    }
}
