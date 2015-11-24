package edu.ufrgs.pedrovereza.genetic;

import static java.util.Collections.reverseOrder;

import java.util.Random;

public class GeneticAlgorithm<T extends Chromosome<T>> {

    private final Fitness<T, Integer> fitness;
    private final Random random;
    private Population<T> population;
    private T best;
    private int generationsWithoutImprovement = 0;


    public GeneticAlgorithm(Population<T> population, Fitness<T, Integer> fitness, Random random) {
        this.population = population;
        this.fitness = fitness;
        this.random = random;
        this.best = population.getBest();
    }

    public T run() {
        long startTime = System.currentTimeMillis();

        int populationSize = population.size();

        while (generationsWithoutImprovement < 5000) {

            population.sort(reverseOrder(fitness));
            population.trim();

            T bestOfGeneration = population.getBest();

            if (fitness.calculate(best) < fitness.calculate(bestOfGeneration)) {
                long estimatedTime = System.currentTimeMillis() - startTime;

                System.out.println("New best: " + fitness.calculate(bestOfGeneration) + " found at: " + estimatedTime
                        / 1000.0);

                this.best = bestOfGeneration.copy();
                generationsWithoutImprovement = 0;
            }

            Population<T> nextPopulation = new Population<T>(populationSize, random);

            for (T chromosome : population) {
                if (nextPopulation.size() == 10) {
                    break;
                }

                nextPopulation.addChromosome(chromosome);
            }

            for (int j = 0; j < 5; ++j) {
                nextPopulation.addChromosome(population.randomChromosome());
            }

            nextPopulation.evolve();

            this.population = nextPopulation;

            generationsWithoutImprovement++;


        }



        return best;
    }
}
