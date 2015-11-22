package edu.ufrgs.pedrovereza.domain;

import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertTrue;
import org.junit.Test;

import java.util.Random;

public class KnapsackTest {

    private class FakeRandom extends Random {

        @Override
        public double nextDouble() {
            return 0.1;
        }
    }

    @Test
    public void mutation_changes_phenotype() throws Exception {
        Instance instance = new Instance(asList(new Item(0, 5), new Item(1, 10), new Item(2, 3)), null);

        Knapsack knapsack = new Knapsack(instance, new boolean[]{true, false, false}, new FakeRandom());

        int previousValue = knapsack.totalValue();
        knapsack.mutate();
        int newValue = knapsack.totalValue();

        assertTrue(previousValue != newValue);

    }
}
