package edu.ufrgs.pedrovereza.domain;

import static java.util.Arrays.asList;
import edu.ufrgs.pedrovereza.genetic.Chromosome;

import java.util.List;
import java.util.Random;

public class Knapsack implements Chromosome<Knapsack> {

    private final Instance instance;

    private final boolean[] itemsTaken;
    private final Random random;

    public Knapsack(Instance instance, boolean[] itemsTaken, Random random) {
        this.instance = instance;
        this.random = random;
        this.itemsTaken = itemsTaken;
    }

    public int totalValue() {
        int totalValue = 0;

        for (Item item : instance.items()) {
            if (hasItem(item)) {
                totalValue += item.getValue();
            }
        }

        return totalValue;
    }

    public int sizeInDimension(Dimension dimension) {
        int totalSize = 0;
        for (Item item : instance.items()) {
            if (hasItem(item)) {
                totalSize += item.getSizeAtDimension(dimension);
            }
        }

        return totalSize;
    }

    public boolean hasItem(Item item) {
        return itemsTaken[item.getIndex()];
    }

    @Override
    public Knapsack mutate() {
        boolean [] itemsTakenCopy = itemsTaken.clone();

        for (int i = 0; i < itemsTakenCopy.length; ++i) {
            if (random.nextDouble() < 0.10) {
                itemsTakenCopy[i] = !itemsTakenCopy[i];
            }
        }

        return new Knapsack(instance, itemsTakenCopy, random);
    }

    @Override
    public List<Knapsack> crossOverWith(Knapsack other) {
        boolean[] itemsTakenOffspring1 = itemsTaken.clone();
        boolean[] itemsTakenOffspring2 = itemsTaken.clone();

        int partition = (int) (random.nextDouble() * itemsTaken.length);
//        System.out.println("partition: " + partition);

        for (int i = 0; i <= partition; ++i) {
            itemsTakenOffspring1[i] =  itemsTaken[i];
            itemsTakenOffspring2[i] =  other.itemsTaken[i];

        }

        for (int i = partition + 1; i < itemsTaken.length; ++i) {
            itemsTakenOffspring1[i] =  other.itemsTaken[i];
            itemsTakenOffspring2[i] =  itemsTaken[i];
        }

        return asList(new Knapsack(instance, itemsTakenOffspring1, random),
                new Knapsack(instance, itemsTakenOffspring2, random));
    }

    @Override
    public String toString() {
        String str = "itemsTaken=";

        for (boolean itemTaken : itemsTaken) {
            str += itemTaken ? "1" : "0";
        }

        return str;
    }

    @Override
    public Knapsack copy() {
        boolean[] itemsTakenCopy = itemsTaken.clone();

        return new Knapsack(instance, itemsTakenCopy, random);
    }
}
