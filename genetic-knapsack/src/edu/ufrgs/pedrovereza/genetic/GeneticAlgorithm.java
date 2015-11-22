package edu.ufrgs.pedrovereza.genetic;

import static java.util.Collections.reverseOrder;

public class GeneticAlgorithm<T extends Chromosome<T>> {

    private final Fitness<T, Integer> fitness;
    private Population<T> population;
    private T best;

    public GeneticAlgorithm(Population<T> population, Fitness<T, Integer> fitness) {
        this.population = population;
        this.fitness = fitness;
        this.best = population.getBest();
    }

    public T run() {

        int populationSize = population.size();

        for (int i = 0; i < 3000; ++i) {

            for (T c : population) {
                System.out.println(fitness.calculate(c));
            }

            population.sort(reverseOrder(fitness));

            T bestOfGeneration = population.getBest();

//            System.out.println("Best of generation:" + fitness.calculate(bestOfGeneration));
            if (fitness.calculate(best) < fitness.calculate(bestOfGeneration)) {
                this.best = bestOfGeneration.copy();
            }

            Population<T> nextPopulation = new Population<T>(populationSize);

            for (T chromosome : population) {
                if (nextPopulation.size() == 10) {
                    break;
                }

                nextPopulation.addChromosome(chromosome);
            }

            for (int j = 0; j < 6; ++j) {
                nextPopulation.addChromosome(population.randomChrosomose());
            }

            nextPopulation.evolve();

            this.population = nextPopulation;

        }



        return best;
    }
}
