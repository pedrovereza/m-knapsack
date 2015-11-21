package edu.ufrgs.pedrovereza;

import edu.ufrgs.pedrovereza.domain.Dimension;
import edu.ufrgs.pedrovereza.domain.Instance;
import edu.ufrgs.pedrovereza.domain.Item;
import edu.ufrgs.pedrovereza.domain.Knapsack;
import edu.ufrgs.pedrovereza.domain.KnapsackFactory;
import edu.ufrgs.pedrovereza.domain.KnapsackFitness;
import edu.ufrgs.pedrovereza.genetic.GeneticAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        List<Item> items = new ArrayList<Item>(3);
        Item item1 = new Item(0,5);
        item1.addDimension(new Dimension(0, 6));
        item1.addDimension(new Dimension(1, 15));

        Item item2 = new Item(1,10);
        item2.addDimension(new Dimension(0, 4));
        item2.addDimension(new Dimension(1, 5));

        Item item3 = new Item(2, 15);
        item3.addDimension(new Dimension(0, 200));
        item3.addDimension(new Dimension(1, 20));


        List<Dimension> dimensions = new ArrayList<Dimension>(2);
        dimensions.add(new Dimension(0, 10));
        dimensions.add(new Dimension(1, 20));

        items.add(item1);
        items.add(item2);
        items.add(item3);

        Instance instance = new Instance(items, dimensions);

        Random random = new Random(666);

        KnapsackFactory factory = new KnapsackFactory(instance, random);

        KnapsackFitness knapsackFitness = new KnapsackFitness(instance);
        Knapsack optimal = new GeneticAlgorithm<Knapsack>(instance, factory, random, knapsackFitness).run();

        System.out.println(optimal.totalValue());
        System.out.println(optimal);
        System.out.println(knapsackFitness.calculate(optimal));

    }
}
