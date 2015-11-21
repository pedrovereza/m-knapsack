package edu.ufrgs.pedrovereza.domain;

import static java.util.Arrays.asList;
import edu.ufrgs.pedrovereza.genetic.Chromosome;

import java.util.BitSet;
import java.util.List;
import java.util.Random;

public class Knapsack implements Chromosome<Knapsack> {

    private final Instance instance;

    private final BitSet itemsTaken;
    private final Random random;

    public Knapsack(Instance instance, BitSet itemsTaken, Random random) {
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
        return itemsTaken.get(item.getIndex());
    }

    @Override
    public Knapsack mutate() {
        for (int i = 0; i < itemsTaken.size(); ++i) {
            if (random.nextDouble() < 0.10) {
                itemsTaken.flip(i);
            }
        }

        return null;
    }

    @Override
    public List<Knapsack> crossOverWith(Knapsack other) {
        BitSet itemsTakenSimbling1 = new BitSet(itemsTaken.size());
        BitSet itemsTakenSimbling2 = new BitSet(itemsTaken.size());

        int partition = itemsTaken.size() / 2;

        for (int i = 0; i <= partition; ++i) {
            itemsTakenSimbling1.set(i, itemsTaken.get(i));
            itemsTakenSimbling2.set(i, other.itemsTaken.get(i));
        }

        for (int i = partition + 1; i < itemsTaken.size(); ++i) {
            itemsTakenSimbling1.set(i, other.itemsTaken.get(i));
            itemsTakenSimbling2.set(i, itemsTaken.get(i));
        }

        return asList(new Knapsack(instance, itemsTakenSimbling1, random),
                new Knapsack(instance, itemsTakenSimbling2, random));
    }

    @Override
    public String toString() {
        String str = "itemsTaken=";

        for (int i = 0; i < instance.items().size(); ++i) {
            str += itemsTaken.get(i) ? "1" : "0";
        }

        return str;
    }
}
