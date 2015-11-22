package edu.ufrgs.pedrovereza.domain;

import edu.ufrgs.pedrovereza.genetic.ChromosomeFactory;

import java.util.Random;

public class KnapsackFactory implements ChromosomeFactory<Knapsack> {

    private final Instance instance;
    private Random random;

    public KnapsackFactory(Instance instance, Random random) {
        this.instance = instance;
        this.random = random;
    }

    @Override
    public Knapsack createWithSize(int size) {
        boolean [] itemsTaken = new boolean[size];

        for (int i = 0; i < size; ++i) {
            if (random.nextDouble() > 0.50) {
                itemsTaken[i] = true;
            }
        }

        return new Knapsack(instance, itemsTaken, random);
    }
}
