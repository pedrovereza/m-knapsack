package edu.ufrgs.pedrovereza.domain;

import edu.ufrgs.pedrovereza.genetic.GeneticAlgorithm;
import edu.ufrgs.pedrovereza.genetic.Population;

import java.util.Random;

public class KnapsackSolver {

    public static final int POPULATION_SIZE = 80;
    private final Random random = new Random();
    private Instance instance;

    public KnapsackSolver(Instance instance) {
        this.instance = instance;
    }

    public Knapsack solve() {
        KnapsackFitness knapsackFitness = new KnapsackFitness(instance);
        return new GeneticAlgorithm<Knapsack>(createInitialPopulation(), knapsackFitness)
                .run();
    }

    private Population<Knapsack> createInitialPopulation() {
        Population<Knapsack> population = new Population<Knapsack>(POPULATION_SIZE);
        KnapsackFactory factory = new KnapsackFactory(instance, random);

        for (int i = 0; i < POPULATION_SIZE; ++i) {
            population.addChromosome(factory.createWithSize(instance.numberOfItems()));
        }

        return population;
    }
}
