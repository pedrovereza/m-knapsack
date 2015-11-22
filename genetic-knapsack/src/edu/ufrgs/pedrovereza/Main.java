package edu.ufrgs.pedrovereza;

import edu.ufrgs.pedrovereza.domain.Instance;
import edu.ufrgs.pedrovereza.domain.Knapsack;
import edu.ufrgs.pedrovereza.domain.KnapsackSolver;
import edu.ufrgs.pedrovereza.domain.io.InstanceParser;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {

        Instance instance = null;
        try {
            instance = new InstanceParser().parseFile(args[0]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Knapsack optimalKnapsack = new KnapsackSolver(instance).solve();

        System.out.println(optimalKnapsack.totalValue());
        System.out.println(optimalKnapsack);

    }
}
