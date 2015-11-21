package edu.ufrgs.pedrovereza.genetic;

import static java.util.Collections.reverseOrder;
import edu.ufrgs.pedrovereza.domain.Instance;

import java.util.Random;

public class GeneticAlgorithm<T extends Chromosome<T>> {

    private Population<T> population;
    private T best;
    private Instance instance;
    private final ChromosomeGenerator<T> generator;
    private Random random;
    private int populationSize;
    private Fitness<T, Integer> fitness;

    public GeneticAlgorithm(Instance instance, ChromosomeGenerator<T> generator, Random random, Fitness<T, Integer> fitness) {
        this.random = random;
        this.instance = instance;
        this.generator = generator;
        this.fitness = fitness;
        this.populationSize = 20;
    }

    public GeneticAlgorithm<T> populationSize(int size) {
        this.populationSize = 20;
        return this;
    }

    public T run() {
        population = new Population<T>(populationSize);

        for (int i = 0; i < populationSize; ++i) {
            population.addChromosome(generator.generate(instance.items().size()));
        }


        for (int i = 0; i < 50; ++i) {
            population.sort(reverseOrder(fitness));

            this.best = population.getBest();

            Population<T> nextPopulation = new Population<T>(populationSize);

            for (T chromosome : population) {
                if (nextPopulation.size() == 6) {
                    break;
                }

                nextPopulation.addChromosome(chromosome);
            }

            nextPopulation.evolve();

            this.population = nextPopulation;

        }

        return best;
    }


}
