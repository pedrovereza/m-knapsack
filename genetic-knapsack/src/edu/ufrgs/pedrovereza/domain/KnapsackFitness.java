package edu.ufrgs.pedrovereza.domain;

import edu.ufrgs.pedrovereza.genetic.Fitness;

public class KnapsackFitness implements Fitness<Knapsack, Integer> {

    private final Instance instance;

    public KnapsackFitness(Instance instance) {
        this.instance = instance;
    }

    @Override
    public Integer calculate(Knapsack knapsack) {
        int penalty = penaltyForExceeding(knapsack);

        if (penalty != 0) {
            return -penalty;
        }

        return knapsack.totalValue();
    }

    private int penaltyForExceeding(Knapsack knapsack) {
        int penalty = 0;

        for (Dimension dimension : instance.dimensions()) {
            int delta = knapsack.sizeInDimension(dimension) - dimension.getSize();

            if (delta > 0) {
                penalty += delta;
            }
        }

        return penalty;
    }

    @Override
    public int compare(Knapsack o1, Knapsack o2) {
        return calculate(o1).compareTo(calculate(o2));
    }
}
