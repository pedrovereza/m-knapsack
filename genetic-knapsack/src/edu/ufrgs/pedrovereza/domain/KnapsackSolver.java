package edu.ufrgs.pedrovereza.domain;

import edu.ufrgs.pedrovereza.genetic.GeneticAlgorithm;
import edu.ufrgs.pedrovereza.genetic.Population;

import java.util.Random;

public class KnapsackSolver {

    private final Random random = new Random();
    private Instance instance;
    private final Integer populationSize;

    public KnapsackSolver(Instance instance, Integer populationSize) {
        this.instance = instance;
        this.populationSize = populationSize;
    }

    public Knapsack solve() {
        KnapsackFitness knapsackFitness = new KnapsackFitness(instance);
        return new GeneticAlgorithm<Knapsack>(createInitialPopulation(), knapsackFitness, random)
                .run();
    }

    private Population<Knapsack> createInitialPopulation() {
        Population<Knapsack> population = new Population<Knapsack>(populationSize, random);

        KnapsackFactory factory = new KnapsackFactory(instance, random);

        for (int i = 0; i < populationSize; ++i) {
            population.addChromosome(factory.createWithSize(instance.numberOfItems()));
        }

        return population;
    }
}
